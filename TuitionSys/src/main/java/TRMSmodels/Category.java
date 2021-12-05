package TRMSmodels;

public class Category {
	
	int id;
	String description;
	int value;
	
	
	public int getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public int getValue() {
		return value;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", description=" + description + ", value=" + value + "]";
	}
	
	public Category(int id, String description, int value) {
		super();
		this.id = id;
		this.description = description;
		this.value = value;
	}
	
	
	

}
