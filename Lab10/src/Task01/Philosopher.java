package Task01;

class Philosopher extends Thread {
    private Object leftFork;
    private Object rightFork;
    private boolean stop;
    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.stop = false;
    }
    public void stopPhilosopher() {
        stop = true;
    }
    public void run() {
        int count = 0;
        try {
            while (!stop) {//проверка на то, что программа не остановлена
                System.out.println(Thread.currentThread().getName() + " филосов мыслит");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " филосов взял левую вилку");
                synchronized (leftFork) {
                    System.out.println(Thread.currentThread().getName() +  " филосов взял правую вилку");
                    synchronized (rightFork) {
                        System.out.println(Thread.currentThread().getName() + " кушает" + ++count);
                        Thread.sleep(1000);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
