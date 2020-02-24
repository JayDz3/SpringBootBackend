package com.jaydz.javaspringbootrest.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jaydz.javaspringbootrest.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "SELECT u.email FROM User u WHERE u.email = :email", nativeQuery = true)
	public String getByEmail(String email);
	
	@Query(value = "SELECT u FROM User u WHERE u.email = :email")
	public User getUserByEmail(String email);
}
