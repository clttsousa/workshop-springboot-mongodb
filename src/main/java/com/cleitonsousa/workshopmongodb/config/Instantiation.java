package com.cleitonsousa.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cleitonsousa.workshopmongodb.domain.User;
import com.cleitonsousa.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User cleiton = new User(null, "Cleiton Sousa", "cleiton@gmail.com");
		User amanda = new User(null, "Amanda Maria", "amanda@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(cleiton, amanda, bob));
		
	}

}
