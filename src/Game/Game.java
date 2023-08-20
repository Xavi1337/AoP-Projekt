package Game;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;

public class Game extends JFrame {

    private Display display;
    private JPanel gameContent;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JButton wuerfel;
    private JButton neustart;

    public Game(int teilnehmer) {
        setTitle("Mensch Aergere Dich Nicht!");
        setSize(1920, 1080);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setGameContent(new JPanel());
        getGameContent().setBorder(null);
        getGameContent().setLayout(null);
        getGameContent().setBounds(0,0,1920,1080);
        setContentPane(getGameContent());

        //Spielfeld
        setDisplay(new Display());
        getDisplay().setBounds(10, 10, 1025, 1025);
        getGameContent().add(getDisplay());

        //Textfeld für Konsolenausgabe
        setTextArea(new JTextArea());
        getTextArea().setEditable(false);
        getTextArea().setFont(new Font("Tahoma", Font.PLAIN, 16));
        setScrollPane(new JScrollPane(getTextArea()));
        getScrollPane().setBounds(1045, 10, 860, 975);
        getGameContent().add(getScrollPane());

        ConsoleOutputStream consoleOutput = new ConsoleOutputStream(getTextArea());
        System.setOut(new PrintStream(consoleOutput));

        //Game Handler
        DiceRollHandler rollHandler = new DiceRollHandler(getDisplay(), teilnehmer);

        //Würfel Button
        setWuerfel(new JButton("Wuerfeln"));
        getWuerfel().addActionListener(rollHandler);
        getWuerfel().setBounds(1805, 995, 100, 40);
        getGameContent().add(getWuerfel());

        //Restart Handler
        RestartHandler restartHandler = new RestartHandler(this);

        //Neustart Button
        setNeustart(new JButton("Neustart"));
        getNeustart().addActionListener(restartHandler);
        getNeustart().setBounds(1045, 995, 100, 40);
        getGameContent().add(getNeustart());

        setVisible(true);
    }

    public static void main(String[] args) {
            new AbfrageFenster();
    }

    public JPanel getGameContent() {
        return gameContent;
    }

    public void setGameContent(JPanel gameContent) {
        this.gameContent = gameContent;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JButton getWuerfel() {
        return wuerfel;
    }

    public void setWuerfel(JButton wuerfel) {
        this.wuerfel = wuerfel;
    }

    public JButton getNeustart() {
        return neustart;
    }

    public void setNeustart(JButton neustart) {
        this.neustart = neustart;
    }
}