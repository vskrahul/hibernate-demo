package vsk.rahul;

import java.util.Arrays;

import vsk.rahul.model.Department;
import vsk.rahul.service.DepartmentService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		DepartmentService service = new DepartmentService();
		
		for(int i = 0; i < 5; i++) {
			service.persist(new Department(i + 1, "IT-" + i + 1));
		}
		
		System.out.println(service.findById(1));
		
		service.update(new Department(1, "ABCD"));
		
		service.findAll().stream().forEach(System.out::println);
		
		service.delete(new Department(2, "ABCD"));
		service.deleteAll();
		
		System.out.println("persisted.");
		System.exit(1);
		
	}
}
