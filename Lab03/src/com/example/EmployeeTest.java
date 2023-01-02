package com.example;
import Goods.Goods;
import Goods.phone.phone;
import com.example.domain.Employee;

public class EmployeeTest {
    public static void main(String[] args)
    {
        Employee emp = new Employee();
        emp.setEmpId(101);
        emp.setName("Jane Smith");
        emp.setSalary(120_345.27);
        emp.setSsn("012-34-5678");
        System.out.println("Employee ID: "+emp.getEmpId());
        System.out.println("Employee Name: "+emp.getName());
        System.out.println("Employee Soc Sec # "+emp.getSsn());
        System.out.println("Employee salary: "+emp.getSalary());
        phone iphone = new phone(3,"Iphone 6 pro",145.3,"apple");
        iphone.print();
    }
}
