package com.example.domain.task1;

import com.example.domain.task1.Employee;

public class Manager extends Employee
{
    private String deptName;
    public Manager(int empId,String name,String ssn,double salary,String deptName)
    {
        super(empId, name, ssn, salary);
        this.deptName = deptName;
    }
    public String getDeptName()
    {
        return deptName;
    }
}
