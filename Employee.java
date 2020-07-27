import java.util.*;

public class Employee {
	protected HashMap<String, String> attributes;
	
	public Employee(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}
	
	public String get(String key) {
		return this.attributes.get(key);
	}
}
