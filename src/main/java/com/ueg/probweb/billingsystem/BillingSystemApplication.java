package com.ueg.probweb.billingsystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "API para Vendas", description = "Produzido por: Erik de Sousa Mota e Davi Faria Gonçalves"))
@SpringBootApplication
public class BillingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingSystemApplication.class, args);
	}

}
