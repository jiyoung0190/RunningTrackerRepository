package com.training.RunningTracker;
//DAO stands for Database Access Object. It's a layer of objects that provide
//database access. In Spring, it's called Repository.

import com.training.RunningTracker.dao.UserDao;
import com.training.RunningTracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunningTrackerApplication {
	private static User user;
	private UserDao userDao;

	@Autowired
	public RunningTrackerApplication(UserDao userDao) {
		this.userDao = userDao;
		User user = userDao.getAllUsers();
	}

	public static void main(String[] args) {
		SpringApplication.run(RunningTrackerApplication.class, args);
		System.out.println("User: " + user);
	}

}
