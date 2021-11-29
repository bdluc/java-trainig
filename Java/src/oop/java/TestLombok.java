package oop.java;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
class Book1 {
	private String name;
}

public class TestLombok {
	public static void main(String[] args) {
		Book1 a = new Book1();
		a.setName("Nguyen Duc Tinh");
		System.out.println(a.getName());
	}
}
