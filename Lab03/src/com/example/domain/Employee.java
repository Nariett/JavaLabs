package com.example.domain;

public class Employee {
    public int empId;
    public String name;
    public String ssn;
    public double salary;
    public Employee(){};
    public void setEmpId(int x)
    {
        empId = x;
    }
    public int getEmpId()
    {
        return empId;
    }
    public void setName(String x)
    {
        name = x;
    }
    public String getName()
    {
        return name;
    }
    public void setSsn(String x)
    {
        ssn = x;
    }
    public String getSsn()
    {
        return ssn;
    }
    public void setSalary(double x)
    {
        salary = x;
    }
    public double getSalary()
    {
        return salary;
    }
}
