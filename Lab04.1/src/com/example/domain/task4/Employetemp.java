package com.example.domain.task4;

public abstract class Employetemp {
    private String name;
    private String job;

    Employetemp(String name, String job){
        this.name=name;
        this.job=job;
    }
    public abstract double statFinance();
    public void show(){
        System.out.println("Имя: "+name+"\nДолжность: "+job);
    }
}