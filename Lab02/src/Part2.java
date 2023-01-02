import java.util.Random;
public class Part2 {
    public static void main(String[] args)
    {
        Rand ra = new Rand();
        int x = ra.randommas();
        System.out.print("рандомное число из массива "+ x);
    }

}
class Rand
{
    private static Random random = new Random();
    private int [] mas1 = {1,2,3};
    private int [] mas2 = {1,2,10};
    public int randommas()
    {
        int q = 0;
        for(int i = 0; i < mas2.length;i++)
        {
            q+=mas2[i];
        }
        int mas3[] = new int[q];
        for(int i = 0; i < mas1.length;i++)
        {
            for(int j = 0; j < mas2[i];j++)
            {
                int x ;
                do
                {
                    x = random.nextInt(0,13);
                }
                while(mas3[x] != 0);
                mas3[x] = mas1[i];
            }
        }
        for(int i = 0;i < mas3.length;i++)
        {
            System.out.println(mas3[i]);
        }
        /*for(int i = 0;i < 2;i++)
        {
            int x ;
            do
            {
                x = random.nextInt(0,13);
            }
            while(mas3[x] != 0);
            mas3[x] = 2;
        }
        for(int i = 0 ;i < 10;i++)
        {
            int x ;
            do
            {
                x = random.nextInt(0,13);
            }
            while(mas3[x] != 0);
            mas3[x] = 3;
        }*/
        return mas3[random.nextInt(0,13)];
    }
}
