package Entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name ="classes")
public class Classes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="subject_id",referencedColumnName="id")
	private Subjects f_name;   // foreign key of the subject entity id
	private int roomNo;
	private int time;
	
	// for @ManyToOne relation
	@OneToMany(mappedBy = "c_id")
	Set<Teachers_Classes> registerd_classes;
	
	public Classes() {
		System.out.println("Classes defult constructure runs..");
	}
	public Classes(Subjects f_name, int roomNo, int time) {
		super();
		this.f_name = f_name;
		this.roomNo = roomNo;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subjects getF_name() {
		return f_name;
	}

	public void setF_name(Subjects f_name) {
		this.f_name = f_name;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", f_name=" + f_name + ", roomNo=" + roomNo + ", time=" + time + "]";
	}
	
	
	
}
