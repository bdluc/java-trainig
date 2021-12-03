package com.tma.RestApiConnectDB.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tma.RestApiConnectDB.Model.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
