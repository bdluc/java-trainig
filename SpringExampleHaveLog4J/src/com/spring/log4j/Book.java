package com.spring.log4j;

import lombok.*;

@Setter
@Getter
public class Book {
	private String name;
	private float price;
	
	public void showBook() {
		System.out.println("Info of the book: " + name + " " + price);
	}
}
