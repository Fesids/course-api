package com.definitivo.definitivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;


import java.util.Arrays;

@SpringBootApplication

public class DefinitivoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DefinitivoApplication.class, args);
	}
	/*@Autowired
	AuthorRepository authorRepository;

	@Autowired
	CourseRepository courseRepository;

	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			Course spring = new Course("Spring course", "spring", "A spring course for beginners");
			Course django = new Course("Django course", "py", "A djnago course for newbies");
			Course react = new Course("React course", "js", "A react course for biruleibes");
			Course php = new Course("PhP course", "php", "a php for assalariados");
			courseRepository.save(spring);
			courseRepository.save(django);
			courseRepository.save(react);
			courseRepository.save(php);
			var felipe = new Author("felipe", "siqueira");
			var isadora = new Author("isadora", "santos");
			felipe.getCourses().addAll(Arrays.asList(django, spring, react));
			isadora.getCourses().addAll(Arrays.asList(react, php));
			authorRepository.save(felipe);
			authorRepository.save(isadora);
		};
	}*/


}


