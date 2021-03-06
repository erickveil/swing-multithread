import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by eveil on 1/16/14.
 */
public class WorkerObject implements Runnable {
    private boolean is_running;
    private int counter;
    private JTextField m_ongoing;

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

    public WorkerObject(JTextField p_ongoing)
    {
        is_running=false;
        counter=0;
        m_ongoing=p_ongoing;
    }

    public void updateMe()
    {
        ++counter;
    }

    public synchronized void runLoop() throws InterruptedException
    {
        is_running=true;

        while(is_running){
            updateMe();
            String strval=((Integer)counter).toString();
            System.out.println(strval);
            m_ongoing.setText(strval);

            Thread.sleep(1000);
        }
    }

    public void setRunState(boolean state, final ActionListener al)
    {
        synchronized(al){
            is_running=state;
        }
    }

    public int getCounter(final ActionListener al)
    {
        synchronized (al){
            return counter;
        }
    }

}
