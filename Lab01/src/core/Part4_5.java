package core;

import java.util.Scanner;
//вычисление суммы всех нечетных чисел от 1 до n
public class Part4_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число");
        int n = in.nextInt();
        int i = 1;
        int sum = 0;
        while(i != n)
        {
            if(i%2 != 0)
            {
                sum += i;
            }
            i++;
        }
        System.out.println(sum);
    }
}
