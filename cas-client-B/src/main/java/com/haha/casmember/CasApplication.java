package com.haha.casmember;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCasClient
public class CasApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasApplication.class, args);
    }

}
