package com.jaydz.javaspringbootrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaydz.javaspringbootrest.models.PasswordStorage;
import com.jaydz.javaspringbootrest.models.User;
import com.jaydz.javaspringbootrest.service.DatabaseServiceImpl;

@Controller
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	DatabaseServiceImpl service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	/* @CrossOrigin(origins = "https://testingcite.000webhostapp.com") */
	@PostMapping(path="/add")
	public @ResponseBody boolean addNewUser(@RequestBody User u) {
		User user = updatedUser(u);
		String email = u.getEmail();
		String pw = u.getPassword();
		
		PasswordStorage storage = updatedStorage(email, pw);
		return service.queryByEmailAndSave(user, storage);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="/update")
	public @ResponseBody boolean updateUser(@RequestBody User u) {
		service.updateLoggedIn(u);
		return true;
	}
	
	public User updatedUser(User u) {
		User user = new User();
		user.setFirstName(u.getFirstName());
		user.setLastName(u.getLastName());
		user.setEmail(u.getEmail());
		user.setPassword("");
		user.setActive(u.getActive());
		user.setEmailConfirmed(false);
		user.setIsLoggedIn(false);
		user.setStayLoggedIn(false);
		user.setCreated(u.getCreated());
		return user;
	}
	
	public PasswordStorage updatedStorage(String email, String password) {
		PasswordStorage storage = new PasswordStorage();
		storage.setEmail(email);
		storage.setPassword(password);
		return storage;
	}
	
	
	@CrossOrigin(origins = "https://testingcite.000webhostapp.com")
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return service.getUsers();
	}
	
}
