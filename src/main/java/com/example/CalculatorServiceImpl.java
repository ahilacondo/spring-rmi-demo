package com.example;

import java.rmi.RemoteException;

// Quitar la extensión de UnicastRemoteObject
public class CalculatorServiceImpl implements CalculatorService {

    // Quitar el constructor que llama a super()
    
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }
}