package com.custom.event;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {
	
	/**
	 * Add default verion
	 */
	private static final long serialVersionUID = 1L;

	public CustomEvent(CustomEventPublisher source) {
		super(source);
	}

	public String toString(String a) {
		return "My Custom Event " + a;
	}
}
