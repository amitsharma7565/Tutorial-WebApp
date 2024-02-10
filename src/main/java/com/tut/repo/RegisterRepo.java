package com.tut.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tut.model.Login;
import com.tut.model.Register;

public interface RegisterRepo extends JpaRepository<Register, Integer>{

Register findByEmail(String email);
}
