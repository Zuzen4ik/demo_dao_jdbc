package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("********* test 1 : findById");
		Seller seller = sellerDao.finById(3);

		System.out.println(seller);

		System.out.println(" \n ********* test 2 : findByDepartment");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller s : list)
			System.out.println(s);

		System.out.println(" \n ********* test 3 : findAll");
		list = sellerDao.findAll();
		for (Seller s : list)
			System.out.println(s);

		System.out.println(" \n ********* test 4 : seller insert");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 3000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! mew ID: " + newSeller.getId());

		System.out.println(" \n ********* test 5 : seller update");
		seller = sellerDao.finById(1);
		seller.setName("Martha Wain");
		sellerDao.update(seller);
		System.out.println("Update complited");

		System.out.println(" \n ********* test 6 : seller delete");
		System.out.println("enter id to delete");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("deleted");

		sc.close();

	}

}
