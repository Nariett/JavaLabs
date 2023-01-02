public class Employee {
    private String fullname;
    private double salary;
    public void setFullname(String x)
    {
        fullname = x;
    }
    public String getFullname()
    {
        return fullname;
    }
    public void setSalary(double p)
    {
        salary = p;
    }
    public double getSalary()
    {
        return salary;
    }
    public Employee(String f,double s)
    {
        fullname = f;
        salary = s;
    }

}
