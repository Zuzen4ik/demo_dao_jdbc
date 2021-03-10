package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("==== test 1: findById =====");
		Department dep = departmentDao.finById(1);
		System.out.println(dep);
		
		System.out.println("\n ==== test 2: findAll =====");
		List<Department> list = departmentDao.findAll();
		for(Department department : list)
			System.out.println(department);

		System.out.println("\n ==== test 3: insert =====");
		Department newDepartment = new Department(null, "music");
		departmentDao.insert(newDepartment);
		System.out.println("department inserted! new ID: " + newDepartment.getId());

		System.out.println("\n ==== test 4: update =====");
		Department depar = departmentDao.finById(1);
		depar.setName("Food");
		departmentDao.update(depar);
		System.out.println("updated!");
		
		System.out.println("\n ==== test 4: update =====");
		System.out.println("enter id for delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("deleted!");
	}

}
