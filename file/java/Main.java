package file.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
	public static void main(String[] args) throws IOException {

		String string = "Birds flying in the sky";
		
		//Write file
		
		File file = new File("text.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(string);
		fileWriter.close();
		
		//Read file
		
		FileReader fileReader = new FileReader(file);
		
	    int c;
	    while((c = fileReader.read()) != -1) {
	    	System.out.print((char)c);
	    }
	    fileReader.close();
	    
	    System.out.println();
	    
	    FileInputStream fi = new FileInputStream(file);
	    
	    int d;
	    while((d = fi.read()) != -1) {
	    	System.out.print((char)d);
	    }
	}
}
