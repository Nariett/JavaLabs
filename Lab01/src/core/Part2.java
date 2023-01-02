package core;
import java.util.Scanner;
import javax.crypto.CipherOutputStream;

public class Part2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = in.nextInt();
        }
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        System.out.print("Повторились числа: ");
        for(int i = 0; i < array.length; i++)
        {

            int x = array[i];
            int p = 0;
            for(int j = 0; j < array.length; j++)
            {
                if (array[j] == x)
                {
                    p++;
                }
            }
            if(p > 1)
            {
                System.out.print(x + " ");
            }
        }

    }
}
