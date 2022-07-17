package Entities;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subjects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int credits;
	
	
	public Subjects() {
		System.out.println("Subjects defult constructure runs..");
	}
	public Subjects(String name, int credits) {
		super();
		this.name = name;
		this.credits = credits;
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
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	@Override
	public String toString() {
		return "Subjects [id=" + id + ", name=" + name + ", credits=" + credits + "]";
	}
	
	
	
}
