package com.prueba.tecnica.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


    @Configuration
    public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/api/**")  // Permite CORS para todas las rutas que comienzan con /api/
                    .allowedOrigins("http://localhost:4200")  // Permite solicitudes desde http://localhost:4200
                    .allowedMethods("GET", "POST", "PUT", "DELETE")  // Permite los métodos HTTP necesarios
                    .allowedHeaders("*");  // Permite todos los encabezados
        }
    }
