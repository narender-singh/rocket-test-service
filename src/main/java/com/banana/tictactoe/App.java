package com.banana.tictactoe;

import org.apache.camel.builder.RouteBuilder;

import com.rocket.core.Rocket;

public class App extends RouteBuilder {

	public static void main(String[] args) {

		Rocket.configure().withClasses(App.class, AppConfiguration.class).initialize().launchAndWait();

	}

	@Override
	public void configure() throws Exception {

		from("jetty:http://0.0.0.0:8080/rocket?matchOnUriPrefix=true").to("cxfbean:user");

	}

}
