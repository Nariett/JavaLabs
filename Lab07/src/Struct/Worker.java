package Struct;

public class Worker {
    public String fio;
    public String dol;
    public double zp;
    public Worker() {

        fio = "Samoilov";
        dol = "Mechanic";
        zp = 20.00;

    }
    public Worker(String name,String Dolj,double Oklad)
    {
        try
        {
            if(Oklad <1)
            {
                throw new OkladException();
            }
            this.fio = name;
            this.dol = Dolj;
            this.zp = Oklad;
        }
        catch (OkladException e)
        {
            System.err.println("Невозможно создать сотрудника – указан отрицательный оклад: <оклад>");//err изменение цвета консоли
        }
    }
    public void getFio(String fio1)
    {
        this.fio = fio1;
    }
    public String setFio()
    {
        return this.fio;
    }
    public void getDol(String dol1)
    {
        this.dol = dol1;
    }
    public String setDol()
    {
        return this.dol;
    }
    public void getZp(double zp1)
    {
        this.zp = zp;
    }
    public double setZp()
    {
        return this.zp;
    }
    public double salary(double hour)
    {
        return zp /hour;
    }
}
