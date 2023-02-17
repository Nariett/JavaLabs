package  Task2;
import java.util.List;

public class First extends Thread {
    private final List<Integer> buffer;
    private final int size;

    public First(List<Integer> buffer, int sizeList) {
        this.buffer = buffer;
        this.size = sizeList;
    }

    public void run() {
        for (int i = 0; i < 10; i++)
        {
            synchronized (buffer) {
                while (buffer.size() == size) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buffer.add(i);
                System.out.println("Записано: " + i);
                buffer.notifyAll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}