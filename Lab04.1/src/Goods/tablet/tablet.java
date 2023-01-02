package Goods.tablet;

import Goods.Goods;

public class tablet extends Goods
{
    private int Class;
    public tablet(int Id, String Name, double Price, int x)
    {
        super(Id,Name,Price);
        this.Class = x;
    }
    @Override
    public void print()
    {
        super.print();
        System.out.println("Классификация устройства: "+ Class);
    }
}
