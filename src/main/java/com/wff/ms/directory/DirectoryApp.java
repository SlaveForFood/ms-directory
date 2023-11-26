package com.wff.ms.directory;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
    info =
        @Info(
            title = "Game entities storage service",
            version = "0.1.0",
            description = "Base service of game entities"))
public class DirectoryApp {

  public static void main(String[] args) {
    SpringApplication.run(DirectoryApp.class, args);
  }
}
