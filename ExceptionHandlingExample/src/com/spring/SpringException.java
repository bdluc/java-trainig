package com.spring;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class SpringException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String exceptionMsg;
}
