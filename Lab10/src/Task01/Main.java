package Task01;

public class Main {
    public static void main(String[] args)
    {
        int numPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Object[] forks = new Object[numPhilosophers];
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Object();
        }
        // создание 10 потоков
        for (int i = 0; i < numPhilosophers; i++)
        {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % numPhilosophers];
            //проверка на
            if (i == numPhilosophers - 1) {
                philosophers[i] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }
        }
        // начало поедания
        for(int i = 0; i < philosophers.length; i++) {
            Philosopher philosopher = philosophers[i];
            philosopher.start();
        }
        try {
            Thread.sleep(10000);//время работы программы
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // остановка поедания
        for (Philosopher philosopher : philosophers) {
            philosopher.stopPhilosopher();
        }
    }
}
