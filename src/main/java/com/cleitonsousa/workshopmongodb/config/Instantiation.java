package com.cleitonsousa.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cleitonsousa.workshopmongodb.domain.Post;
import com.cleitonsousa.workshopmongodb.domain.User;
import com.cleitonsousa.workshopmongodb.dto.AuthorDTO;
import com.cleitonsousa.workshopmongodb.dto.CommentDTO;
import com.cleitonsousa.workshopmongodb.repository.PostRepository;
import com.cleitonsousa.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User cleiton = new User(null, "Cleiton Sousa", "cleiton@gmail.com");
		User amanda = new User(null, "Amanda Maria", "amanda@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(cleiton, amanda, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2023"), "Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(cleiton));
		Post post2 = new Post(null, sdf.parse("23/03/2023"), "Bom dia", "Acordei feliz, finalizando meu curso!", new AuthorDTO(cleiton));

		CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("21/03/2023"), new AuthorDTO(amanda));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2023"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Bom dia!!", sdf.parse("23/03/2023"), new AuthorDTO(amanda));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		cleiton.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(cleiton);
	}

}
