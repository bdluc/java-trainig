package com.tma.RestApiConnectDB.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
	
	@Id
    @GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int age;
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}