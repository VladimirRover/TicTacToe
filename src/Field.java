import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 16.04.2017.
 */
public class Field {

    private JButton[] button;
    public void buildGUI(){
        JFrame frame = new JFrame("Tic - Tac -Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 300);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        button = new JButton[9];
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton("");
            panel.add(button[i]);
        }

        frame.add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}
