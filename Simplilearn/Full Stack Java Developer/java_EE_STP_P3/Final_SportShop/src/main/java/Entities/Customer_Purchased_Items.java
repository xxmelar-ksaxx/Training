package Entities;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Customer_Purchased_Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String date=new Date().toLocaleString();  // get current date
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private User user_id;
	
	@ManyToOne
	@JoinColumn(name = "customer_product_id")
	private Products product_id;

	public Customer_Purchased_Items() {
		super();
		System.out.println("Customer_Purchased_items Entity is called -- Defult constructor msg");
	}

	public Customer_Purchased_Items(User user_id, Products product_id) {
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
		return "Customer_Purchased_Items [id=" + id + ", date=" + date + ", user_id=" + user_id + ", product_id="
				+ product_id + "]";
	}
	
	
	
	
	
	
	
}
