import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Задание №1");
            System.out.println("2. Задание №2");
            System.out.println("3. Задание №3");
            System.out.println("4. Задание №4");
            System.out.println("5. Задание №5");
            int select = scanner.nextInt();

            switch (select) {
                case 1: {

                    File fileobj = new File("D:\\Java\\Lab08\\ME.txt");
                    prn("Name of file:" + fileobj.getName());
                    prn("Size of file:" + fileobj.length() + " Bytes");
                    prn("Last modified:" + fileobj.lastModified());
                    prn("Parent:" + fileobj.getParent());
                    prn("Path:" + fileobj.getPath());
                    prn("Abs Path:" + fileobj.getAbsolutePath());
                    prn("File " + (fileobj.exists() ? "exists" : " not exist"));
                    prn(fileobj.canRead() ? "can read" : "can’t read");
                    prn(fileobj.canWrite() ? "can write" : "can’t write");
                    prn("This is " + (fileobj.isDirectory() ? " " : "not") + " directory");
                    prn("This is " + (fileobj.isAbsolute() ? "absolute" : " not absolute") + (fileobj.isFile() ? " normal file" : " a named pipe"));
                    FileReader x = new FileReader("D:\\Java\\Lab08\\ME.txt");
                    int z;
                    String text = "";
                    while ((z = x.read()) != -1) {

                        text+=(char)z;
                    }
                    System.out.println(text);
                    System.out.println();
                    x.close();
                    break;
                }
                case 2: {
                    try (FileOutputStream x = new FileOutputStream("D:\\Java\\Lab08\\f.txt");)
                    {
                        String Digit = "";
                        int c = 0;
                        for (int i = 0; i < 10; i++) {
                            c = i + 1;
                            System.out.println("Введите число " + c);
                            int digit = scanner.nextInt();
                            Digit += digit + " ";

                        }
                        x.write(Digit.getBytes());
                    }
                    catch(IOException e)
                    {
                        System.out.println("Error: "+ e.getMessage());
                    }
                    try(FileReader read = new FileReader("D:\\Java\\Lab08\\f.txt"))
                    {
                        //FileReader read = new FileReader("D:\\Java\\Lab08\\f.txt");
                        int z;
                        String aver = "";
                        while ((z = read.read()) != -1) {

                            aver += (char) z;
                        }
                        System.out.println(aver);
                        System.out.println();
                        String[] arr = aver.split(" ");
                        double av = 0;
                        for (int i = 0; i < arr.length; i++) {
                            av += Double.parseDouble(arr[i]);
                        }
                        av = av / arr.length;
                        System.out.println(av);
                    }
                    catch(IOException e)
                    {
                        System.out.println("Error: "+ e.getMessage());
                    }
                    break;
                }
                case 3:
                {
                    try(FileReader read = new FileReader("D:\\Java\\Lab08\\f.txt")) {
                        int z;
                        String aver = "";
                        while ((z = read.read()) != -1) {

                            aver += (char) z;
                        }
                        System.out.println("Содержимое файла F " + aver);
                        System.out.println();
                        String[] arr = aver.split(" ");
                        double av = 0;
                        String g = "";
                        String h = "";
                        for (int i = 0; i < arr.length; i++) {
                            if (Integer.parseInt(arr[i]) % 2 == 0) {
                                g += arr[i] + " ";
                            } else {
                                h += arr[i] + " ";
                            }
                        }
                        read.close();
                        try(FileWriter x = new FileWriter("D:\\Java\\Lab08\\g.txt"))
                        {
                            x.write(g);
                        }
                        catch(IOException w)
                        {
                            System.out.println("Error: "+ w.getMessage());
                        }
                        try(FileWriter w = new FileWriter("D:\\Java\\Lab08\\h.txt"))
                        {
                            w.write(h);
                        }
                        catch(IOException w)
                        {
                            System.out.println("Error: "+ w.getMessage());
                        }
                    }
                    catch(IOException e)
                    {
                        System.out.println("Error: "+ e.getMessage());
                    }
                    break;
                }
                case 4:
                {
                    try(FileWriter x = new FileWriter("D:\\Java\\Lab08\\temp.txt"))
                    {
                        String temp = "";
                        int c = 0;
                        for (int i = 0; i < 15; i++) {
                            c = i + 1;
                            System.out.println("Введите число " + c);
                            double t = scanner.nextDouble();
                            temp += t + " ";
                        }
                        x.write(temp);
                    }
                    catch(IOException e)
                    {
                        System.out.println("Error: "+ e.getMessage());
                    }
                    try(FileReader read = new FileReader("D:\\Java\\Lab08\\temp.txt"))
                    {
                        int tp;
                        String temper = "";
                        while ((tp = read.read()) != -1) {

                            temper += (char) tp;
                        }
                        System.out.println(temper);
                        System.out.println();
                        String[] ar = temper.split(" ");
                        double aver = 0;
                        for (int i = 0; i < ar.length; i++)
                        {
                            aver+=Double.parseDouble(ar[i]);
                        }
                        aver = aver/ ar.length;
                        System.out.println("Средняя температура "+ aver);
                    }
                    catch(IOException e)
                    {
                        System.out.println("Error: "+ e.getMessage());
                    }
                    break;
                }
                case 5:
                {
                    try(FileReader x = new FileReader("D:\\Java\\Lab08\\f.txt")) {
                        int z;
                        int count = 0;
                        String text = "";
                        while ((z = x.read()) != -1) {

                            text += (char) z;
                        }
                        String[] pol = text.split(" ");
                        System.out.print("Положительные числа");
                        for (int i = 0; i < pol.length; i++) {
                            if (Integer.parseInt(pol[i]) > 0) {
                                count++;
                                System.out.print(pol[i] + " ");
                            }
                        }
                        System.out.println();
                        System.out.println("Кол-во положительных чисел: " + count);
                    }
                    catch(IOException e)
                    {
                        System.out.println("Error: "+ e.getMessage());
                    }
                    break;
                }
                default: {
                    System.out.println("Такого пункта нет!");
                    break;
                }
            }
        }
    }
    static void prn(String arg) {
        System.out.println(arg);
    }
}

