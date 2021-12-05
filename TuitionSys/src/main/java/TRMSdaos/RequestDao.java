package TRMSdaos;


import java.sql.*;
import java.util.*;

import trms_Models.Request;
import trms_Models.RequestOld;
//import trms_Utilities.DatabaseConnection;

import java.math.*;


 /**
  * Request Data Access Object (DAO).
  * This class contains all database handling that is needed to 
  * permanently store and retrieve Request object instances. 
  */




public class RequestDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public Request createValueObject() {
          return new Request();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public Request getObject(Connection conn, int requestID) throws NotFoundException, SQLException {

          Request valueObject = createValueObject();
          valueObject.setRequestID(requestID);
          load(conn, valueObject);
          return valueObject;
    }


    /**
     * load-method. This will load valueObject contents from database using
     * Primary-Key as identifier. Upper layer should use this so that valueObject
     * instance is created and only primary-key should be specified. Then call
     * this method to complete other persistent information. This method will
     * overwrite all other fields except primary-key and possible runtime variables.
     * If load can not find matching row, NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be loaded.
     *                     Primary-key field must be set for this to work properly.
     */
    public void load(Connection conn, Request valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM Request WHERE (RequestID = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getRequestID()); 

               singleQuery(conn, stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * LoadAll-method. This will read all contents from database table and
     * build a List containing valueObjects. Please note, that this method
     * will consume huge amounts of resources if table has lot's of rows. 
     * This should only be used when target tables have only small amounts
     * of data.
     *
     * @param conn         This method requires working database connection.
     */
    public List loadAll(Connection conn) throws SQLException {

          String sql = "SELECT * FROM Request ORDER BY RequestID ASC ";
          List searchResults = listQuery(conn, conn.prepareStatement(sql));

          return searchResults;
    }



    /**
     * create-method. This will create new row in database according to supplied
     * valueObject contents. Make sure that values for all NOT NULL columns are
     * correctly specified. Also, if this table does not use automatic surrogate-keys
     * the primary-key must be specified. After INSERT command this method will 
     * read the generated primary-key back to valueObject if automatic surrogate-keys
     * were used. 
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be created.
     *                     If automatic surrogate-keys are not used the Primary-key 
     *                     field must be set for this to work properly.
     */
    public synchronized void create(Connection conn, Request valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO Request ( RequestID, PersonID, ROrigAmount, "
               + "RAdjAmount, EventID, RStatus, "
               + "REmployeeJustification, RBenefitJustification, FileID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getRequestID()); 
               stmt.setInt(2, valueObject.getPersonID()); 
               stmt.setInt(3, valueObject.getOriginalAmount()); 
               stmt.setInt(4, valueObject.getAdjustedAmount()); 
               stmt.setInt(5, valueObject.getEventID()); 
               stmt.setString(6, valueObject.getStatus()); 
               stmt.setString(7, valueObject.getEmployeeReason()); 
               stmt.setString(8, valueObject.getOverrideReason()); 
               stmt.setInt(9, valueObject.getFileID()); 

               int rowcount = databaseUpdate(conn, stmt);
               if (rowcount != 1) {
                    //System.out.println("PrimaryKey Error when updating DB!");
                    throw new SQLException("PrimaryKey Error when updating DB!");
               }

          } finally {
              if (stmt != null)
                  stmt.close();
          }


    }


    /**
     * save-method. This method will save the current state of valueObject to database.
     * Save can not be used to create new instances in database, so upper layer must
     * make sure that the primary-key is correctly specified. Primary-key will indicate
     * which instance is going to be updated in database. If save can not find matching 
     * row, NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be saved.
     *                     Primary-key field must be set for this to work properly.
     */
    public void save(Connection conn, Request valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE Request SET PersonID = ?, ROrigAmount = ?, RAdjAmount = ?, "
               + "EventID = ?, RStatus = ?, REmployeeJustification = ?, "
               + "RBenefitJustification = ?, FileID = ? WHERE (RequestID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getPersonID()); 
              stmt.setInt(2, valueObject.getOriginalAmount()); 
              stmt.setInt(3, valueObject.getAdjustedAmount()); 
              stmt.setInt(4, valueObject.getEventID()); 
              stmt.setString(5, valueObject.getStatus()); 
              stmt.setString(6, valueObject.getEmployeeReason()); 
              stmt.setString(7, valueObject.getOverrideReason()); 
              stmt.setInt(8, valueObject.getFileID()); 

              stmt.setInt(9, valueObject.getRequestID()); 

              int rowcount = databaseUpdate(conn, stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be saved! (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * delete-method. This method will remove the information from database as identified by
     * by primary-key in supplied valueObject. Once valueObject has been deleted it can not 
     * be restored by calling save. Restoring can only be done using create method but if 
     * database is using automatic surrogate-keys, the resulting object will have different 
     * primary-key than what it was in the deleted object. If delete can not find matching row,
     * NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be deleted.
     *                     Primary-key field must be set for this to work properly.
     */
    public void delete(Connection conn, Request valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM Request WHERE (RequestID = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getRequestID()); 

              int rowcount = databaseUpdate(conn, stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be deleted (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * deleteAll-method. This method will remove all information from the table that matches
     * this Dao and ValueObject couple. This should be the most efficient way to clear table.
     * Once deleteAll has been called, no valueObject that has been created before can be 
     * restored by calling save. Restoring can only be done using create method but if database 
     * is using automatic surrogate-keys, the resulting object will have different primary-key 
     * than what it was in the deleted object. (Note, the implementation of this method should
     * be different with different DB backends.)
     *
     * @param conn         This method requires working database connection.
     */
    public void deleteAll(Connection conn) throws SQLException {

          String sql = "DELETE FROM Request";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              int rowcount = databaseUpdate(conn, stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * coutAll-method. This method will return the number of all rows from table that matches
     * this Dao. The implementation will simply execute "select count(primarykey) from table".
     * If table is empty, the return value is 0. This method should be used before calling
     * loadAll, to make sure table has not too many rows.
     *
     * @param conn         This method requires working database connection.
     */
    public int countAll(Connection conn) throws SQLException {

          String sql = "SELECT count(*) FROM Request";
          PreparedStatement stmt = null;
          ResultSet result = null;
          int allRows = 0;

          try {
              stmt = conn.prepareStatement(sql);
              result = stmt.executeQuery();

              if (result.next())
                  allRows = result.getInt(1);
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
          return allRows;
    }


    /** 
     * searchMatching-Method. This method provides searching capability to 
     * get matching valueObjects from database. It works by searching all 
     * objects that match permanent instance variables of given object.
     * Upper layer should use this by setting some parameters in valueObject
     * and then  call searchMatching. The result will be 0-N objects in a List, 
     * all matching those criteria you specified. Those instance-variables that
     * have NULL values are excluded in search-criteria.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance where search will be based.
     *                     Primary-key field should not be set.
     */
    public List searchMatching(Connection conn, Request valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM Request WHERE 1=1 ");

          if (valueObject.getRequestID() != 0) {
              if (first) { first = false; }
              sql.append("AND RequestID = ").append(valueObject.getRequestID()).append(" ");
          }

          if (valueObject.getPersonID() != 0) {
              if (first) { first = false; }
              sql.append("AND PersonID = ").append(valueObject.getPersonID()).append(" ");
          }

          if (valueObject.getOriginalAmount() != 0) {
              if (first) { first = false; }
              sql.append("AND ROrigAmount = ").append(valueObject.getOriginalAmount()).append(" ");
          }

          if (valueObject.getAdjustedAmount() != 0) {
              if (first) { first = false; }
              sql.append("AND RAdjAmount = ").append(valueObject.getAdjustedAmount()).append(" ");
          }

          if (valueObject.getEventID() != 0) {
              if (first) { first = false; }
              sql.append("AND EventID = ").append(valueObject.getEventID()).append(" ");
          }

          if (valueObject.getStatus() != null) {
              if (first) { first = false; }
              sql.append("AND RStatus LIKE '").append(valueObject.getStatus()).append("%' ");
          }

          if (valueObject.getEmployeeReason() != null) {
              if (first) { first = false; }
              sql.append("AND REmployeeJustification LIKE '").append(valueObject.getEmployeeReason()).append("%' ");
          }

          if (valueObject.getOverrideReason() != null) {
              if (first) { first = false; }
              sql.append("AND RBenefitJustification LIKE '").append(valueObject.getOverrideReason()).append("%' ");
          }

          if (valueObject.getFileID() != 0) {
              if (first) { first = false; }
              sql.append("AND FileID = ").append(valueObject.getFileID()).append(" ");
          }


          sql.append("ORDER BY RequestID ASC ");

          // Prevent accidential full table results.
          // Use loadAll if all rows must be returned.
          if (first)
               searchResults = new ArrayList();
          else
               searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

          return searchResults;
    }


    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }


    /**
     * databaseUpdate-method. This method is a helper method for internal use. It will execute
     * all database handling that will change the information in tables. SELECT queries will
     * not be executed here however. The return value indicates how many rows were affected.
     * This method will also make sure that if cache is used, it will reset when data changes.
     *
     * @param conn         This method requires working database connection.
     * @param stmt         This parameter contains the SQL statement to be excuted.
     */
    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {

          int result = stmt.executeUpdate();

          return result;
    }



    /**
     * databaseQuery-method. This method is a helper method for internal use. It will execute
     * all database queries that will return only one row. The resultset will be converted
     * to valueObject. If no rows were found, NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param stmt         This parameter contains the SQL statement to be excuted.
     * @param valueObject  Class-instance where resulting data will be stored.
     */
    protected void singleQuery(Connection conn, PreparedStatement stmt, Request valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setRequestID(result.getInt("RequestID")); 
                   valueObject.setPersonID(result.getInt("PersonID")); 
                   valueObject.setOriginalAmount(result.getInt("ROrigAmount")); 
                   valueObject.setAdjustedAmount(result.getInt("RAdjAmount")); 
                   valueObject.setEventID(result.getInt("EventID")); 
                   valueObject.setStatus(result.getString("RStatus")); 
                   valueObject.setEmployeeReason(result.getString("REmployeeJustification")); 
                   valueObject.setOverrideReason(result.getString("RBenefitJustification")); 
                   valueObject.setFileID(result.getInt("FileID")); 

              } else {
                    //System.out.println("Request Object Not Found!");
                    throw new NotFoundException("Request Object Not Found!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * databaseQuery-method. This method is a helper method for internal use. It will execute
     * all database queries that will return multiple rows. The resultset will be converted
     * to the List of valueObjects. If no rows were found, an empty List will be returned.
     *
     * @param conn         This method requires working database connection.
     * @param stmt         This parameter contains the SQL statement to be excuted.
     */
    protected List listQuery(Connection conn, PreparedStatement stmt) throws SQLException {

          ArrayList searchResults = new ArrayList();
          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              while (result.next()) {
                   Request temp = createValueObject();

                   temp.setRequestID(result.getInt("RequestID")); 
                   temp.setPersonID(result.getInt("PersonID")); 
                   temp.setOriginalAmount(result.getInt("ROrigAmount")); 
                   temp.setAdjustedAmount(result.getInt("RAdjAmount")); 
                   temp.setEventID(result.getInt("EventID")); 
                   temp.setStatus(result.getString("RStatus")); 
                   temp.setEmployeeReason(result.getString("REmployeeJustification")); 
                   temp.setOverrideReason(result.getString("RBenefitJustification")); 
                   temp.setFileID(result.getInt("FileID")); 

                   searchResults.add(temp);
              }

          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }

          return (List)searchResults;
    }


    public static void main (String[] args) {
		//try {
//		private int requestID;
//		private int personID;
//		private int originalAmount;
//		private int adjustedAmount;
//		private int eventID;
//		private String status;
//		private String employeeJustification;
//		private String overrideJustification;
//		private int fileID;
    	
    	//Get database connection.
    	//Connection database = DatabaseConnection.getConnection();

		
		RequestDao testDAO = new RequestDao();
		
		//Test creating request
		Request newReq = new Request();
		Request newReq2 = new Request();
		Request newReq3 = new Request();
		List<Request> allReq;
		
		newReq.setRequestID(1234);
		newReq.setPersonID(34);
		newReq.setOriginalAmount(400);
		newReq.setAdjustedAmount(3000);
		newReq.setEventID(12);
		newReq.setStatus("TestingStatus");
		newReq.setEmployeeReason("My employer said yes");
		newReq.setOverrideReason("My benefit coordinator said yes");
		newReq.setFileID(8);
		newReq2.setRequestID(5678);
		newReq2.setPersonID(23);
		newReq2.setOriginalAmount(654);
		newReq2.setAdjustedAmount(7653);
		newReq2.setEventID(65);
		newReq2.setStatus("ThisIsATest");
		newReq2.setEmployeeReason("My employer was nice");
		newReq2.setOverrideReason("My benefit coordinator is cool");
		newReq2.setFileID(8);	
		//testDAO.create(database, newReq);
		//testDAO.create(database, newReq2);
		
		//Test reading request
		newReq3.setRequestID(1234);
		//testDAO.load(database, newReq3);
		System.out.println(newReq3);

		//Test reading all requests
		//allReq = testDAO.loadAll(database);
		//System.out.println(allReq);
		
		//Test deleting requests
		//testDAO.delete(database, newReq);
		//testDAO.delete(database, newReq2);
		//testDAO.delete(database, newReq3);
		
		
		//} catch (SQLException e) {
		///	System.out.println("SQL Exception Caught");
	//		e.printStackTrace();
	//	} catch (NotFoundException e) {
	//		System.out.println("NotFound Exception Caught");
	//		e.printStackTrace();
	//	}
  //  }
    
    
}
}

             
