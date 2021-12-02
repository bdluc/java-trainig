package com.custom.event;

import org.springframework.context.ApplicationListener;

public class CustomEventhandler implements ApplicationListener<CustomEvent> {

	@Override
	public void onApplicationEvent(CustomEvent arg0) {
		System.out.println(arg0.toString("This is my custom event"));
	}
	
}
