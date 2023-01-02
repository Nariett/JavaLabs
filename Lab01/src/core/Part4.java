package core;

import java.util.Scanner;
//проверка делится ли число
public class Part4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите делимое");
        int num = in.nextInt();
        System.out.println("Введите делитель");
        int n = in.nextInt();
        if( num%n == 0)
        {
            System.out.println("Делится");
        }
        else
        {
            System.out.println("Не делится");
        }
    }
}
