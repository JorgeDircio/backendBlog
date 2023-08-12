package com.developerdircio.CrudCursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CrudCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudCursosApplication.class, args);
		System.out.println("Todo esta funcionado bien");
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
