package Task01;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Philosopher extends Thread {
    private Object leftFork;
    private Object rightFork;
    private Random random;
    private boolean stop;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.random = new Random();//используется для рандома времени
        this.stop = false;
    }

    public void stopPhilosopher() {
        stop = true;
    }

    public void run() {
        try {
            while (!stop) {//проверка на то, что программа не остановлена
                System.out.println(Thread.currentThread().getName() + " филосов мыслит");
                Thread.sleep(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName() + " филосов взял левую вилку");
                synchronized (leftFork) {
                    System.out.println(Thread.currentThread().getName() +  " филосов взял правую вилку");
                    synchronized (rightFork) {
                        System.out.println(Thread.currentThread().getName() + " кушает");
                        Thread.sleep(random.nextInt(1000));
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
