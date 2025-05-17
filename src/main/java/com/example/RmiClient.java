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

    public static void main(String[] args) throws RemoteException {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(RmiClient.class);
        
        CalculatorService calculatorService = context.getBean(CalculatorService.class);
        
        System.out.println("Adding 10 + 5 = " + calculatorService.add(10, 5));
        System.out.println("Subtracting 10 - 5 = " + calculatorService.subtract(10, 5));
        
        context.close();
    }
}