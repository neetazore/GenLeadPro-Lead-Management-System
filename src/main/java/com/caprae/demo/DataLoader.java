package com.caprae.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class DataLoader {


    @Bean
    CommandLineRunner loadLeads(LeadRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Lead("Amit Sharma", "Tech Solutions", "Technology", 90));
                repository.save(new Lead("Priya Patil", "Health Plus", "Healthcare", 75));
                repository.save(new Lead("Rahul Verma", "Finance Hub", "Finance", 55));
                repository.save(new Lead("Sneha Joshi", "Retail World", "Retail", 85));
                repository.save(new Lead("Neha Singh", "Cloud Systems", "Technology", 65));
                repository.save(new Lead("Karan Mehta", "City Hospital", "Healthcare", 45));
                repository.save(new Lead("Pooja Desai", "Smart Finance", "Finance", 95));
                repository.save(new Lead("Rohan Kulkarni", "Fashion Store", "Retail", 50));
            }
        };
    }
    
}
