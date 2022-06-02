package com.example.frontendrest;

import com.example.frontendrest.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class FrontendRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontendRestApplication.class, args);
	}

	@Bean
	PersonService personService(){
		WebClient client = WebClient.builder()
				.baseUrl("http://localhost:8080/")
				.build();

		HttpServiceProxyFactory proxyFactory =
				HttpServiceProxyFactory.builder(new WebClientAdapter(client)).build();

		return proxyFactory.createClient(PersonService.class);
	}

	@Bean
	public CommandLineRunner CommandLineRunnerBean() {
		return (args) -> {
			System.out.println("by name " + personService().personByName("Yogesh"));
			System.out.println("list " + personService().personList());
		};
	}
}
