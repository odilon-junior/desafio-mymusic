package br.com.handson.musicas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = "br.com.handson.*")
public class MusicasApplication {

    public static void main(String[] args) {

        SpringApplication.run(MusicasApplication.class, args);
    }
}
