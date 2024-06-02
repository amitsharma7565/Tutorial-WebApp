package com.tut.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tut.model.Login;
import com.tut.model.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Integer>{

Register findByEmail(String email);
}
