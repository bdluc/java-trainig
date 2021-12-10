package com.springmvc.restful.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private int id;
	private String name;
	private String email;
	private String address;
}
