package com.tutorialspoint;

import lombok.Setter;

@Setter
public class HelloWorld {
   private String message;

   public void getMessage(){
      System.out.println("Your Message : " + message);
   }
}