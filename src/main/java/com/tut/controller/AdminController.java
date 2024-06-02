package com.tut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tut.model.Register;
import com.tut.repo.RegisterRepo;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RegisterRepo userRepository;

    @PostMapping("/unlockUser")
    public ResponseEntity<String> unlockUser(@RequestParam String email) {
        Register user = userRepository.findByEmail(email);
        if (user != null) {
            user.setAccountLocked(false);
            userRepository.save(user);
            return ResponseEntity.ok("User account unlocked");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}

