package Part02;

public class Employee {
    public String fullname;
    public double salary;
    public Employee(String fullname, double salary){
        this.fullname = fullname;
        this.salary = salary;
    }
    public String getFullname()
    {
        return fullname;
    }
    public double getSalary()
    {
        return salary;
    }
}
