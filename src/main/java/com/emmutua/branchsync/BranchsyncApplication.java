package com.emmutua.branchsync;

import com.emmutua.branchsync.sales.repo.SalesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BranchsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(BranchsyncApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(SalesRepository salesRepository){
		return args -> {
			 salesRepository.deleteAll();
		};
	}

}
