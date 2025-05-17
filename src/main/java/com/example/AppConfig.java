package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class AppConfig {

    @Bean
    public CalculatorService calculatorService() {
        return new CalculatorServiceImpl();
    }

    @Bean
    public RmiServiceExporter rmiServiceExporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("CalculatorService");
        exporter.setServiceInterface(CalculatorService.class);
        exporter.setService(calculatorService());
        exporter.setRegistryPort(1099);
        return exporter;
    }
}