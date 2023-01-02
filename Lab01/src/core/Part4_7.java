package core;

import java.util.Scanner;
//проверка соответсвий веса и роста
public class Part4_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите рост в см");
        int height = in.nextInt();
        System.out.println("Введите массу");
        int weight = in.nextInt();
        double x = height - 100 ;
        if (x < 18.49) {
            System.out.println("Нужно поправиться");
        }
        else if (x >= 18.5 && x  <= 24.9) {
            System.out.println("Вес в норме");
        }
        else if (x >= 25 && x <= 29.9) {
            System.out.println("Нужно похудеть!");
        }
    }
}
