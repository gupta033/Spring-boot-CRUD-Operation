package com.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.main.dao.UserDao;
import com.main.entity.User;

@SpringBootApplication
public class SpringBootProjectCrudOperationApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectCrudOperationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		// inert------------
//		
//		User user1=new User("mona", "mona@gmail.com", "femle", "chapra");
//		boolean status= userDao.insertUser(user1);
//		if(status) {
//			System.out.println("insert succesfully");
//		}else {
//			System.out.println("not insert");
//		}

//		update----------

//		User user = new User("Ashish Gupta", "ashish@gmail.com", "Male", "Noida");
//		boolean status = userDao.updateUser(user);
//		if (status) {
//		    System.out.println("Update successful");
//		} else {
//		    System.out.println("Update failed");
//		}

		// update 2 ------

		User user = userDao.getUserByEmail("mona@gmail.com");
		user.setCity("Bihar Siwan");
		boolean status = userDao.updateUser(user);
		if (status) {
			System.out.println("Update successful");
		} else {
			System.out.println("Update failed");
		}

		// delete------------

//		boolean status = userDao.deleteByEmail("rahul@gmail.com");
//		if (status) {
//		    System.out.println("delete successful");
//		} else {
//		    System.out.println("delete failed");
//		}
//		
		// select-----display---

//		User user = userDao.getUserByEmail("mona@gmail.com");
//		if (user != null) {
//		    System.out.println("Name: " + user.getName());
//		    System.out.println("Email: " + user.getEmail());
//		    System.out.println("Gender: " + user.getGender());
//		    System.out.println("City: " + user.getCity());
//		} else {
//		    System.out.println("User not found.");
//		}
		
		
		// select all User
		
//		List<User> list = userDao.getAllUsers();
//		for (User user : list) {
//			System.out.println("Name: " + user.getName());
//			System.out.println("Email: " + user.getEmail());
//			System.out.println("Gender: " + user.getGender());
//			System.out.println("City: " + user.getCity());
//			System.out.println("+++++++++++++++++++");
//		}
	}

}
