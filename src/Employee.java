import java.util.Scanner;

public class Employee {
	
	private static Scanner s = new Scanner(System.in);
	private static int index = 1;
	private String name;
	private String password;
	private int level;
	private String empID;
	
	public Employee(String empID,String empName, String password, int level) {
		this.empID=empID;
		this.name = empName;
		this.password = password;
		this.level = level;
	}
	public String getID(){
		return empID;
	}
	public String getName(){
		return this.name;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public int getLevel(){
		return this.level;
	}
	
}
