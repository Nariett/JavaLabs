package Task2;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class Second extends Thread {
    private final List<Integer> buffer;

    public Second(List<Integer> buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Прочитано " + buffer.remove(0));
                buffer.notifyAll();
            }
        }
    }
}
