package Game;

import Game.Objects.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SteinAuswahlFenster extends JFrame {

    public SteinAuswahlFenster(Spielablauf spielablauf, Player[] spielers, int runde, int diceroll) {
        JLabel label = new JLabel("Label: schwarz = 0, grau = 1, hellgrau = 2, weiß = 3");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int index = 0;

        this.add(label);
        this.setLayout(new GridLayout(spielers[runde % 4].getSteine().size() + 1, 1));
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = Integer.parseInt(((JButton) e.getSource()).getText());
                spielablauf.spielzug(diceroll, index);
                dispose();
            }
        };

        for (; index < spielers[runde % 4].getSteine().size(); index++) {
            JButton button = new JButton("" + index);

            button.addActionListener(buttonListener);
            this.add(button);

        }

       setVisible(true);




        /*JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));


        JLabel label = new JLabel("Bitte wählen Sie eine Option:");
        JButton button1 = new JButton("1 Spieler");
        JButton button2 = new JButton("2 Spieler");
        JButton button3 = new JButton("3 Spieler");
        JButton button4 = new JButton("4 Spieler");




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


        setVisible(true);*/
    }
}