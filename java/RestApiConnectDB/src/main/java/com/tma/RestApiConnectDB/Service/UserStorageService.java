package com.tma.RestApiConnectDB.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.RestApiConnectDB.Model.User;
import com.tma.RestApiConnectDB.Repository.UserRepository;

@Service
public class UserStorageService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User store(User user) {
		
		User ur = userRepository.save(new User(user.getName(), user.getAge()));
		
		return ur;
		
	}
}
