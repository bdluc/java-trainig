package com.tma.RestApiConnectDB.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.tma.RestApiConnectDB.Model.Car;
import com.tma.RestApiConnectDB.Repository.CarRepository;
import com.tma.RestApiConnectDB.Service.CarService;

@Service
public class CarServiceImpl implements CarService {


	@Autowired
	private CarRepository carRepository;

	private static Logger logger = LoggerFactory.getLogger(CarService.class);
	
	@Override
	public CompletableFuture<Car> saveCar(Car car) {
		
		try {
			Car cars = carRepository.save(new Car(car.getId(), car.getName(), car.getModel()));
			logger.info("Saving SucssecFully " + Thread.currentThread().getName());
//			return CompletableFuture.completedFuture(cars);
			return CompletableFuture.completedFuture(cars);
		}catch (Exception e) {
			logger.error("Failed", e);
			return CompletableFuture.failedFuture(e);
		}
	}

	@Override
	public CompletableFuture<List<Car>> findAllCars() {
		List<Car> cars = carRepository.findAll();
		logger.info("Get list cars " + Thread.currentThread().getName());
		return CompletableFuture.completedFuture(cars);
	}

	//DeleteAllById
	@Override
	public CompletableFuture<?> deleteAllById(Iterable<Long> ids) {	
	
		try {
	          	carRepository.deleteAllById(ids);
			logger.info("succesfully");
			return CompletableFuture.completedFuture(ids);
		}catch (Exception e) {
			logger.error("Failed", e);
			return CompletableFuture.failedFuture(e);
		}  

	}

	

	@Override
	public CompletableFuture<List<Car>> saveAll(List<Car> car) {
		
		List<Car> repCar = carRepository.saveAll(car);
		return CompletableFuture.completedFuture(repCar);
	}


}
