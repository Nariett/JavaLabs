package core;

import java.util.Scanner;
//вывод названия страны по введеннной столице
public class Part4_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите столицу");
        String number = in.nextLine();
        switch (number)
        {
            case "Минск":
                System.out.println("Беларусь");
                break;
            case "Москва":
                System.out.println("Россия");
                break;
            case "Киев":
                System.out.println("Украина");
                break;
            case "Париж":
                System.out.println("Франция");
                break;
            case "Берлин":
                System.out.println("Германия");
                break;
            default:
                System.out.println("Введена наверная столица");
        }
    }
}
