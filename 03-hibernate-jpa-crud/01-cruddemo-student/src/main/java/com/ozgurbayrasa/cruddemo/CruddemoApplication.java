package com.ozgurbayrasa.cruddemo;

import com.ozgurbayrasa.cruddemo.dao.StudentDAO;
import com.ozgurbayrasa.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);
			
			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);
			
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students.");
		int deletedRowNum = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + deletedRowNum) ;
	}


	private void deleteStudent(StudentDAO studentDAO) {
		int studentID = 4;
		System.out.println("Deleting student id: " + studentID);
		studentDAO.delete(studentID);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Retrieve student by ID.
		int studentId = 1;
		Student studentFound = studentDAO.findById(studentId);

		// Update a field on student.
		studentFound.setLastName("bayra");

		// Update student.
		studentDAO.update(studentFound);

		// Display list.
		queryForStudents(studentDAO);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students by last name

		List<Student> studentList = studentDAO.findByLastName("toprak");

		// Display list of students.
		for (Student tempStudent : studentList){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// Get a list of students.
		List<Student> studentList = studentDAO.findAll();

		// Display list of students.
		for (Student tempStudent : studentList){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// Create student.
		System.out.println("Creating new student...");
		Student tempStudent = new Student("ozgur", "bayrasa", "abc@gmail.com");

		// Save student.
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// Display ID.
		System.out.println("Saved Student. Generated ID: " + tempStudent.getId());

		// Retrieve student.
		System.out.println("Retrieving student with id " + tempStudent.getId() + "...");
		Student studentFound = studentDAO.findById(tempStudent.getId());

		// Display found student.
		System.out.println("Found the student: " + studentFound);
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
