package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbfrageFenster extends JFrame {

    public AbfrageFenster() {
        setTitle("Spieleranzahl");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));


        JLabel label = new JLabel("Bitte wählen Sie eine Option:");
        JButton button1 = new JButton("1 Spieler");
        JButton button2 = new JButton("2 Spieler");
        JButton button3 = new JButton("3 Spieler");
        JButton button4 = new JButton("4 Spieler");


        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String option = ((JButton) e.getSource()).getText();
                JOptionPane.showMessageDialog(AbfrageFenster.this, "Sie haben " + option + " gewählt!");
                dispose();
                new Game();
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


        setVisible(true);
    }
}