import java.util.Scanner;
public class Part1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Dog Ted = new Dog();
        System.out.print("Введите имя собаки ");
        Ted.name = in.next();
        System.out.print("Введите породу собаки" );
        Ted.breed = in.next();
        System.out.print("Введите возраст собаки ");
        Ted.age = in.nextInt();
        ///Ted.displayInfo();
        System.out.print("\nВведите нужный пункт меню\n");
        System.out.print("1 Вывести информацию о собаке\n2 Увеличить возраст собаки на x\n3 Голос!\n4 Сделана ли прививка\n");
        int s = in.nextInt();
        switch (s)
        {
            case 1:
                Ted.displayInfo();
                break;
            case 2:
                System.out.print("Введиие возраст на который хотите увеличить возраст собаки");
                int add = in.nextInt();
                Ted.addAYear(add);
                break;
            case 3:
                Ted.DogSay();
                break;
            case 4:
                Ted.privivka();
                break;
            case 5:
                Ted.breed();
                break;
            case 6:
                System.out.println(Ted.year());
                break;
            case 7:
                Ted.dogyes();
                break;
            default:
                System.out.println("Введены неверные данные");
        }
        //Ted.displayInfo();
        System.out.print("\n");
        //.DogSay();
    }
}
class Dog
{
    String name;
    String breed;
    int age;
    void displayInfo()
    {
        System.out.print("\nInfo about dog\nName: "+ name + "\nBreed: "+ breed+ "\nAge: " + age);
    }
    void DogSay()
    {
        System.out.print("Собака сказала: woof woof");
    }
    void addAYear(int x)
    {
        age = age + x;
    }
    void privivka()
    {
        if(age < 5) System.out.print("Прививка не сдеалана");
        else System.out.print("Прививка сдеалана");
    }
    void breed()
    {
        System.out.print("Порода собаки " + breed);
    }
    int year ()
    {
        return 2022-this.age;
    }
    void dogyes()
    {
        System.out.print("Возраст" + age);
    }
}