package com.ozgurbayrasa.cruddemo;

import com.ozgurbayrasa.cruddemo.dao.AppDAO;
import com.ozgurbayrasa.cruddemo.entity.Course;
import com.ozgurbayrasa.cruddemo.entity.Instructor;
import com.ozgurbayrasa.cruddemo.entity.InstructorDetail;
import com.ozgurbayrasa.cruddemo.entity.Review;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			// findInstructorDetail(appDAO);
			// deleteInstructorDetail(appDAO);
			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			// findCoursesForInstructor(appDAO);
			// findInstructorWithCoursesJoinFetch(appDAO);
			// updateInstructor(appDAO);
			// updateCourse(appDAO);
			// deleteCourse(appDAO);

			// createCourseAndReviews(appDAO);

			// retrieveCourseAndReviews(appDAO);

			deleteCourseAndReviews(appDAO);

		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		// Get the course id
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		appDAO.deleteCourseById(theId);
		System.out.println("DONE");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		// Get the course id
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// Create a course
		Course tempCourse = new Course("Math");

		// Add some reviews
		tempCourse.addReview(new Review("Great course."));
		tempCourse.addReview(new Review("Good course."));
		tempCourse.addReview(new Review("Bad course."));

		// Save the course, reviews will also be saved in database since cascading.
		System.out.println("Saving Course...");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDAO.saveCourse(tempCourse);
		System.out.println("DONE!");


	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO) {
		// Set a id.
		int theId = 10;

		// Find the instructor by id.
		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Updating course id: " + theId);
		tempCourse.setTitle("Updated");

		appDAO.updateCourse(tempCourse);

		System.out.println("DONE");
	}

	private void updateInstructor(AppDAO appDAO) {
		// Set a id.
		int theId = 1;

		// Find the instructor by id.
		System.out.println("Finding an instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Updating instrucor id: " + theId);
		tempInstructor.setLastName("Updated");

		appDAO.updateInstructor(tempInstructor);

		System.out.println("DONE");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;

		// find the instructor.
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("Instructor: " + tempInstructor);
		System.out.println("Courses: " + tempInstructor.getCourses());

		System.out.println("DONE");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Found instructor: " + tempInstructor);

		// Now you can get courses
		System.out.println("Finding courses for instructor id: " + tempInstructor.getId());
		List<Course> courses = appDAO.findCoursesByInstructorId(tempInstructor.getId());

		// Associate the objects.
		tempInstructor.setCourses(courses);

		System.out.println("The associated courses: " + tempInstructor.getCourses());

	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// Raises an error if fetch type is lazy. Because session will be closed.
		System.out.println("Found instructor: " + tempInstructor);
		System.out.println("Courses of instructor: " + tempInstructor.getCourses());

		System.out.println("DONE");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// Craete the instructor detail.
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://youtube.com",
				"Video Games"
		);

		// Create instructor.
		Instructor tempInstructor = new Instructor(
				"Merve",
				"Karaman",
				"tyt@ayt.com"
		);

		// Associate the objects.
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// Create new courses.
		Course tempCourse1 = new Course("Air Hockey");
		Course tempCourse2 = new Course("Pinball");

		// Add courses to the instructor's course list.
		tempInstructor.addCourse(tempCourse1);
		tempInstructor.addCourse(tempCourse2);

		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());

		// Save the instructor.
		// Also, courses will be saved, because of CascadeType.PERSIST

		appDAO.save(tempInstructor);
		System.out.println("DONE");
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
