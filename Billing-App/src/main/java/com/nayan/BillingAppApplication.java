package com.nayan;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BillingAppApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BillingAppApplication.class, args);

		Properties props = new Properties();
		String mongoPass = System.getenv("MONGOPASS");
		String mongoDBUrl = "mongodb+srv://nayan97:" + mongoPass
				+ "@cluster0.cgcpm.mongodb.net/bill?retryWrites=true&w=majority";
		props.put("server.port", "8081");
		props.put("spring.data.mongodb.uri", mongoDBUrl);
		props.put("spring.data.mongodb.databasee", "bill");
		props.put("spring.jpa.defer-datasource-initialization", "true");

		new SpringApplicationBuilder(BillingAppApplication.class).properties(props).run(args);
	}

}
