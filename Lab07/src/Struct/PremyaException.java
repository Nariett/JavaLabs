package Struct;

public class PremyaException extends Exception{
    private double Premia;
    public double getPremia(){return Premia;}
    public PremyaException(){}
    public PremyaException(String message,double Premia)
    {
        super(message);
        this.Premia = Premia;
    }
}
