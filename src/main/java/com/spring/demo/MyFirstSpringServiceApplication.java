package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyFirstSpringServiceApplication {

	public static void main(String[] args) {
	  ConfigurableApplicationContext c1 =	SpringApplication.run(MyFirstSpringServiceApplication.class, args);
	  Alien a = c1.getBean(Alien.class);
	  System.out.println("test");
	}

}
