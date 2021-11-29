package com.tma.RestApiConnectDB.Controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tma.RestApiConnectDB.Model.User;

@RestController
public class UserController {
	private static Map<String, User> userRepo = new HashMap<>();
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//add User
	@PostMapping("/user")
	public ResponseEntity<Object> create(@RequestBody User user) {
		
		userRepo.put(user.getId(), user);
		
		logger.info("Thêm User ");
		
		return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
	}
	
	//update User
	@PutMapping("/user/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable("id") String id, @RequestBody User user) {
		
		userRepo.remove(id);
		user.setId(id);
		userRepo.put(id, user);
	    	logger.info("UPdate user");
	    return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
	}
	
	//Delete User
	@DeleteMapping("/user/{id}")
	   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
			userRepo.remove(id);
			return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
	   }
	
	//Get all users
	@GetMapping("/users")
	   public ResponseEntity<Object> getProduct() {
			logger.info("thông tin user");
			return new ResponseEntity<>(userRepo.values(), HttpStatus.OK);
	   }
}
