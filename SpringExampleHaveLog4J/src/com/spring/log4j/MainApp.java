package com.spring.log4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MainApp {
	static Logger log = LogManager.getLogger(MainApp.class.getName());
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("Beans.xml");
		log.debug("This is debug");
		log.info("Will create Book book");
		log.warn("This is warn");
		log.error("This is error");
		log.fatal("This is fatal");
		Book book = (Book) context.getBean("book");
		book.showBook();
		log.info("Exitting the program");
	}
}
