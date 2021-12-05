package TRMSDatabaseSetup;

	import java.util.HashMap;
	import java.util.Map;

	import TRMSmodels.Category;
	
public class CategoryTable {



		public static Map<Integer, Category> categoryDBtable = new HashMap<Integer,Category>();

		static {
			
			Category c1 = new Category(1, "University Course", 80);
			Category c2 = new Category(2, "Seminar", 60);
			Category c3 = new Category(3, "Test Prep Course", 75);
			Category c4 = new Category(4, "Certification", 100);
			Category c5 = new Category(5, "Technical Training", 90);
			Category c6 = new Category(6, "Other", 30);
			
			Category c11 = new Category(10, "Letter Grade", 70);
			Category c12 = new Category(11, "Percentage", 80);
			Category c13 = new Category(12, "Pass/Fail",1);
			Category c14 = new Category(13, "Presentaton", 1);
			Category c15 = new Category(14, "Number of Points", 50);
			
			
			categoryDBtable.put(c1.getId(), c1);
			categoryDBtable.put(c2.getId(), c2);
			categoryDBtable.put(c3.getId(), c3);
			categoryDBtable.put(c4.getId(), c4);
			categoryDBtable.put(c5.getId(), c5);
			categoryDBtable.put(c6.getId(), c6);
			
			categoryDBtable.put(c11.getId(), c11);
			categoryDBtable.put(c12.getId(), c12);
			categoryDBtable.put(c13.getId(), c13);
			categoryDBtable.put(c14.getId(), c14);
			categoryDBtable.put(c15.getId(), c15);		
			
			
		}
}
