import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 16.04.2017.
 */
public class Field {

    private JButton[] button;
    private boolean isXStep = true;
    public void buildGUI(){
        JFrame frame = new JFrame("Tic - Tac -Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 300);


        JMenuBar bar  = new JMenuBar();
        JMenu fleMenu = new JMenu("File");
        JMenuItem newGame = new JMenuItem("New game");
        JMenuItem quit = new JMenuItem("Quit");


        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0; i < button.length; i++) {
                    button[i].setText("");
                }
                isXStep = true;
            }
        });
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        fleMenu.add(newGame);
        fleMenu.add(quit);
        bar.add(fleMenu);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        button = new JButton[9];
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton("");
            button[i].setFont(new Font("Arial", Font.BOLD, 50));
            final int k = i;
            button[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    if (button[k].getText().equals("")) {
                        if (isXStep) {
                            button[k].setText("X");
                            isXStep = false;
                        } else {
                            button[k].setText("0");
                            isXStep = true;
                        }
                    }
                }
            });
            panel.add(button[i]);
        }

        frame.setJMenuBar(bar);
        frame.add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}
