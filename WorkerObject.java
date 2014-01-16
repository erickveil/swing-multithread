import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by eveil on 1/16/14.
 * By extending Component, we provide access to processEvent(), which lets us launch events.
 */
public class WorkerObject implements Runnable {
    public boolean is_running;
    public int counter;

    public void run()
    {
        try{
            runLoop();
        }
        catch(InterruptedException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            System.out.println("run done");
        }
    }

    public WorkerObject()
    {
        is_running=false;
        counter=0;
    }

    public void updateMe()
    {
        ++counter;
    }

    public void runLoop() throws InterruptedException
    {
        is_running=true;

        while(is_running){
            updateMe();
            String strval=((Integer)counter).toString();
            System.out.println(strval);

            Thread.sleep(1000);
        }
    }

}
