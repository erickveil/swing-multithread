/**
 * Created by eveil on 1/16/14.
 */
public class WorkerObject {
    public boolean is_running;
    public int counter;

    public WorkerObject()
    {
        is_running=false;
        counter=0;
    }

    public void updateMe()
    {
        ++counter;
    }
}
