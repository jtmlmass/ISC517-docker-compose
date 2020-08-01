package com.pucmm.composerprogram;

import com.pucmm.composerprogram.services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties
public class ComposerProgramApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComposerProgramApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(SecurityService securityService){
        return (args -> {
            securityService.createUsers();
            securityService.createAdmin();
            securityService.createPolls();
        });
    }

}
