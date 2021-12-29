package com.tma.RestApiConnectDB.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tma.RestApiConnectDB.Model.User;
import com.tma.RestApiConnectDB.Service.UserStorageService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserStorageService userStorageService;
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/user")
	public ResponseEntity<User> add(@Valid @RequestBody User user) {
		try {

			 User ur =  userStorageService.store(user);
			return new ResponseEntity<>(ur, HttpStatus.CREATED);
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
