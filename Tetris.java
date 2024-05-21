package game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Timer;

public class Tetris {

    private Game game = null;
    private Label lblScore;

    public static void main(String[] args) {
        System.out.println("starting");
        Frame frame = new Frame("Tetris");
        final Game game = new Game();

        game.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("PCE " + evt.getPropertyName() + " " + evt.getNewValue());
            }
        });

        final TextArea taHiScores = new TextArea("", 10, 10, TextArea.SCROLLBARS_NONE);

        taHiScores.setBackground(Color.black);
        taHiScores.setForeground(Color.white);
        taHiScores.setFont(new Font("monospaced", 0, 11));
        taHiScores.setEditable(false);

        final TextField txt = new TextField();
        txt.setEnabled(false);

        game.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("state")) {
                    int state = ((Integer) evt.getNewValue()).intValue();
                    if (state == Game.STATE_GAMEOVER) {
                        txt.setEnabled(true);
                        txt.requestFocus();
                        txt.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                txt.setEnabled(false);
                                game.init();
                                // 게임 시작 및 playerName을 사용하여 게임 창에 이름을 표시하는 로직 추가
                                String playerName = txt.getText();
                                game.start();
                            }
                        });
                        // 점수 표시...
                    }
                }
            }
        });

        final TextField playerNameField = new TextField("PLAYER를 입력하세요.");
        playerNameField.setEnabled(true);

        Button btnStart = new Button("Start");
        btnStart.setFocusable(false);
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.start();
            }
        });

        // Create a label for the score
        Label lblScore = new Label("Score: 0");

        final Container c = new Container();
        c.setLayout(new BorderLayout());
        c.add(txt, BorderLayout.NORTH);
        c.add(game.getSquareBoardComponent(), BorderLayout.CENTER);
        c.add(btnStart, BorderLayout.SOUTH);

        final Container c2 = new Container();
        c2.setLayout(new GridLayout(1, 2));
        c2.add(c);
        c2.add(taHiScores);

        frame.add(c2);

        System.out.println("packing");

        frame.pack();

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
        
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                taHiScores.setText("획득한 점수판\n" +
                       "-----------------------------\n\n" +
                       "LEVEL    SCORE\n\n" +
                        game.getLevel() + "        " + game.getScore());
            }
        });
        timer.start();
    }
}