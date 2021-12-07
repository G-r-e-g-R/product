package com.nttdata.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(info = @Info(title = "APIs",
        version = "1.0",
        description = "Documentation APIs v1.0"))
public class ProductApplication {
    /**
     * Constructor protegido.
     */
    protected  ProductApplication() {
        super();
    }

    /**
     * Clase principal de Producto.
     * @param args
     */
    public static void main(final String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
