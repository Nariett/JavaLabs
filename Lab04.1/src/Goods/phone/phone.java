package Goods.phone;
import Goods.Goods;
public class phone extends Goods
{
    private String company;
    public phone(int Id, String Name, double Price, String x)
    {
        super(Id,Name,Price);
        this.company = x;
    }
    @Override
    public void print()
    {
        super.print();
        System.out.println("Компания производитель: "+ company);
    }
}