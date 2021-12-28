package com.tma.RestApiConnectDB.Service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.tma.RestApiConnectDB.Model.Car;

@Component
public interface CarService {
	
	
	@Async
	public CompletableFuture<Car> saveCar(Car car);

	@Async
	public CompletableFuture<List<Car>> findAllCars();
	
	@Async
	public CompletableFuture<List<Car>> saveAll(List<Car> car);
	
	@Async
	public CompletableFuture<List<Car>> saveAllCars(List<Car> car);

	//DeleteAllByid
	@Async
	public CompletableFuture<?> deleteAllById(Iterable<Long> ids);
}
