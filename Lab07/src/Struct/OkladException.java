package Struct;

public class OkladException extends Exception
{
    public double zp;
    public double getZp(){return zp;}
    public OkladException()
    {}
    public OkladException(String message, double Zp)
    {
        super(message);
        this.zp =Zp;
    }
}
