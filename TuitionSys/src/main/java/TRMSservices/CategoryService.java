package TRMSservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import TRMSDatabaseSetup.CategoryTable;
import TRMSDatabaseSetup.RequestTable;
import TRMSmodels.Category;
import TRMSmodels.Event;

public class CategoryService {

	public static Category getCategory(int id) {
		// TODO Auto-generated method stub
		return CategoryTable.categoryDBtable.get(id);
	}
	
	public static int getRefundPercentage(String eventType ) {
		
		List<Category> categories = CategoryService.getAllCategories();
		
		for (Category c : categories)
			if (c.getDescription().equals(eventType))
				return c.getValue();
		
		return -1;
		
	}

	public static int getRefundAmount(String eventType, int cost) {

		double refundCalc = ((double)CategoryService.getRefundPercentage(eventType)/100.0)*(double)cost;
		return (int)refundCalc;
	}
	



	public static List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		Set<Integer> keys = CategoryTable.categoryDBtable.keySet();
		List<Category> categoryList = new ArrayList<Category>();
		
		for(Integer key: keys) {
			if (CategoryTable.categoryDBtable.get(key).getId() < 10)
				categoryList.add(CategoryTable.categoryDBtable.get(key));
		}
		return categoryList;

	}
	
	public static List<Category> getAllGradingFormats() {
		// TODO Auto-generated method stub
		Set<Integer> keys = CategoryTable.categoryDBtable.keySet();
		List<Category> categoryList = new ArrayList<Category>();
		
		for(Integer key: keys) {
			if (CategoryTable.categoryDBtable.get(key).getId() > 10)
				categoryList.add(CategoryTable.categoryDBtable.get(key));
		}
		return categoryList;

	}
	
	
	public static void main (String [] args) {
			
		System.out.println(CategoryService.getAllCategories());
		
		System.out.println(CategoryService.getRefundAmount("Certification",517));
		
		
		}
}