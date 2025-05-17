package com.example;

import java.rmi.RemoteException;

public class CalculatorServiceImpl implements CalculatorService {
    private String serviceName = "CalculatorService";
    private int operationCount = 0;
    
    public int add(int a, int b) throws RemoteException {
        operationCount++;
        System.out.println(serviceName + ": Executing add operation (#" + operationCount + ")");
        return a + b;
    }

    public int subtract(int a, int b) throws RemoteException {
        operationCount++;
        System.out.println(serviceName + ": Executing subtract operation (#" + operationCount + ")");
        return a - b;
    }
    
    public int multiply(int a, int b) throws RemoteException {
        operationCount++;
        System.out.println(serviceName + ": Executing multiply operation (#" + operationCount + ")");
        return a * b;
    }
    
    public int divide(int a, int b) throws RemoteException {
        operationCount++;
        System.out.println(serviceName + ": Executing divide operation (#" + operationCount + ")");
        if (b == 0) {
            throw new RemoteException("Cannot divide by zero");
        }
        return a / b;
    }
    
    public int getOperationCount() throws RemoteException {
        return operationCount;
    }
}