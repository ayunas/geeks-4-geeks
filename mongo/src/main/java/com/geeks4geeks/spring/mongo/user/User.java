package com.geeks4geeks.spring.mongo.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Document(value = "user")
@Getter @Setter
public class User {
	private String name;
	private String age;
}
