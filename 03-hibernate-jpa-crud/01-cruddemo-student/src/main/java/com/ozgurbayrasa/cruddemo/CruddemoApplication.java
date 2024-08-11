package com.ozgurbayrasa.cruddemo;

import com.ozgurbayrasa.cruddemo.dao.StudentDAO;
import com.ozgurbayrasa.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// Create multiple students.
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("ozgur", "bayrasa", "abc@gmail.com");
		Student tempStudent2 = new Student("ahmet", "toprak", "abeec@gmail.com");
		Student tempStudent3 = new Student("mehmet", "tekin", "absc@gmail.com");

		// Save student objects.
		System.out.println("Saving 3 students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		// Create student.
		System.out.println("Creating new student...");
		Student tempStudent = new Student("ozgur", "bayrasa", "abc@gmail.com");

		// Save student.
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// Display ID.
		System.out.println("Saved Student. Generated ID: " + tempStudent.getId());

	}


}
