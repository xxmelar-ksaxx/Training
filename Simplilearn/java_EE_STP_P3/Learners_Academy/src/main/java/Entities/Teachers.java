package Entities;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Teachers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String jender;
	private int age;
	private String role;
	
	// for @ManyToOne relation
	@OneToMany(mappedBy = "t_id")
	Set<Teachers_Classes> registerd_classes;
	
	public Teachers() {
		System.out.println("Teachers defult constructure runs..");
	}
	
	public Teachers(String name, String email, String jender, int age, String role) {
		super();
		this.name = name;
		this.email = email;
		this.jender = jender;
		this.age = age;
		this.role = role;
	}
	
	public Teachers(String name, String role) {
		super();
		this.name = name;
		this.role = role;
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

	@Override
	public String toString() {
		return "Teachers [id=" + id + ", name=" + name + ", email=" + email + ", jender=" + jender + ", age=" + age
				+ ", role=" + role + "]";
	}
	
	
	
	
}
