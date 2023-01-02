package Struct;

public class State extends  Worker
{
    public double Premia;
    public  State()
    {
        Premia = 0;
    }
    public State(String name,String Dol,double P,double Premia)
    {
        super(name,Dol,P);
        this.Premia = Premia;
    }
    public double getPremia()
    {
        return Premia;
    }
    public void setPremia(double Premia)
    {
        this.Premia = Premia;
    }
    @Override
    public double salary(double hour)
    {
        try
        {
            if(hour==0)
            {
                throw new ArithmeticException();
            }
            if(getPremia()<1)
            {
                throw new PremyaException();
            }
            if(zp < 1)
            {
                throw new OkladException();
            }
            return (zp +Premia)/hour;
        }
        catch (ArithmeticException x)
        {
            System.out.println("Количество часов не может быть меньше 1!");
        }
        catch (PremyaException exe)
        {
            System.out.println("Свойство Premia - введено отрицательное значение!");
        }
        catch (OkladException a)
        {

        }
        catch (Exception e)
        {
            System.out.println("Какая-то ошибка");
        }
        finally
        {
            return 1;
        }
    }
}
