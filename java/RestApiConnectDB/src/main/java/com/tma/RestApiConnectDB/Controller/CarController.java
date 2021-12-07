package com.tma.RestApiConnectDB.Controller;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tma.RestApiConnectDB.Model.Car;
import com.tma.RestApiConnectDB.Service.CarService;

@RestController
@RequestMapping("/api")
public class CarController {
	
	@Autowired
		CarService carService;
	
	@PostMapping("/car")
	public ResponseEntity created(@RequestBody Car car) {
		
		CompletableFuture<Car> cars = carService.saveCar(car);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	 @GetMapping("/cars")
	 public CompletableFuture<ResponseEntity> findAllCars() {
		 
	      return  carService.findAllCars().thenApply(ResponseEntity::ok);
	}
}
