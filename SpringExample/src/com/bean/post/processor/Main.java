package com.bean.post.processor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.life.cycle.Book;

public class Main {
	private static AbstractApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		
		Book book = (Book) context.getBean("book");
		book.getMessage();
		
		context.registerShutdownHook();
		
	}
}
