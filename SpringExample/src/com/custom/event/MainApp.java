package com.custom.event;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		
		CustomEventPublisher cvp = (CustomEventPublisher) context.getBean("customEventPublisher");
		
		cvp.publish();
	}
}
