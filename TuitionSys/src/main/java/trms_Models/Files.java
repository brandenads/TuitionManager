package trms_Models;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * Files Value Object.
  * This class is value object representing database table Files
  * This class is intented to be used together with associated Dao object.
  */

 /**
  * This sourcecode has been generated by FREE DaoGen generator version 2.4.1.
  * The usage of generated code is restricted to OpenSource software projects
  * only. DaoGen is available in http://titaniclinux.net/daogen/
  * It has been programmed by Tuomo Lukka, Tuomo.Lukka@iki.fi
  *
  * DaoGen license: The following DaoGen generated source code is licensed
  * under the terms of GNU GPL license. The full text for license is available
  * in GNU project's pages: http://www.gnu.org/copyleft/gpl.html
  *
  * If you wish to use the DaoGen generator to produce code for closed-source
  * commercial applications, you must pay the lisence fee. The price is
  * 5 USD or 5 Eur for each database table, you are generating code for.
  * (That includes unlimited amount of iterations with all supported languages
  * for each database table you are paying for.) Send mail to
  * "Tuomo.Lukka@iki.fi" for more information. Thank you!
  */



public class Files implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int eventID;
    private String filename;
    private String fileData;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Files () {

    }

    public Files (int eventIDIn) {

          this.eventID = eventIDIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getEventID() {
          return this.eventID;
    }
    public void setEventID(int eventIDIn) {
          this.eventID = eventIDIn;
    }

    public String getFilename() {
          return this.filename;
    }
    public void setFilename(String filenameIn) {
          this.filename = filenameIn;
    }

    public String getFileData() {
          return this.fileData;
    }
    public void setFileData(String fileDataIn) {
          this.fileData = fileDataIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int eventIDIn,
          String filenameIn,
          String fileDataIn) {
          this.eventID = eventIDIn;
          this.filename = filenameIn;
          this.fileData = fileDataIn;
    }


    /** 
     * hasEqualMapping-method will compare two Files instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Files valueObject) {

          if (valueObject.getEventID() != this.eventID) {
                    return(false);
          }
          if (this.filename == null) {
                    if (valueObject.getFilename() != null)
                           return(false);
          } else if (!this.filename.equals(valueObject.getFilename())) {
                    return(false);
          }
          if (this.fileData == null) {
                    if (valueObject.getFileData() != null)
                           return(false);
          } else if (!this.fileData.equals(valueObject.getFileData())) {
                    return(false);
          }

          return true;
    }



    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass Files, mapping to table Files\n");
        out.append("Persistent attributes: \n"); 
        out.append("eventID = " + this.eventID + "\n"); 
        out.append("filename = " + this.filename + "\n"); 
        out.append("fileData = " + this.fileData + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Files cloned = new Files();

        cloned.setEventID(this.eventID); 
        if (this.filename != null)
             cloned.setFilename(new String(this.filename)); 
        if (this.fileData != null)
             cloned.setFileData(new String(this.fileData)); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}

