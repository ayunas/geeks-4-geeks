package com.geeks4geeks.spring.mongo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

	@Autowired
	iUserRepo userRepo;

	@GetMapping("users")
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@GetMapping("/users-ages")
	public List<User> getUsersByAge(@RequestParam("min") int min, @RequestParam("max") int max) {
		System.out.println("min age : " + min);
		System.out.println("max age : " + max);
		return userRepo.getUsersByAge(min,max);
	}

}
