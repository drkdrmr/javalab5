package com.springdemo.javalabb5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controller", "service"}) // для сканирования контроллеров и сервисов
@EnableJpaRepositories(basePackages = "repository") // для сканирования репозиториев
@EntityScan(basePackages = "com/springdemo/javalabb5/model") // для сканирования сущностей
public class Javalabb5Application {
    public static void main(String[] args) {
        SpringApplication.run(Javalabb5Application.class, args);
    }
}
