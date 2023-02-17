package Task1;

public class Walk extends  Thread
{
    public void run()
    {
        for(int i = 0; i < 2; i++) {
            System.out.println(getName());
            try {

                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
