package Task2;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> buffer = new ArrayList<>();
        int size = 10;
        First producer = new First(buffer, size);
        Second consumer = new Second(buffer);
        producer.start();
        consumer.start();
    }
}
