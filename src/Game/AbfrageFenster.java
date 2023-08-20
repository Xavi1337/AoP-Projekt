package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbfrageFenster extends JFrame {

    public AbfrageFenster() {
        setTitle("Spieleranzahl");
        setSize(400, 200);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));


        JLabel label = new JLabel("Wie viele Spieler sollen mitspielen?:");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");


        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String option = ((JButton) e.getSource()).getText();
                JOptionPane.showMessageDialog(AbfrageFenster.this, "Sie haben " + option + " Spieler gewaehlt!");
                dispose();
                new Game(Integer.parseInt(((JButton) e.getSource()).getText()));
            }
        };

        button1.addActionListener(buttonListener);
        button2.addActionListener(buttonListener);
        button3.addActionListener(buttonListener);
        button4.addActionListener(buttonListener);


        panel.add(label);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);


        add(panel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}