package com.example.domain.task1;

public class Director extends Manager {
    private double budget;
    public Director(int endId,String name,String ssn, double salary, String deptName,double budget)
    {
        super(endId,name,ssn,salary,deptName);
        this.budget = budget;
    }
    public double getBudget()
    {
        return  budget;
    }
}
