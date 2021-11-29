package oop.java;

public class Student extends Person{

	public Student(String name, String position) {
		super(name, position);
	}

	public void action() {
		System.out.println("Learning");
	}
}
