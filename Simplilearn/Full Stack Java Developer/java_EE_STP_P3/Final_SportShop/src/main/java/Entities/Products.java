package Entities;

import java.util.Arrays;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String price;
	private String category;
	
	@Column(name = "image" ,length = 99999111)
	private String image;
	
	@OneToMany(mappedBy = "product_id")
	Set<Customer_Purchased_Items> purchasedItems;
	
	@OneToMany(mappedBy = "product_id")
	Set<Customer_Cart> cartItems;
	
	public Products() {
		super();
		System.out.println("Products Entity is called -- Defult constructor msg");
	}

	public Products(String name, String price, String category) {    // No image
		super();
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public Products(String name, String price, String category, String image) {   // With image
		super();
		this.name = name;
		this.price = price;
		this.category = category;
		this.image = image;
	}
	
	

	public Products(int id, String name, String price, String category, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.image = image;
		
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", image="
				+"image Base64  long String :) demo" + "]";
	}
	
	
	
	
	
	
	
	
}
