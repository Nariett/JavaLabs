package com.example.domain.task2;

public class PetMain {
    public static void main(String[] args) {
        Animal a;
        Spider s = new Spider();
        s.eat();
        s.walk();
        Cat c = new Cat();
        c.eat();
        c.walk();
        c.play();
        a = new Cat();
        a.eat();
        a.walk();
        Pet p;
        p = new Cat();
        p.setName("Mr. Whiskers");
        p.play();
        Fish f = new Fish();
        f.setName("Guppy");
        f.eat();
        f.walk();
        f.play();
        a = new Fish();
        a.eat();;
        a.walk();
        Snail r = new Snail();
        r.setName("Robbi");
        r.eat();
        r.walk();
        r.play();
    }
}
