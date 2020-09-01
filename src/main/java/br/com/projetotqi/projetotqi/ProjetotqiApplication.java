package br.com.projetotqi.projetotqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("br.com.projetotqi.projetotqi")
@SpringBootApplication
public class ProjetotqiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetotqiApplication.class, args);
	}

}
