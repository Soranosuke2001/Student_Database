package com.springbootyt.api_tutorial;

// import java.time.LocalDate;
// import java.time.Month;
// import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.springbootyt.api_tutorial.student.Student;

@SpringBootApplication
// @RestController
public class ApiTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTutorialApplication.class, args);
	}

	// @GetMapping
	// public String home() {
	// 	return "Hello World";
	// }
	// Note: This returns a JSON list
	// public List<Student> home() {
	// 	return List.of(
	// 		new Student(
	// 			1L,
	// 			"Mariam",
	// 			"mariam.jamal@gmail.com",
	// 			LocalDate.of(2000, Month.JANUARY, 5),
	// 			21
	// 		)
	// 	);
	// }

}
