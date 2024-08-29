package com.ozgurbayrasa.cruddemo;

import com.ozgurbayrasa.cruddemo.dao.AppDAO;
import com.ozgurbayrasa.cruddemo.entity.Instructor;
import com.ozgurbayrasa.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			// findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 4;
		System.out.println("Deleting instructor detail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// Get the instructor detail object.
		int theId=1;
		System.out.println("Finding instructor detail id: " + theId);

		// Print the instructor detail.
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// Print the associated instructor.
		System.out.println("Instructor Detail: " + tempInstructorDetail);
		System.out.println("Associated Instructor: " + tempInstructorDetail.getInstructor());

		System.out.println("Done");

	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding the instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated instructorDetail only: " + tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {


		/*

		// Create instructor details.
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://youtube.com",
				"Football"
		);

		// Create instructor.
		Instructor tempInstructor = new Instructor(
				"Ozgur",
				"Bayrasa",
				"abc@xyz.com"
		);

		*/

		// Create instructor details.
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://youtube.com",
				"Guitar"
		);

		// Create instructor.
		Instructor tempInstructor = new Instructor(
				"Mehmet",
				"Talkan",
				"def@xyz.com"
		);
		// Associate the objects.
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// Save the instructor.
		// This will ALSO save the details object because of CascadeType.ALL
		System.out.println("Saving Instructor: " + tempInstructor);

		appDAO.save(tempInstructor);

		System.out.println("DONE");
	}

}
