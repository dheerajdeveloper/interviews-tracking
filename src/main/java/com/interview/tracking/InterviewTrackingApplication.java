package com.interview.tracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@PropertySource("file:///tmp/persistence-context.properties")
@SpringBootApplication
public class InterviewTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewTrackingApplication.class, args);
	}
}
