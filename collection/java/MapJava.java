package collection.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import oop.java.Book;

public class MapJava {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();	
		map.put(1, "String A");
		map.put(2, "String B");
		map.put(3, "String C");
		map.put(4, "String D");
		
		Set<Integer> keySet = map.keySet();
		
		for (Integer i: keySet) {
			System.out.println(i + " "+ map.get(i));
		}
		
		System.out.println("Delete element in map");
		
		map.remove(2);
		
		Set<Integer> keySet1 = map.keySet();
		
		for (Integer i: keySet1) {
			System.out.println(i + " "+ map.get(i));
		}
	}
}
