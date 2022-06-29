package com.pragma.webflux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.pragma.webflux.model.entity.ImageMongoEntity;
import com.pragma.webflux.repository.ImageRepository;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactiveWebFluxApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(ReactiveWebFluxApplication.class);
	
	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private ReactiveMongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ReactiveWebFluxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		mongoTemplate.dropCollection("imagerepo")
		.subscribe();
		
		Flux.just(
				ImageMongoEntity.builder()
				.id("TEST-1")
				.bodyBase64("content1")
				.imageName("test1")
				.build()
				,
				ImageMongoEntity.builder()
				.id("TEST-2")
				.bodyBase64("content2")
				.imageName("test2")
				.build()
				,
				ImageMongoEntity.builder()
				.id("TEST-3")
				.bodyBase64("content3")
				.imageName("test3")
				.build()
				,
				ImageMongoEntity.builder()
				.id("TEST-4")
				.bodyBase64("content4")
				.imageName("test4")
				.build()
				)
		.flatMap(image -> imageRepository.create(image))
		.subscribe(
				image -> log.info(image.toString())
				);
	}

}
