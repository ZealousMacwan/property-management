package com.zealous.propertymanagement.controller;

public class CalculatorMain {
    public static void main(String[] args){
        CalculatorController cc = new CalculatorController();
        Double result = cc.add(4.4,5.6);
        System.out.println(result);
    }
}
