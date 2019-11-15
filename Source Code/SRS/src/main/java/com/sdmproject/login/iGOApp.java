package com.sdmproject.login;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sdmproject.login.model.Role;
import com.sdmproject.login.model.User;
import com.sdmproject.login.repository.RoleRepository;
import com.sdmproject.login.service.UserService;

@SpringBootApplication
public class iGOApp implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(iGOApp.class, args);
	}

	@Override
	public void run(String... args) {

		// if admin does not exist then insert admin in DB
		User userExists = userService.findUserByEmail("admin@niravjdn.xyz");
		if (userExists == null) {
			User user = new User();
			user.setEmail("niravjdn@gmail.com");
			user.setPassword("user");
			user.setName("Nirav");
			user.setLastName("Patel");
			
			userService.saveUser(user);
		}
	}
}
