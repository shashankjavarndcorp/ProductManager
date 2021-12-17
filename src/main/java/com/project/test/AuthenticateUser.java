package com.project.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.project.dao.UserDao;
import com.project.dao.UserDaoImpl;
import com.project.model.User;

public class AuthenticateUser {
	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Login Name");
		String loginName = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();

		try {
			User user = userDao.authenticate(loginName, password);
			if (user != null) {
				System.out.println("User exist");
			} else {
				System.out.println("User not exist");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
