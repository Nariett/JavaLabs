package Goods.laptop;
import Goods.Goods;

public class lp extends Goods
{
    private String monitor;
    public lp(int Id, String Name, double Price, String x)
    {
        super(Id,Name,Price);
        this.monitor = x;
    }
    @Override
    public void print()
    {
        super.print();
        System.out.println("Тип монитора: "+ monitor);
    }

}
