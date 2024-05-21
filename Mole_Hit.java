package game;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.Serializable;

public class Mole_Hit extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;

    private JPanel panel;
    private JLabel[] holes = new JLabel[16];
    private int[] board = new int[16];

    private int score = 0;
    private int timeLeft = 30;
    private int highscore = 0;
    private boolean 게임이_시작됨 = false; 

    private JLabel lblScore;
    private JLabel lblTimeLeft;
    private JLabel lblHighscore;

    private JButton btnStart;
    private Timer timer;
    private int[] molePositions = new int[2];
    private Timer[] moleTimers = new Timer[2];
    private boolean[] moleClicked = new boolean[2];

    public Mole_Hit() {
        initGUI();
        clearBoard();
        initEvents();
        loadHighscore();

        
        for (int i = 0; i < 2; i++) {
            molePositions[i] = -1; 
            moleTimers[i] = createMoleTimer(i);
        }
    }

    private Timer createMoleTimer(int index) {
        return new Timer(1000 + (index * 500), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                board[molePositions[index]] = 0;
                holes[molePositions[index]].setIcon(loadImage("/molehole.png"));

                
                int newMolePosition;
                do {
                    newMolePosition = new Random().nextInt(16);
                } while (isMolePositionTaken(newMolePosition));
                molePositions[index] = newMolePosition;

               
                board[molePositions[index]] = 1;
                holes[molePositions[index]].setIcon(loadImage("/molechar.png"));

                
                moleTimers[index].restart();
            }
        });
    }

    private boolean isMolePositionTaken(int position) {
        for (int i = 0; i < 2; i++) {
            if (molePositions[i] == position) {
                return true;
            }
        }
        return false;
    }

    private void loadHighscore() {
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/highscore.txt"));
            line = br.readLine();
            br.close();
        } catch (IOException e) {
            
            line = "";
        }

        if (!line.equals("")) {
            highscore = Integer.parseInt(line);
            lblHighscore.setText("Highscore: " + highscore);
        }
    }

    private void saveHighscore() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/highscore.txt", false));
            bw.write("" + highscore);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            
            JOptionPane.showMessageDialog(this, "Error saving highscore: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void gameOver() {
        btnStart.setEnabled(true);
        if (score > highscore) {
            highscore = score;
            lblHighscore.setText("Highscore: " + highscore);
            JOptionPane.showMessageDialog(this, "Your final score is: " + score, "You beat the high score!",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Your final score is: " + score, "Game Over!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        score = 0;
        timeLeft = 30;
        lblScore.setText("Score: 0");
        lblTimeLeft.setText("30");

        clearBoard();

        saveHighscore();

        
        for (int i = 0; i < 2; i++) {
            moleTimers[i].stop();
        }
    }

    private void pressedButton(int moleIndex) {
        int val = board[molePositions[moleIndex]];

        if (val == 1) {
            score++;
        } else if (val == 2) { 
            score--;
        }

        lblScore.setText("Score: " + score);

        
        moleTimers[moleIndex].stop();
        board[molePositions[moleIndex]] = 0;
        holes[molePositions[moleIndex]].setIcon(loadImage("/molehole.png"));

       
        moleClicked[moleIndex] = false;

        
        genRandMole(moleIndex);
    }


    private void initEvents() {
        for (int i = 0; i < holes.length; i++) {
            holes[i].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (게임이_시작됨) { 
                        JLabel lbl = (JLabel) e.getSource();
                        int id = Integer.parseInt(lbl.getName());

                        // 이미 클릭한 두더지를 다시 클릭하지 못하도록 처리
                        for (int j = 0; j < 2; j++) {
                            if (!moleClicked[j] && molePositions[j] == id) {
                                moleClicked[j] = true;
                                pressedButton(j);
                                break;
                            }
                        }
                    }
                }
            });
        }

        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnStart.setEnabled(false);
                clearBoard();
                for (int i = 0; i < 2; i++) {
                    genRandMole(i); 
                }
                timer.start();

                
                for (int i = 0; i < 2; i++) {
                    moleTimers[i].start();
                }
                게임이_시작됨 = true; 
            }
        });

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                lblTimeLeft.setText("" + timeLeft);
                timeLeft--;

                if (timeLeft == 0) {
                    lblTimeLeft.setText("" + timeLeft);
                    timer.stop();
                    gameOver();
                }
            }
        });
    }

    private void initGUI() {
        setTitle("Whack A Mole");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 608, 720);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 51, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("Whack A Mole");
        lblTitle.setForeground(new Color(153, 204, 0));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 20));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        panel = new JPanel(new GridLayout(4, 4));
        panel.setBackground(new Color(0, 102, 0));
        contentPane.add(panel, BorderLayout.CENTER);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image cursorImage = loadImage("/hammer.png").getImage();
        Point cursorHotSpot = new Point(0, 0);
        Cursor customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "custom cursor1");
        panel.setCursor(customCursor);

        contentPane.add(panel, BorderLayout.CENTER);

        for (int i = 0; i < 16; i++) {
            holes[i] = new JLabel();
            holes[i].setName(Integer.toString(i));
            holes[i].setIcon(loadImage("/molehole.png"));
            board[i] = 0;
            panel.add(holes[i]);
        }

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(0, 102, 0));
        contentPane.add(bottomPanel, BorderLayout.SOUTH);
        

        lblScore = new JLabel("Score: 0");
        lblScore.setHorizontalAlignment(SwingConstants.TRAILING);
        lblScore.setFont(new Font("Cambria", Font.BOLD, 20));
        lblScore.setForeground(new Color(135, 206, 250));      
        bottomPanel.add(lblScore);
        
        bottomPanel.add(Box.createRigidArea(new Dimension(20, 0)));

        lblTimeLeft = new JLabel("30");
        lblTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);
        lblTimeLeft.setForeground(new Color(240, 128, 128));
        lblTimeLeft.setFont(new Font("Cambria Math", Font.BOLD, 24));
        bottomPanel.add(lblTimeLeft);
        
        bottomPanel.add(Box.createRigidArea(new Dimension(20, 0)));

        lblHighscore = new JLabel("Highscore: 0");
        lblHighscore.setHorizontalAlignment(SwingConstants.TRAILING);
        lblHighscore.setForeground(new Color(255, 255, 0));
        lblHighscore.setFont(new Font("Cambria", Font.BOLD, 14));
        bottomPanel.add(lblHighscore);
        
        bottomPanel.add(Box.createRigidArea(new Dimension(20, 0)));

        btnStart = new JButton("Start");
        btnStart.setBackground(Color.WHITE);
        bottomPanel.add(btnStart);

        setContentPane(contentPane);
    }

    private void clearBoard() {
        for (int i = 0; i < 16; i++) {
            holes[i].setIcon(loadImage("/molehole.png"));
            board[i] = 0;
        }
    }

    private void genRandMole(int moleIndex) {
        if (molePositions[moleIndex] == -1) {
            int newMolePosition;
            do {
                newMolePosition = new Random().nextInt(16);
            } while (isMolePositionTaken(newMolePosition));

            
            if (moleIndex == 0) {
                board[newMolePosition] = 1;
                holes[newMolePosition].setIcon(loadImage("/molechar.png"));
            } else {
                
                moleTimers[moleIndex] = createMoleTimer(moleIndex);
                board[newMolePosition] = 2; 
                holes[newMolePosition].setIcon(loadImage("/molech.png"));
            }

            molePositions[moleIndex] = newMolePosition;

            
            moleTimers[moleIndex].start();
        } else {
            
            int newMolePosition;
            do {
                newMolePosition = new Random().nextInt(16);
            } while (isMolePositionTaken(newMolePosition));

            
            board[molePositions[moleIndex]] = 0;
            holes[molePositions[moleIndex]].setIcon(loadImage("/molehole.png"));

           
            if (moleIndex == 0) {
                board[newMolePosition] = 1;
                holes[newMolePosition].setIcon(loadImage("/molechar.png"));
            } else {
               
                moleTimers[moleIndex] = createMoleTimer(moleIndex);
                board[newMolePosition] = 2; 
                holes[newMolePosition].setIcon(loadImage("/molech.png"));
            }

            molePositions[moleIndex] = newMolePosition;

            
            moleTimers[moleIndex].start();
        }
    }


    private ImageIcon loadImage(String path) {
        String absolutePath = "image" + path;
        Image image = new ImageIcon(absolutePath).getImage();
        Image scaledImage = image.getScaledInstance(132, 134, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    

//    private ImageIcon loadImage(String path) {
//        Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
//        Image scaledImage = image.getScaledInstance(132, 134, java.awt.Image.SCALE_SMOOTH);
//        return new ImageIcon(scaledImage);
//    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	Mole_Hit frame = new Mole_Hit();
            frame.setVisible(true);
        });
    }
}