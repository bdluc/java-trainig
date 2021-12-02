package com.bean.life.cycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String[] args) {
		try (AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml")) {
			Book obj = (Book) context.getBean("book");
			obj.getMessage();
			
			context.registerShutdownHook();
		}
		
	}
}
