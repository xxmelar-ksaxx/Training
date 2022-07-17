package Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String role;          // Role as Customer or an Admin.
	
	@OneToMany(mappedBy = "user_id")
	Set<Customer_Purchased_Items> purchasedItems;
	
	@OneToMany(mappedBy = "user_id")
	Set<Customer_Cart> cartItems;
	
	
	public User() {
		super();
		System.out.println("User Entity is called -- Defult constructor msg");
	}

	public User(String name, String email, String password) {    //  Customer constructor
		super();
		System.out.println("User Entity is called -- Customer constructor msg");
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(String name, String email, String password, String role) {		// Admin constructor
		super();
		System.out.println("User Entity is called -- Admin constructor msg");
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
	
	
	

	
	
	
	
}
