package com.tma.RestApiConnectDB.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.tma.RestApiConnectDB.annotations.EmailValidation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_TBL")
public class User {
	
	@Id
    @GeneratedValue
	private int id;
	
	private String name;
	
	@NotBlank
	@EmailValidation()
	private String email;
	
	private String gender;
	

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}