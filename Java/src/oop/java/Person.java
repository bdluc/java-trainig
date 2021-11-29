package oop.java;

public class Person {
	private String name;
	private String position;
	
	
	public Person(String name, String position) {
		this.name = name;
		this.name = position;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPosition() {
		return this.position;
	}
	public void action() {
		System.out.print("Hành động của Person");
	}
	public void action(String position) {
		System.out.print(position);
	}
}
