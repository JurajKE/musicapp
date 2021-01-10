package com.pacholsky.juraj.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@Configuration
@EntityScan("com.pacholsky.juraj.music.entity")
@EnableJpaRepositories("com.pacholsky.juraj.music.repository")
public class MusicWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicWebApplication.class, args);
    }
}
