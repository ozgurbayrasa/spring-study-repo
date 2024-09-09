package com.ozgurbayrasa.aopdemo;

import com.ozgurbayrasa.aopdemo.dao.AccountDAO;
import com.ozgurbayrasa.aopdemo.dao.MembershipDAO;
import com.ozgurbayrasa.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO theAccountDAO,  MembershipDAO theMembershipDAO,
												TrafficFortuneService theTrafficFortuneService){

		return runner -> {

			// demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			// demoTheAfterReturningAdvice(theAccountDAO);
			// demoTheAfterThrowingAdvice(theAccountDAO);
			// demoTheAfterAdvice(theAccountDAO);
			// demoTheAroundAdvice(theTrafficFortuneService);
			demoTheAroundAdviceHandleException(theTrafficFortuneService);
		};
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("Main Program: demoTheAroundService");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;

		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("My fortune is: " + data);
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("Main Program: demoTheAroundService");

		System.out.println("Calling getFortune()");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("My fortune is: " + data);
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		// Call method to find accounts.
		List<Account> theAccounts = null;

		try{
			// Add a boolean flag the simulate exceptions.
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch (Exception exc){
			System.out.println("\n\nMainProgram: ... caught exception: " + exc);
		}

		System.out.println("\n\nMainProgram: demoTheAfterThrowingAdvice");
		System.out.println("------------");

		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		// Call method to find accounts.
		List<Account> theAccounts = null;

		try{
			// Add a boolean flag the simulate exceptions.
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch (Exception exc){
			System.out.println("\n\nMainProgram: ... caught exception: " + exc);
		}

		System.out.println("\n\nMainProgram: demoTheAfterThrowingAdvice");
		System.out.println("------------");

		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		// Call method to find accounts.
		List<Account> theAccounts = theAccountDAO.findAccounts();

		System.out.println("\n\nMainProgram: demoTheAfterReturningAdvice");
		System.out.println("------------");

		System.out.println(theAccounts);
		System.out.println("\n");

	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		// Call business method.
		theAccountDAO.addAccount(new Account("Ozgur", "cloudService"), true);
		theAccountDAO.addSillyAccount();
		theAccountDAO.doWork();

		System.out.println("\n-GETTER/SETTER-\n");
		// Call the AccountDAO getter/setter methods
		theAccountDAO.setName("tr");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();
		System.out.println("\n----------------\n");

		// Call membership business method.
		theMembershipDAO.addMember();
		theMembershipDAO.goToSleep();
	}

}
