import Struct.*;

public class Main {
    public static void main(String[] args)
    {
        Firma firm = new Firma("ОАО Газпрос");
        Department otdel = new Department("Механический отдел",5);
        Worker worker = new Worker("Петров Игорь Олегович", "Гланый механик",4900);
        worker.salary(15);
        Worker worker1 = new Worker("Пупки Александ Петрович","Младший механик",100);
        worker1.getZp(-100);
        worker1.salary(40);
        State sotr = new State("Константинов Константин Константинович","Ген.директор",1200,-200);//////ошибка тут
        sotr.salary(12);
        SotrPoContract sotrPoContract = new SotrPoContract("Валерьянов Валерий Валерьевич","Строитель",-2300,12);
    }
}
