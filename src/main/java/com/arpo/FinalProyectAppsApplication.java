package com.arpo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalProyectAppsApplication {

    public static void main(String[] args) {
        // Debug de variables de entorno
        System.out.println("🔍 DATABASE_URL: " + 
            (System.getenv("DATABASE_URL") != null ? "CONFIGURADA" : "NO CONFIGURADA"));
        System.out.println("🔍 PORT: " + System.getenv("PORT"));
        System.out.println("🔍 SPRING_PROFILES_ACTIVE: " + System.getenv("SPRING_PROFILES_ACTIVE"));
        System.out.println("🔍 CLOUDINARY_NAME: " + 
            (System.getenv("CLOUDINARY_NAME") != null ? "CONFIGURADA" : "NO CONFIGURADA"));
        
        SpringApplication.run(FinalProyectAppsApplication.class, args);
    }
}
