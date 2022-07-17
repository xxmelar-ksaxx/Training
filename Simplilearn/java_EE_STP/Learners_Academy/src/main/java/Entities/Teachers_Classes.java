package Entities;

import javax.persistence.*;

@Entity
public class Teachers_Classes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tc_id;
	
	@ManyToOne
	@JoinColumn(name = "teachers_id")
	private Teachers t_id;
	
	@ManyToOne
	@JoinColumn(name = "class_id")
	private Classes c_id;
	
	public Teachers_Classes() {
		System.out.println("Teachers_Classes defult constructure runs..");
	}
	
	public Teachers_Classes(Teachers t_id, Classes c_id) {
		super();
		this.t_id = t_id;
		this.c_id = c_id;
	}

	public Teachers getT_id() {
		return t_id;
	}


	public void setT_id(Teachers t_id) {
		this.t_id = t_id;
	}


	public Classes getC_id() {
		return c_id;
	}


	public void setC_id(Classes c_id) {
		this.c_id = c_id;
	}



	@Override
	public String toString() {
		return "Teachers_Classes [t_id=" + t_id + ", c_id=" + c_id + "]";
	}
	
	
	
	
}
