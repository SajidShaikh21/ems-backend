package net.javaguide.ems;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
		title="Empoyees Management Api ",
		version = "1.0.0",
		description = "Employee Management Api Documentation "
),
servers = @Server(
		url ="http://localhost:8080",
		description = "Employee Management Open API url"
)
)
public class EmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsBackendApplication.class, args);
	}


}
