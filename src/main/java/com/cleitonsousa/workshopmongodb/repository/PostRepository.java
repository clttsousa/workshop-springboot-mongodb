package com.cleitonsousa.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cleitonsousa.workshopmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
}
