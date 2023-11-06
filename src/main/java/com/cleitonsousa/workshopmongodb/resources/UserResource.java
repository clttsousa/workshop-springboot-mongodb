package com.cleitonsousa.workshopmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cleitonsousa.workshopmongodb.domain.User;

@RestController
@RequestMapping (value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User amanda = new User("1", "Amanda Estevam", "amanda@gmail.com");
		User cleiton = new User("2", "Cleiton Sousa", "cleiton@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(amanda, cleiton));
		return ResponseEntity.ok().body(list);
	}
}
