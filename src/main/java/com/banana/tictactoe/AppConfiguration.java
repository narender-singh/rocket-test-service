package com.banana.tictactoe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.banana.tictactoe.ws.User;
import com.rocket.jdbc.RocketCassandraDbConnectionPool;
import com.rocket.jdbc.RocketConnectionPoolFactory;

@Configuration
public class AppConfiguration {

	@Bean
	public User user(RocketCassandraDbConnectionPool cassandraPool) {
		return new User(cassandraPool);
	}

	@Bean
	public RocketCassandraDbConnectionPool cassandraPool() {
		return RocketConnectionPoolFactory.getCassandraDataSource("nasingh", "Bliss.123", 9042, "127.0.0.1");
	}
}
