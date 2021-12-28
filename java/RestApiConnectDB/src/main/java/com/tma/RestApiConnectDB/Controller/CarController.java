package com.tma.RestApiConnectDB.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tma.RestApiConnectDB.Model.Car;
import com.tma.RestApiConnectDB.Repository.CarRepository;
import com.tma.RestApiConnectDB.Service.CarService;

@RestController
@RequestMapping("/api")
public class CarController {
	
	@Autowired
	private CarRepository carRepository;
		CarService carService;
	
	@PostMapping("/car")
	public ResponseEntity<?> created(@RequestBody Car car) {
		
		CompletableFuture<Car> cars = carService.saveCar(car);
		
		return new ResponseEntity<>(cars, HttpStatus.CREATED);
	}
	
	 @GetMapping("/cars")
	 public CompletableFuture<ResponseEntity<?>> findAllCars() {
		 
	      return  carService.findAllCars().thenApply(ResponseEntity::ok);
	}
	 
	@PostMapping("/saveAllcar")
	public ResponseEntity<?> saveAll(@RequestBody List<Car> car) {
		
		CompletableFuture<List<Car>> repcars = carService.saveAll(car);
		
		return new ResponseEntity<>(repcars, HttpStatus.CREATED);
	}
	 
	//DeleteAllById
	 @DeleteMapping("/deleteAllCar")
	 public ResponseEntity<?> deleteAllById(@RequestBody Iterable<Long> ids) {
		 
		  try {
			carService.deleteAllById(ids);
		     	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	 
	 
}
