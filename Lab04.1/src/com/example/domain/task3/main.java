package com.example.domain.task3;
import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во страниц в альбоме");
        int x = in.nextInt();
        Page[]p = new Page[x];
        Photo[]ph = new Photo[x];
        for(int i = 0;i < x;i++)
        {
            Scanner w = new Scanner(System.in);
            System.out.println("Введите название фото");
            String name = w.nextLine();
            ph[i] = new Photo(name);
            System.out.println("Введите номер страницы");
            int num = w.nextInt();
            p[i] = new Page(num);
        }
        Album sport = new Album("Спорт",p,ph);
        System.out.println("Страниц в альбоме " + sport.showPage());
        sport.show();
        sport.addPage();
        sport.show();
    }
}
