package com.bean.life.cycle;

import lombok.*;

@Setter
@Getter

public class Book {
	private String title;
	private String auther;
	private float price;
	
	public void getMessage() {
		System.out.println("Title: " + title + "\nAuther: " + auther + "\nPrice: " + price);
	}
	
	// init-method
	public void init() {
		System.out.println("Bean is going through init");
	}
	
	//destroy-method
	public void destroy() {
		System.out.println("Bean will destroy now");
	}
}
