package Entities;

import javax.persistence.*;

@Entity
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String jender;
	private int age;
	private String role;
	private int class1;
	
	public Students() {
		System.out.println("Students defult constructure runs..");
	}
	
	public Students(String name, String email, String jender, int age, String role, int class1) {
		super();
		this.name = name;
		this.email = email;
		this.jender = jender;
		this.age = age;
		this.role = role;
		this.class1 = class1;
	}
	
	public Students(String name, String role, int class1) {
		super();
		this.name = name;
		this.role = role;
		this.class1 = class1;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJender() {
		return jender;
	}

	public void setJender(String jender) {
		this.jender = jender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getClass1() {
		return class1;
	}

	public void setClass1(int class1) {
		this.class1 = class1;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", email=" + email + ", jender=" + jender + ", age=" + age
				+ ", role=" + role + ", class1=" + class1 + "]";
	}
	
	
	
	
	
	
}
