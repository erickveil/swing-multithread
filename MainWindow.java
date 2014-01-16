import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by eveil on 1/16/14.
 */
public class MainWindow {
    private JButton startLoopButton;
    private JTextField tb_ongoing;
    private JButton getValueButton;
    private JTextField tb_demand;
    private JButton stopLoopButton;
    private JPanel top_win;

    public WorkerObject looper;
    public Thread work_thread;

    public MainWindow() {
        looper= new WorkerObject(tb_ongoing);
        work_thread= new Thread(looper);

        startLoopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(work_thread.getState()==Thread.State.TERMINATED){
                    work_thread= new Thread(looper);
                }

                work_thread.start();
            }
        });

        getValueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String strval=((Integer)looper.getCounter(this)).toString();
                tb_demand.setText(strval);
            }
        });

        stopLoopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               looper.setRunState(false,this);
            }
        });


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");
        frame.setContentPane(new MainWindow().top_win);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
