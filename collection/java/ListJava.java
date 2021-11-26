package collection.java;

import java.util.List;
import java.util.ArrayList;

import oop.java.Book;

public class ListJava {
	public static void main(String[] args) {
		Book s1 = new Book(1, "English");
		Book s2 = new Book(2, "Math");
		Book s3 = new Book(3, "History");
		
	
		List<Book> listBook = new ArrayList<Book>();
		listBook.add(s1);
		listBook.add(s2);
		listBook.add(s3);
		
		for (Book book: listBook) {
			System.out.print(book.title);
			System.out.print(" ");
		}
		
		listBook.remove(2);
		System.out.println();
		for (Book book: listBook) {
			System.out.print(book.title);
			System.out.print(" ");
		}	
	}
	
}
