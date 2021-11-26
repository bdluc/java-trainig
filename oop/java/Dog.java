package oop.java;

public class Dog implements Animal{
	
	public String name;
	
	public Dog(String name) {
		this.name = name;
	}
	@Override
	public void eat() {
		System.out.println("It eats everything");
	}

	@Override
	public void speak() {
		System.out.println("Go Go");
	}
}
