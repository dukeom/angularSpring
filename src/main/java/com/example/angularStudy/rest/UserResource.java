package com.example.angularStudy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.angularStudy.domain.User;
import com.example.angularStudy.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserResource {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userRepository.findAll();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Void> createUser(@RequestBody User user){
		userRepository.save(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<Void> deleteUsere(@PathVariable String userId ){
		userRepository.delete(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}	
}
