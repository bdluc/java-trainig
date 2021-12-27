package com.springmvcjdbc.entities;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	  private int id;
	  private String name;
	  private String address;
}