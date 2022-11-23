package com.SecuCom.SecuCom;

import com.SecuCom.SecuCom.Repositories.RepositoryLow;
import com.SecuCom.SecuCom.Repositories.RepositoryUsers;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecuComApplication implements CommandLineRunner {

	private RepositoryLow repositoryLow;
	private RepositoryUsers repositoryUsers;
	public  SecuComApplication(RepositoryLow repositoryLow,RepositoryUsers repositoryUsers){
		this.repositoryLow = repositoryLow;
		this.repositoryUsers = repositoryUsers;

	}



	public static void main(String[] args) {
		SpringApplication.run(SecuComApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		if (repositoryLow.findAll().size()==0){
			repositoryLow.creationRole();
		}
		if(repositoryUsers.findAll().size()==0){
			repositoryUsers.creationUsers();
		}
	}

}
