package vsk.rahul;

import vsk.rahul.model.Department;
import vsk.rahul.service.DepartmentService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		DepartmentService service = new DepartmentService();
		
		Department dept = new Department(1, "IT");
		
		service.persist(dept);
		System.out.println("persisted.");
		System.exit(1);
		
	}
}
