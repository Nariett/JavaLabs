package core;
//Выведите на экран все целые числа в диапазоне 811-851 на экран
//с помощью функции do..while. Между числами знак табуляции
public class Part5 {
    public static void main(String[] args) {
        int i = 811;
        do
        {
            i++;
            System.out.print(i+"\t");
        }
        while(i != 851);
    }
}
