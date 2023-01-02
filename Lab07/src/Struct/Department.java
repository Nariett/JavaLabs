package Struct;

public class Department {
    public String name;
    public int count;
    public Department()
    {
        name = "Enginer";
        count = 10;
    }
    public  Department(String name, int count)
    {
        this.name = name;
        this.count = count;
    }
    public void getName(String name)
    {
        this.name = name;
    }
    public String setName()
    {
        return this.name;
    }
    public void getCount(int count)
    {
        this.count = count;
    }
    public int setCount()
    {
        return this.count;
    }
}
