package testProject_1;

public class Employee {

	private String name;
	private int id;
	public static int salary;
	public Employee(String name, int id, int salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}
	
	public int add() {
		System.out.println("dsd");
		return 1;
	}
	
	static void asd() {
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		Employee e1=new Employee("obm", 1, 900);
		Employee e2=new Employee("melar", 2, 300);
		Employee e3=new Employee("xyz", 4, 600);
		salary=1000;
		asd();
		
		
		
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		
		
	}
	
}
