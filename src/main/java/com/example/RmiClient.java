package com.example;

import java.rmi.RemoteException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class RmiClient {

    @Bean
    public RmiProxyFactoryBean calculatorService() {
        RmiProxyFactoryBean factoryBean = new RmiProxyFactoryBean();
        factoryBean.setServiceUrl("rmi://localhost:1099/CalculatorService");
        factoryBean.setServiceInterface(CalculatorService.class);
        return factoryBean;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(RmiClient.class);
        
        CalculatorService calculatorService = context.getBean(CalculatorService.class);
        
        try {
            System.out.println("Testing RMI calculator service:");
            System.out.println("------------------------------");
            
            // Basic operations
            System.out.println("Adding 10 + 5 = " + calculatorService.add(10, 5));
            System.out.println("Subtracting 10 - 5 = " + calculatorService.subtract(10, 5));
            System.out.println("Multiplying 10 * 5 = " + calculatorService.multiply(10, 5));
            System.out.println("Dividing 10 / 5 = " + calculatorService.divide(10, 5));
            
            // Error handling demonstration
            try {
                System.out.println("Attempting division by zero: 10 / 0");
                calculatorService.divide(10, 0);
            } catch (RemoteException e) {
                System.out.println("Error caught: " + e.getMessage());
            }
            
            // Get operation count
            System.out.println("------------------------------");
            System.out.println("Total operations performed: " + calculatorService.getOperationCount());
            
        } catch (RemoteException e) {
            System.err.println("RMI Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            context.close();
        }
    }
}