package com.jaydz.javaspringbootrest.service;

import com.jaydz.javaspringbootrest.models.PasswordStorage;
import com.jaydz.javaspringbootrest.models.User;

public interface DatabaseService {
	
	/* User Operations */
	public Iterable<User> getUsers();
	public boolean updateLoggedIn(User user);
	
	/* Return true if user email doesn't exist, false if it does */
	public boolean queryByEmailAndSave(User u, PasswordStorage storage);
	
}
