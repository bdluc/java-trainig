package com.tma.RestApiConnectDB.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class FileDB {
	
	@Id
	private String id;
	private String name;
	private String type;
	@Lob
	private byte[] data;
	
}
