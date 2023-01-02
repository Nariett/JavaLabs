package com.example.domain.task4;

public class HourEmployee extends Employetemp {
    public double price;
    public int hours;

    HourEmployee(String name, String price, int hours) {
        super(name, price);
        this.hours = hours;
    }
    @Override
    public double statFinance() {
        hours = 10;
        double price = 20.8 * 8 * hours;
        return price;
    }

    public void show() {
        super.show();
        System.out.println("Дневная почасовая зарплата: " + statFinance());
    }
}