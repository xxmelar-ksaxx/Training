package Entities;

import javax.persistence.*;

@Entity   // indicate that this class in an entity(Table)
public class Products {
	
	@Id    // indicate that the next Attribute is a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Constrain, to generate id automatically
	private int id;         // Attribute
	
	private String name;	// Attribute
	private int price;		// Attribute
	
	
	public Products() {
		System.out.println("Product defult constructure runs..");
	}


	public Products(String name, int price) {  // Constructor to write new recored
		super();
		this.name = name;
		this.price = price;
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


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	
	
}
