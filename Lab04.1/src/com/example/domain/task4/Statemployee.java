package com.example.domain.task4;

public class Statemployee extends Employetemp {

    public double price;
    Statemployee(String name,String job,double price)
    {
        super(name,job);
        this.price=price;
    }
    @Override
    public double statFinance()
    {
        return price;
    }
    public void show()
    {
        super.show();
        System.out.println("Среднемесячная зарплата: "+statFinance());
    }
}
