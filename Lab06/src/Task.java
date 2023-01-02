import java.util.Scanner;
import java.util.Locale;
public class Task {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Задание один\nВведите строку: ");//++
        String text = in.nextLine();
        String Retext = text.toUpperCase();
        System.out.println(Retext);
        System.out.println("Задание два\nВведите строку: ");//++
        String text2 = in.nextLine();
        for(int i = text2.length()/2-1;i < text2.length()/2+1;i++)
        {
            System.out.print(text2.charAt(i));
        }
        System.out.println("\nЗадание три\nВведите строку: ");//++
        Employee[] x = new Employee[2];
        for(int i = 0; i < 2;i++)
        {
            Employee z = new Employee("name",2.1);
            x[i] = z;
        }
        Report.generateReport(x);
        System.out.println("Задание четыре\nВведите строку: ");//+++
        String text4 = in.nextLine();
        boolean f = true;
        String[] arr = text4.split(" ");
        for(int i = 0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
            if(arr[i].charAt(0) == 'a' && arr[i].charAt(arr[i].length()-1)== 'a')
            {
                for(int q = 0;q < arr[i].length();q++)
                {
                    if(Character.isDigit(arr[i].charAt(q)))
                    {
                        f = false;
                        break;
                    }
                }
                if(f == true)
                {
                    System.out.println("Да");
                }
                else
                {
                    System.out.println("Нет");
                }
            }
            else
            {
                System.out.println("нет");
            }
        }
        System.out.println("Задание пять\nВведите строку: ");//--
        String text5 = in.nextLine();
        String[] mas = text5.split(" ");
        for(int i = 0; i < mas.length;i++)
        {
            boolean t = true;
            for (int first = 0, last = mas[i].length() - 1; first < last; ++first, --last) {
                if (mas[i].charAt(first) != mas[i].charAt(last))
                {
                    t = false;
                }
            }
            if(t != true)
            {
                System.out.println("Слово не палиндром " + mas[i]);
            }
            else
            {
                System.out.println("Слово палиндром " + mas[i]);
            }
        }

    }
}
