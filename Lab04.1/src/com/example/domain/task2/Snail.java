package com.example.domain.task2;

public class Snail extends Animal implements Pet{
    @Override
    public String getName()
    {
        return name;
    }
    @Override
    public void setName(String name)
    {
        this.name = name;
    }
    @Override
    public void play()
    {
        System.out.println("Очеееень медлеееее");
    }
}
