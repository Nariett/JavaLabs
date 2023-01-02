public class Report
{
    public static void generateReport(Employee[] x)
    {
        for(int i = 0; i < x.length;i++)
        {
            System.out.printf("%15s|%.2f%n",x[i].getFullname(),x[i].getSalary());
        }
    }
}
