package com.event.handle;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		
		//ContextStartedEvent
		context.start();
		
		Car car = (Car) context.getBean("car");
		System.out.println("Name: " + car.getName());
		
		//ContextReFreshedEvent
		context.refresh();
		
		
		//ContextStoppedEvent
		context.stop();
		
		//ContextCloseEvent
		context.close();
		
	}
}
