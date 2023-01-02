package Goods;

public class Goods
{
    private int Id;
    private String Name;
    private double Price;
    public Goods(){};

    public Goods(int Id, String Name,double Price)
    {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
    }
    public void setId(int i)
    {
        Id = i;
    }
    public int getId()
    {
        return Id;
    }
    public void setName(String n)
    {
        Name=n;
    }
    public String getName()
    {
        return Name;
    }
    public void setPrice(double p)
    {
        Price = p;
    }
    public double getPrice()
    {
        return Price;
    }
    public void print()
    {
        System.out.println("ID = "+ Id);
        System.out.println("Name = "+ Name);
        System.out.println("Price = "+ Price);
    }
}
