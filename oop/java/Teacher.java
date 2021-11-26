package oop.java;

public class Teacher extends Person {
	public Teacher(String name, String position) {
		super(name, position);
	}

	public void action() {
		System.out.println("Teaching");
	}
}
