package Entities;

import javax.persistence.*;

@Entity
public class Customer_Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private User user_id;
	
	@ManyToOne
	@JoinColumn(name = "customer_product_id")
	private Products product_id;

	public Customer_Cart() {
		super();
		System.out.println("Customer_Cart Entity is called -- Defult constructor msg");
	}

	public Customer_Cart(User user_id, Products product_id) {
		super();
		System.out.println("Customer_Purchased_items Entity is called -- Normal constructor msg");
		this.user_id = user_id;
		this.product_id = product_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public Products getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Products product_id) {
		this.product_id = product_id;
	}

	@Override
	public String toString() {
		return "Customer_Cart [id=" + id + ", user_id=" + user_id + ", product_id=" + product_id + "]";
	}
	
	
	
	
	
}
