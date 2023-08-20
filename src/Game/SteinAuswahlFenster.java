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

    }
}