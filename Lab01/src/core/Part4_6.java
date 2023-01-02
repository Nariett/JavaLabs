package core;

import java.util.Scanner;
//вычисление произведений всех четных числе от 1 до n
public class Part4_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pro = 1;
        System.out.println("Введите число");
        int n = in.nextInt();
        for (int i = 1; i < n; i++)
        {
            if(i%2 == 0)
            {
                pro *= i;
            }
        }
        System.out.println(pro);
    }

}
