package Entities;

import javax.persistence.*;

@Entity
public class Adminstorator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	
	
	public Adminstorator() {
		System.out.println("Admnistorator defult constructure runs..");
	}
	
	public Adminstorator(String name, String password) {
		super();
		this.name = name;
		this.password = password;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Adminstorator [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
	
	
}
