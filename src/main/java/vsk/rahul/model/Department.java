package vsk.rahul.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT")
public class Department {

	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "DEPARTMENT")
	private String department;
	
	public Department() {
		
	}

	public Department(Integer id, String department) {
		this.id = id;
		this.department = department;
	}
	
	@Override
	public String toString() {
		return String.format("id=%d, department=%s", id, department);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
