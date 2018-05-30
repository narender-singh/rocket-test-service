package com.banana.tictactoe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.banana.tictactoe.ws.User;

@Configuration
public class AppConfiguration {

	@Bean
	public User user(){
		return new User();
	}
}
