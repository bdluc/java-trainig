package oop.java;

public class Main {
	public static void main(String[] args) {
		Student student = new Student("Nguyen Van A", "Student");
		System.out.println(student.getName());
		student.action();
		
		Person teacher = new Teacher("Trung Tran B", "Teacher");
		System.out.println(teacher.getName());
		teacher.action();
		
		Dog dog = new Dog("Bulldog");
		
		dog.eat();
		System.out.println(dog.name);
	}
}
