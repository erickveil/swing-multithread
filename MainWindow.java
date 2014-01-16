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

    public MainWindow() {
        looper= new WorkerObject();

        startLoopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    looper.runLoop();
                }
                catch(InterruptedException e){
                    System.err.println(e.getMessage());
                }
                finally {
                    System.out.println("Finished.");
                }
            }
        });

        getValueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String strval=((Integer)looper.counter).toString();
                tb_demand.setText(strval);
            }
        });

        stopLoopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               looper.is_running=false;
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
