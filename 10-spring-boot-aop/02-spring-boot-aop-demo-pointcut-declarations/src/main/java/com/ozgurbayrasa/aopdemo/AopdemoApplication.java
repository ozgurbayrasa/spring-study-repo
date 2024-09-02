package com.ozgurbayrasa.aopdemo;

import com.ozgurbayrasa.aopdemo.dao.AccountDAO;
import com.ozgurbayrasa.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO theAccountDAO,  MembershipDAO theMembershipDAO){

		return runner -> {

			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		// Call business method.
		theAccountDAO.addAccount(new Account(), true);
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
