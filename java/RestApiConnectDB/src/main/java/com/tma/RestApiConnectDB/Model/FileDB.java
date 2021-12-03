package com.tma.RestApiConnectDB.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "files")
public class FileDB {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String name;
	private String type;
	@Lob
	private byte[] data;
	
	public FileDB(String name, String type, byte[] data) {
	    this.name = name;
	    this.type = type;
	    this.data = data;
	  }
	
}
