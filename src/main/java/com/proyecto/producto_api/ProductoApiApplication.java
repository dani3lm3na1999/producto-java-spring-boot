package com.proyecto.producto_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ProductoApiApplication {

	public static void main(String[] args) {
		// Cargar variables de entorno desde el archivo .env
        Dotenv dotenv = Dotenv.configure().load();

        // Establecer variables de entorno manualmente
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));


		SpringApplication.run(ProductoApiApplication.class, args);
	}

}
