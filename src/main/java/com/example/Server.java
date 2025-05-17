package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Server {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
        
        System.out.println("Spring RMI Server started");
        System.out.println("Service registered on port 1099 with name 'CalculatorService'");
        System.out.println("Press Ctrl+C to stop the server");
    }
}