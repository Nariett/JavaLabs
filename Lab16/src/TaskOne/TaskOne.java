package TaskOne;

import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Доступные категории кистей:");
        System.out.println("1. Кисти для хужожника");
        System.out.println("2. Кисти для маляров");
        System.out.println("3. Кисти для визажистов");
        System.out.print("Введите номер категории: ");
        int category = scanner.nextInt();
        BrushFactory factory;
        if (category == 1) {
            factory = new ArtistBrushFactory();
        } else if (category == 2) {
            factory = new PainterBrushFactory();
        } else if (category == 3) {
            factory = new MakeupBrushFactory();
        } else {
            System.out.println("Неверный номер категории");
            return;
        }
        Brush brush = factory.createBrush();
        System.out.println("Вы выбрали кисточку: " + brush.getType());
    }
}
