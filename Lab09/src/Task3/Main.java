package Task3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args)
    {
        try(CommonResourse resourse = new CommonResourse("t.txt"))
        {
            UseFileThread thread1 = new UseFileThread("first",resourse);
            UseFileThread thread2 = new UseFileThread("second",resourse);
            thread1.start();
            thread2.start();
            TimeUnit.SECONDS.sleep(5);
        }
        catch ( IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
    }
}
