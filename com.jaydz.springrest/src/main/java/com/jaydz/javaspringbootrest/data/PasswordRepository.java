package com.jaydz.javaspringbootrest.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaydz.javaspringbootrest.models.PasswordStorage;

@Repository
public interface PasswordRepository extends JpaRepository<PasswordStorage, String> {}
