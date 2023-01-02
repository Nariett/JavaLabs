package com.example.domain.task3;

import java.util.Scanner;

public class Album {
    public Page[] page;
    public Photo[] photo;
    public String name;
    public Album (String name,Page[] p, Photo[] ph)
    {
        this.name = name;
        this.page = p;
        this.photo = ph;
    }
    public int showPage()
    {
        return page.length;
    }
    public void show()
    {
        for(int i = 0; i < page.length;i++)
        {
            System.out.print("Фотограция называется " + photo[i].showName() + " на страницуе "+ page[i].showPage() + "\n");
        }
    }
    public void addPage()
    {
        int size = page.length+1;
        Page[] np = new Page[size];
        Photo[] nph = new Photo[size];
        for(int i = 0;i < page.length;i++)
        {
            np[i] = page[i];
            nph[i] = photo[i];
        }
        Scanner r = new Scanner(System.in);
        System.out.println("Введите название фото");
        String name = r.nextLine();
        nph[page.length] = new Photo(name);
        System.out.println("Введите номер страницы");
        int num = r.nextInt();
        np[page.length] = new Page(num);
        page = np;
        photo = nph;
    }
}
