package com.spring.example;

import lombok.*;

@Setter
@Getter
public class Person {
	private String name;
	private int age;
	private String email;
	
	public void showInfo() {
		System.out.print("Your infomation: " + name + "\nAge: " + (age + 1) + "\nEmail: " + email);
	}
}
