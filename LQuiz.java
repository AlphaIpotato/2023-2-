package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LQuiz {

    private static JPanel cardPanel;
    private static CardLayout cardLayout;
    private static int score = 0;
    private static JLabel scoreLabel;

    // 기본 생성자
    public LQuiz() {
        // 생성자 내용
    }

    // front 클래스의 생성자를 추가
    public LQuiz(JPanel cardPanel, CardLayout cardLayout) {
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        createAndShowGUI(); // GUI를 초기화하는 메서드 호출
    }

    private void createAndShowGUI() {
        // JFrame 생성
        JFrame frame = new JFrame("퀴즈 게임");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);

        // CardLayout을 사용할 패널 생성
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        frame.add(cardPanel);

        // 초기 화면 패널
        JPanel initialPanel = createInitialPanel();   
        cardPanel.add(initialPanel, "initial");

        // 첫번째 문제 화면 패널
        JPanel gamePanel = createGamePanel();
        cardPanel.add(gamePanel, "game");
        
        // 두번째 문제 화면 패널
        JPanel gamePanel2 = createGamePanel2();
        cardPanel.add(gamePanel2, "game2");
        
        // 세번째 문제 화면 패널
        JPanel gamePanel3 = createGamePanel3();
        cardPanel.add(gamePanel3, "game3");
        
        // 네번째 문제 화면 패널
        JPanel gamePanel4 = createGamePanel4();
        cardPanel.add(gamePanel4, "game4");
        
        // 다섯번째 문제 화면 패널
        JPanel gamePanel5 = createGamePanel5();
        cardPanel.add(gamePanel5, "game5");
        
        // 여섯번째 문제 화면 패널
        JPanel gamePanel6 = createGamePanel6();
        cardPanel.add(gamePanel6, "game6");
        
        // 일곱번째 문제 화면 패널
        JPanel gamePanel7 = createGamePanel7();
        cardPanel.add(gamePanel7, "game7");
        
        // 여덟번째 문제 화면 패널
        JPanel gamePanel8 = createGamePanel8();
        cardPanel.add(gamePanel8, "game8");

        // 아홉번째 문제 화면 패널
        JPanel gamePanel9 = createGamePanel9();
        cardPanel.add(gamePanel9, "game9");
        
        // 열번째 문제 화면 패널
        JPanel gamePanel10 = createGamePanel10();
        cardPanel.add(gamePanel10, "game10");

        JPanel scorePanel = createScorePanel();
        cardPanel.add(scorePanel, "score");

        frame.setVisible(true);
    }


    private static JPanel createInitialPanel() {
        JPanel panel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("image/MainImage.jpeg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        
        panel.setLayout(null);
        
        JLabel startLabel = new JLabel("롤 퀴즈 맞추기 게임");
        startLabel.setBounds(450, 50, 400, 50);  // 위치와 크기 조정
        startLabel.setFont(new Font(startLabel.getFont().getName(), Font.PLAIN, 44));
        startLabel.setForeground(Color.WHITE);
        startLabel.setHorizontalAlignment(JLabel.CENTER);


        JButton startButton = new JButton("게임 시작");
        startButton.setBounds(600, 500, 100, 50);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.setBackground(Color.WHITE);
        startButton.setForeground(Color.BLACK);

        JButton exitButton = new JButton("게임 종료");
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.setBounds(600, 560, 100, 50);
        exitButton.setBackground(Color.WHITE);
        exitButton.setForeground(Color.BLACK);

        // 게임 시작 버튼에 ActionListener 추가
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 게임 시작 버튼을 눌렀을 때 게임 패널로 전환
                cardLayout.show(cardPanel, "game");
            }
        });

        // 게임 종료 버튼에 ActionListener 추가
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 종료 버튼을 눌렀을 때 종료 로직 추가
                System.exit(0); // 간단하게 종료하는 예시입니다.
            }
        });
        

        panel.add(startLabel);
        panel.add(startButton);
        panel.add(exitButton);

        return panel;
    }

    
    

    private static JPanel createGamePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // 이미지를 패널의 중앙에 추가
        ImageIcon imageIcon = new ImageIcon("image/DemaciaCrest.png");
        JLabel imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel, BorderLayout.CENTER);

        // 버튼을 패널의 아래에 추가
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // 버튼 1
        JButton button1 = new JButton("세나");
        button1.setPreferredSize(new Dimension(150, 50));
        button1.setFocusPainted(false);
        button1.setBackground(Color.WHITE);
        button1.setForeground(Color.BLACK);
        buttonPanel.add(button1);

        // 버튼 2
        JButton button2 = new JButton("사일러스");
        button2.setPreferredSize(new Dimension(150, 50));
        button2.setFocusPainted(false);
        button2.setBackground(Color.WHITE);
        button2.setForeground(Color.BLACK);
        buttonPanel.add(button2);

        // 버튼 3
        JButton button3 = new JButton("루시안");
        button3.setPreferredSize(new Dimension(150, 50));
        button3.setFocusPainted(false);
        button3.setBackground(Color.WHITE);
        button3.setForeground(Color.BLACK);
        buttonPanel.add(button3);

        // 버튼 4
        JButton button4 = new JButton("탈론");
        button4.setPreferredSize(new Dimension(150, 50));
        button4.setFocusPainted(false);
        button4.setBackground(Color.WHITE);
        button4.setForeground(Color.BLACK);
        buttonPanel.add(button4);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 다음 패널로 이동합니다.
                cardLayout.show(cardPanel, "game2");
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 다음 패널로 이동합니다.
                cardLayout.show(cardPanel, "game2");
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 다음 패널로 이동합니다.
                cardLayout.show(cardPanel, "game2");
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 다음 패널로 이동합니다.
               score++;
               updateScoreLabel();
               // 정답인 경우에만 점수를 증가시킵니다.
                cardLayout.show(cardPanel, "game2");

            }
        });

        // 라벨 추가
        JLabel labelText = new JLabel("다음 소속에 해당하는 챔피언은 이름은?");
        labelText.setHorizontalAlignment(JLabel.CENTER);
        labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
        panel.add(labelText, BorderLayout.NORTH);

        return panel;
    }

   private static JPanel createGamePanel2() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // 이미지를 패널의 중앙에 추가
       ImageIcon imageIcon = new ImageIcon("image/NoxusCrest.png");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // 버튼을 패널의 아래에 추가
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
   
       // 버튼 1
       JButton button1 = new JButton("카시오페아");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // 버튼 2
       JButton button2 = new JButton("신짜오");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // 버튼 3
       JButton button3 = new JButton("리븐");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // 버튼 4
       JButton button4 = new JButton("렐");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
   
       panel.add(buttonPanel, BorderLayout.SOUTH);
   
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game3");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
              score++;
              updateScoreLabel();
               cardLayout.show(cardPanel, "game3");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game3");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 정답인 경우에만 점수를 증가시킵니다.
               cardLayout.show(cardPanel, "game3");
           }
       });
       
       JLabel labelText = new JLabel("다음 소속에 해당하는 챔피언은 이름은?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   private static JPanel createGamePanel3() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // 이미지를 패널의 중앙에 추가
       ImageIcon imageIcon = new ImageIcon("image/Piltover.png");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // 버튼을 패널의 아래에 추가
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // 버튼 1
       JButton button1 = new JButton("블리츠크랭크");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // 버튼 2
       JButton button2 = new JButton("하이머딩거");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // 버튼 3
       JButton button3 = new JButton("이즈리얼");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // 버튼 4
       JButton button4 = new JButton("세라핀");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
       
       panel.add(buttonPanel, BorderLayout.SOUTH);
       
   
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
              score++;
              updateScoreLabel();
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game4");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game4");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game4");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game4");
           }
       });
       
        JLabel labelText = new JLabel("다음 소속에 해당하는 챔피언은 이름은?");
        labelText.setHorizontalAlignment(JLabel.CENTER);
        labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
        panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   
   private static JPanel createGamePanel4() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // 이미지를 패널의 중앙에 추가
       ImageIcon imageIcon = new ImageIcon("image/Ionia.png");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // 버튼을 패널의 아래에 추가
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // 버튼 1
       JButton button1 = new JButton("케넨");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // 버튼 2
       JButton button2 = new JButton("신드라");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // 버튼 3
       JButton button3 = new JButton("헤카림");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // 버튼 4
       JButton button4 = new JButton("릴리아");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
       
       panel.add(buttonPanel, BorderLayout.SOUTH);
       
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
              score++;
              updateScoreLabel();
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game5");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game5");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game5");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game5");
           }
       });
   
       // 라벨 추가
       JLabel labelText = new JLabel("다음 소속에 해당하지 않는 챔피언은 이름은?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   private static JPanel createGamePanel5() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // 이미지를 패널의 중앙에 추가
       ImageIcon imageIcon = new ImageIcon("image/Ixtal.jpeg");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // 버튼을 패널의 아래에 추가
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // 버튼 1
       JButton button1 = new JButton("니달리");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // 버튼 2
       JButton button2 = new JButton("말파이트");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // 버튼 3
       JButton button3 = new JButton("렝가");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // 버튼 4
       JButton button4 = new JButton("티모");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
       
       panel.add(buttonPanel, BorderLayout.SOUTH);
       
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game6");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game6");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game6");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
              score++;
              updateScoreLabel();
               cardLayout.show(cardPanel, "game6");
           }
       });
   
       // 라벨 추가
       JLabel labelText = new JLabel("다음 소속에 해당하지 않는 챔피언은 이름은?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   private static JPanel createGamePanel6() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // 이미지를 패널의 중앙에 추가
       ImageIcon imageIcon = new ImageIcon("image/Shurima.jpeg");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // 버튼을 패널의 아래에 추가
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // 버튼 1
       JButton button1 = new JButton("람머스");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // 버튼 2
       JButton button2 = new JButton("스카너");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // 버튼 3
       JButton button3 = new JButton("아무무");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // 버튼 4
       JButton button4 = new JButton("라이즈");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
       
       panel.add(buttonPanel, BorderLayout.SOUTH);
       
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game7");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game7");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game7");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
              score++;
              updateScoreLabel();
               cardLayout.show(cardPanel, "game7");
           }
       });
   
       // 라벨 추가
       JLabel labelText = new JLabel("다음 소속에 해당하지 않는 챔피언은 이름은?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   private static JPanel createGamePanel7() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // 이미지를 패널의 중앙에 추가
       ImageIcon imageIcon = new ImageIcon("image/BandleCity.jpeg");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // 버튼을 패널의 아래에 추가
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // 버튼 1
       JButton button1 = new JButton("뽀삐");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // 버튼 2
       JButton button2 = new JButton("나르");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // 버튼 3
       JButton button3 = new JButton("클레드");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // 버튼 4
       JButton button4 = new JButton("코르키");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
       
       panel.add(buttonPanel, BorderLayout.SOUTH);
       
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game8");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game8");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game8");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
              score++;
              updateScoreLabel();
               cardLayout.show(cardPanel, "game8");
   
           }
       });
   
   
       // 라벨 추가
       JLabel labelText = new JLabel("다음 소속에 해당하는 챔피언은 이름은?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   private static JPanel createGamePanel8() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // 이미지를 패널의 중앙에 추가
       ImageIcon imageIcon = new ImageIcon("image/Quiz7.png");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // 버튼을 패널의 아래에 추가
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // 버튼 1
       JButton button1 = new JButton("여행용 강철의 영약");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // 버튼 2
       JButton button2 = new JButton("여행용 마법의 영약");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // 버튼 3
       JButton button3 = new JButton("여행용 분노의 영약");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // 버튼 4
       JButton button4 = new JButton("훔친 예언자의 추출액");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
       
       panel.add(buttonPanel, BorderLayout.SOUTH);
       
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game9");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game9");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game9");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
              score++;
              updateScoreLabel();
               cardLayout.show(cardPanel, "game9");
           }
       });
   
       // 라벨 추가
       JLabel labelText = new JLabel("다음 아이템의 이름으로 알맞은 것은?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   private static JPanel createGamePanel9() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // 이미지를 패널의 중앙에 추가
       ImageIcon imageIcon = new ImageIcon("image/Quiz9.png");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // 버튼을 패널의 아래에 추가
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // 버튼 1
       JButton button1 = new JButton("여행용 강철의 영약");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // 버튼 2
       JButton button2 = new JButton("여행용 마법의 영약");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // 버튼 3
       JButton button3 = new JButton("여행용 분노의 영약");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // 버튼 4
       JButton button4 = new JButton("훔친 예언자의 추출액");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
       
       panel.add(buttonPanel, BorderLayout.SOUTH);
       
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game10");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game10");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
              score++;
              updateScoreLabel();
               cardLayout.show(cardPanel, "game10");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "game10");
           }
       });
   
       // 라벨 추가
       JLabel labelText = new JLabel("다음 아이템의 이름으로 알맞은 것은?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   private static JPanel createGamePanel10() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // 이미지를 패널의 중앙에 추가
       ImageIcon imageIcon = new ImageIcon("image/Jag.png");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // 버튼을 패널의 아래에 추가
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // 버튼 1
       JButton button1 = new JButton("모렐로");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // 버튼 2
       JButton button2 = new JButton("프릭");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // 버튼 3
       JButton button3 = new JButton("재그");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // 버튼 4
       JButton button4 = new JButton("라이엇");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
       
       panel.add(buttonPanel, BorderLayout.SOUTH);
       
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "score");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "score");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
              score++;
              updateScoreLabel();
               cardLayout.show(cardPanel, "score");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // 다음 패널로 이동합니다.
               cardLayout.show(cardPanel, "score");
           }
       });
   
       // 라벨 추가
       JLabel labelText = new JLabel("다음 개발자의 이름은?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }


   private static JPanel createScorePanel() {
       // 점수를 표시할 패널
       JPanel panel = new JPanel(new BorderLayout());

       // 라벨을 사용하여 점수를 표시
       scoreLabel = new JLabel("당신의 점수는 " + score + "점 입니다.");
       scoreLabel.setHorizontalAlignment(JLabel.CENTER);
       scoreLabel.setFont(new Font(scoreLabel.getFont().getName(), Font.PLAIN, 44));
       panel.add(scoreLabel, BorderLayout.CENTER);

       // 메인 화면으로 돌아가는 버튼 생성
       JButton backButton = new JButton("초기 화면으로 돌아가기");
       backButton.setBounds(600, 500, 100, 50);
       backButton.setBorderPainted(false);
       backButton.setFocusPainted(false);
       backButton.setBackground(Color.WHITE);
       backButton.setForeground(Color.BLACK);

       // 메인 화면으로 돌아가는 ActionListener 추가
       backButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               cardLayout.show(cardPanel, "initial");
           }
       });

       // 종료 버튼 생성
       JButton exitButton = new JButton("게임 종료");
       exitButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
       exitButton.setBounds(580, 560, 100, 50);
       exitButton.setBorderPainted(false);
       exitButton.setFocusPainted(false);
       exitButton.setBackground(Color.WHITE);
       exitButton.setForeground(Color.BLACK);

       // 종료 버튼에 ActionListener 추가
       exitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
       });
       
       panel.add(exitButton, BorderLayout.SOUTH);
       panel.add(backButton, BorderLayout.SOUTH);

       return panel;
   }


    
    private static void updateScoreLabel() {
        scoreLabel.setText("당신의 점수는 " + score + "점 입니다.");
    }


}