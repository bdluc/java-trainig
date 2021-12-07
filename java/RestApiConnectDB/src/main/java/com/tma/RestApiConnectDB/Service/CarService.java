package com.tma.RestApiConnectDB.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.tma.RestApiConnectDB.Model.Car;
import com.tma.RestApiConnectDB.Model.User;
import com.tma.RestApiConnectDB.Repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
		private CarRepository carRepository;
	
	private static Logger logger = LoggerFactory.getLogger(CarService.class);
	
	@Async
	public CompletableFuture<Car> saveCar(Car car) {
		
		try {
			Car cars = carRepository.save(new Car(car.getId(), car.getName(), car.getModel())) ;
			logger.info("Saving SucssecFullhy");
			return CompletableFuture.completedFuture(cars);
		}catch (Exception e) {
			logger.error("Failed", e);
			return null;
		}
	}
	
	
	@Async
	public CompletableFuture<List<Car>> findAllCars() {
		
		List<Car> cars = carRepository.findAll();
		logger.info("Get list cars");
		return CompletableFuture.completedFuture(cars);
	}
	
}
