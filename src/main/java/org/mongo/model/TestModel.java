package org.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document("test")
@Setter
@Getter
public class TestModel {

	@Id
	private String _id;
	
	private String name;
	
	private String phone;
}
