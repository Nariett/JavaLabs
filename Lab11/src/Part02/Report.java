package Part02;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Report {
    public static void generateReport(Employee[] employees,String language,String country){
        Locale current = new Locale(language, country);
        NumberFormat Format = NumberFormat.getNumberInstance(current);///
        ResourceBundle rb = ResourceBundle.getBundle("Employee", current);
        System.out.printf("%-15s %10s\n",rb.getString("fullname"),rb.getString("salary"));
        for(Employee employee:employees){
            System.out.printf("%-15s %10s\n",employee.getFullname(),Format.format(employee.getSalary()));
        }
    }
}
