package Struct;

public class SotrPoContract extends Worker{
    public double years;
    public SotrPoContract(String name,String Dolj,double Oklad,double years)
    {
        super(name, Dolj, Oklad);
        this.years=years;
    }
    public void getYear(double years)
    {
        this.years = years;
    }
    public double setYear()
    {
        return this.years;
    }

    @Override
    public double salary(double hour)
    {
        try
        {
            if(hour==0)
            {
                throw new Exception();
            }
        }
        catch (ArithmeticException x)
        {
            System.out.println("Количечтво часов не может быть меньше 1!");
        }
        catch (Exception e)
        {
            System.out.println("Какая-то ошибка");
        }
        finally
        {
            return zp /hour*(years*365);
        }
    }
}
