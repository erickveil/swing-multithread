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

    public void runLoop() throws InterruptedException
    {
        is_running=true;

        while(is_running){
            updateMe();
            String strval=((Integer)counter).toString();
            System.out.println(strval);

            //tb_ongoing.setText(strval);

            Thread.sleep(1000);
        }

    }

}
