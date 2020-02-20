package com.jaydz.javaspringbootrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaydz.javaspringbootrest.data.EmployeeRepository;
import com.jaydz.javaspringbootrest.data.PasswordRepository;
import com.jaydz.javaspringbootrest.data.UserRepository;
import com.jaydz.javaspringbootrest.models.Employee;
import com.jaydz.javaspringbootrest.models.PasswordStorage;
import com.jaydz.javaspringbootrest.models.User;

@Service
public class DatabaseServiceImpl implements DatabaseService {

	/* REPOSITORIES */
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private PasswordRepository passwordRepo;

	
	/*     User operations     */

	@Transactional
	public boolean queryByEmailAndSave(User u, PasswordStorage storage) {
		String email = u.getEmail();
		String foundEmail = userRepo.getByEmail(email);
				
		if (foundEmail == null) {
			passwordRepo.save(storage);
			userRepo.save(u);
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean updateLoggedIn(User u) {
	  userRepo.save(u);
	  return true;
	}
	
	
	@Transactional(readOnly=true)
	public Iterable<User> getUsers() {
		return userRepo.findAll();
	}
	
	
	/*   Employee Operations   */
	public void saveEmployee(Employee emp) {
	    empRepo.save(emp);
	}
	
	@Transactional(readOnly=true)
	public Iterable<Employee> getEmployees() {
		return empRepo.findAll();
	}
}
