package Task1;

import Task1.Talk;

public class TalkWalk {
    public static void main(String[] args) throws InterruptedException {
        Talk talk = new Talk();
        Thread walk  = new Thread(new Walk());
        System.out.println("Поток talk " + talk.getState());
        System.out.println("Поток walk " + walk.getState());
        talk.start();
        walk.start();
        System.out.println("Поток talk " + talk.getState());
        System.out.println("Поток walk " + walk.getState());
        Thread.sleep(3000);
        System.out.println("Поток talk " + talk.getState());
        System.out.println("Поток walk " + walk.getState());
    }
}
