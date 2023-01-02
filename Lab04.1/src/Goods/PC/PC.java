package Goods.PC;

import Goods.Goods;

public class PC extends Goods
{
    private String GPU;
    public PC(int Id, String Name, double Price, String x)
    {
        super(Id,Name,Price);
        this.GPU = x;
    }
    @Override
    public void print()
    {
        super.print();
        System.out.println("Модель видеокарты: "+ GPU);
    }
}
