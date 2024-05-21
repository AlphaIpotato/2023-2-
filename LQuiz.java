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

    // �⺻ ������
    public LQuiz() {
        // ������ ����
    }

    // front Ŭ������ �����ڸ� �߰�
    public LQuiz(JPanel cardPanel, CardLayout cardLayout) {
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        createAndShowGUI(); // GUI�� �ʱ�ȭ�ϴ� �޼��� ȣ��
    }

    private void createAndShowGUI() {
        // JFrame ����
        JFrame frame = new JFrame("���� ����");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);

        // CardLayout�� ����� �г� ����
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        frame.add(cardPanel);

        // �ʱ� ȭ�� �г�
        JPanel initialPanel = createInitialPanel();   
        cardPanel.add(initialPanel, "initial");

        // ù��° ���� ȭ�� �г�
        JPanel gamePanel = createGamePanel();
        cardPanel.add(gamePanel, "game");
        
        // �ι�° ���� ȭ�� �г�
        JPanel gamePanel2 = createGamePanel2();
        cardPanel.add(gamePanel2, "game2");
        
        // ����° ���� ȭ�� �г�
        JPanel gamePanel3 = createGamePanel3();
        cardPanel.add(gamePanel3, "game3");
        
        // �׹�° ���� ȭ�� �г�
        JPanel gamePanel4 = createGamePanel4();
        cardPanel.add(gamePanel4, "game4");
        
        // �ټ���° ���� ȭ�� �г�
        JPanel gamePanel5 = createGamePanel5();
        cardPanel.add(gamePanel5, "game5");
        
        // ������° ���� ȭ�� �г�
        JPanel gamePanel6 = createGamePanel6();
        cardPanel.add(gamePanel6, "game6");
        
        // �ϰ���° ���� ȭ�� �г�
        JPanel gamePanel7 = createGamePanel7();
        cardPanel.add(gamePanel7, "game7");
        
        // ������° ���� ȭ�� �г�
        JPanel gamePanel8 = createGamePanel8();
        cardPanel.add(gamePanel8, "game8");

        // ��ȩ��° ���� ȭ�� �г�
        JPanel gamePanel9 = createGamePanel9();
        cardPanel.add(gamePanel9, "game9");
        
        // ����° ���� ȭ�� �г�
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
        
        JLabel startLabel = new JLabel("�� ���� ���߱� ����");
        startLabel.setBounds(450, 50, 400, 50);  // ��ġ�� ũ�� ����
        startLabel.setFont(new Font(startLabel.getFont().getName(), Font.PLAIN, 44));
        startLabel.setForeground(Color.WHITE);
        startLabel.setHorizontalAlignment(JLabel.CENTER);


        JButton startButton = new JButton("���� ����");
        startButton.setBounds(600, 500, 100, 50);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.setBackground(Color.WHITE);
        startButton.setForeground(Color.BLACK);

        JButton exitButton = new JButton("���� ����");
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.setBounds(600, 560, 100, 50);
        exitButton.setBackground(Color.WHITE);
        exitButton.setForeground(Color.BLACK);

        // ���� ���� ��ư�� ActionListener �߰�
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ���� ���� ��ư�� ������ �� ���� �гη� ��ȯ
                cardLayout.show(cardPanel, "game");
            }
        });

        // ���� ���� ��ư�� ActionListener �߰�
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ���� ��ư�� ������ �� ���� ���� �߰�
                System.exit(0); // �����ϰ� �����ϴ� �����Դϴ�.
            }
        });
        

        panel.add(startLabel);
        panel.add(startButton);
        panel.add(exitButton);

        return panel;
    }

    
    

    private static JPanel createGamePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // �̹����� �г��� �߾ӿ� �߰�
        ImageIcon imageIcon = new ImageIcon("image/DemaciaCrest.png");
        JLabel imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel, BorderLayout.CENTER);

        // ��ư�� �г��� �Ʒ��� �߰�
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // ��ư 1
        JButton button1 = new JButton("����");
        button1.setPreferredSize(new Dimension(150, 50));
        button1.setFocusPainted(false);
        button1.setBackground(Color.WHITE);
        button1.setForeground(Color.BLACK);
        buttonPanel.add(button1);

        // ��ư 2
        JButton button2 = new JButton("���Ϸ���");
        button2.setPreferredSize(new Dimension(150, 50));
        button2.setFocusPainted(false);
        button2.setBackground(Color.WHITE);
        button2.setForeground(Color.BLACK);
        buttonPanel.add(button2);

        // ��ư 3
        JButton button3 = new JButton("��þ�");
        button3.setPreferredSize(new Dimension(150, 50));
        button3.setFocusPainted(false);
        button3.setBackground(Color.WHITE);
        button3.setForeground(Color.BLACK);
        buttonPanel.add(button3);

        // ��ư 4
        JButton button4 = new JButton("Ż��");
        button4.setPreferredSize(new Dimension(150, 50));
        button4.setFocusPainted(false);
        button4.setBackground(Color.WHITE);
        button4.setForeground(Color.BLACK);
        buttonPanel.add(button4);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ���� �гη� �̵��մϴ�.
                cardLayout.show(cardPanel, "game2");
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ���� �гη� �̵��մϴ�.
                cardLayout.show(cardPanel, "game2");
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ���� �гη� �̵��մϴ�.
                cardLayout.show(cardPanel, "game2");
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ���� �гη� �̵��մϴ�.
               score++;
               updateScoreLabel();
               // ������ ��쿡�� ������ ������ŵ�ϴ�.
                cardLayout.show(cardPanel, "game2");

            }
        });

        // �� �߰�
        JLabel labelText = new JLabel("���� �Ҽӿ� �ش��ϴ� è�Ǿ��� �̸���?");
        labelText.setHorizontalAlignment(JLabel.CENTER);
        labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
        panel.add(labelText, BorderLayout.NORTH);

        return panel;
    }

   private static JPanel createGamePanel2() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // �̹����� �г��� �߾ӿ� �߰�
       ImageIcon imageIcon = new ImageIcon("image/NoxusCrest.png");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // ��ư�� �г��� �Ʒ��� �߰�
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
   
       // ��ư 1
       JButton button1 = new JButton("ī�ÿ����");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // ��ư 2
       JButton button2 = new JButton("��¥��");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // ��ư 3
       JButton button3 = new JButton("����");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // ��ư 4
       JButton button4 = new JButton("��");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
   
       panel.add(buttonPanel, BorderLayout.SOUTH);
   
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game3");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
              score++;
              updateScoreLabel();
               cardLayout.show(cardPanel, "game3");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game3");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ������ ��쿡�� ������ ������ŵ�ϴ�.
               cardLayout.show(cardPanel, "game3");
           }
       });
       
       JLabel labelText = new JLabel("���� �Ҽӿ� �ش��ϴ� è�Ǿ��� �̸���?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   private static JPanel createGamePanel3() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // �̹����� �г��� �߾ӿ� �߰�
       ImageIcon imageIcon = new ImageIcon("image/Piltover.png");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // ��ư�� �г��� �Ʒ��� �߰�
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // ��ư 1
       JButton button1 = new JButton("����ũ��ũ");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // ��ư 2
       JButton button2 = new JButton("���̸ӵ���");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // ��ư 3
       JButton button3 = new JButton("�����");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // ��ư 4
       JButton button4 = new JButton("������");
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
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game4");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game4");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game4");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game4");
           }
       });
       
        JLabel labelText = new JLabel("���� �Ҽӿ� �ش��ϴ� è�Ǿ��� �̸���?");
        labelText.setHorizontalAlignment(JLabel.CENTER);
        labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
        panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   
   private static JPanel createGamePanel4() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // �̹����� �г��� �߾ӿ� �߰�
       ImageIcon imageIcon = new ImageIcon("image/Ionia.png");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // ��ư�� �г��� �Ʒ��� �߰�
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // ��ư 1
       JButton button1 = new JButton("�ɳ�");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // ��ư 2
       JButton button2 = new JButton("�ŵ��");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // ��ư 3
       JButton button3 = new JButton("��ī��");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // ��ư 4
       JButton button4 = new JButton("������");
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
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game5");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game5");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game5");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game5");
           }
       });
   
       // �� �߰�
       JLabel labelText = new JLabel("���� �Ҽӿ� �ش����� �ʴ� è�Ǿ��� �̸���?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   private static JPanel createGamePanel5() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // �̹����� �г��� �߾ӿ� �߰�
       ImageIcon imageIcon = new ImageIcon("image/Ixtal.jpeg");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // ��ư�� �г��� �Ʒ��� �߰�
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // ��ư 1
       JButton button1 = new JButton("�ϴ޸�");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // ��ư 2
       JButton button2 = new JButton("������Ʈ");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // ��ư 3
       JButton button3 = new JButton("����");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // ��ư 4
       JButton button4 = new JButton("Ƽ��");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
       
       panel.add(buttonPanel, BorderLayout.SOUTH);
       
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game6");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game6");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game6");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
              score++;
              updateScoreLabel();
               cardLayout.show(cardPanel, "game6");
           }
       });
   
       // �� �߰�
       JLabel labelText = new JLabel("���� �Ҽӿ� �ش����� �ʴ� è�Ǿ��� �̸���?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   private static JPanel createGamePanel6() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // �̹����� �г��� �߾ӿ� �߰�
       ImageIcon imageIcon = new ImageIcon("image/Shurima.jpeg");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // ��ư�� �г��� �Ʒ��� �߰�
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // ��ư 1
       JButton button1 = new JButton("���ӽ�");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // ��ư 2
       JButton button2 = new JButton("��ī��");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // ��ư 3
       JButton button3 = new JButton("�ƹ���");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // ��ư 4
       JButton button4 = new JButton("������");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
       
       panel.add(buttonPanel, BorderLayout.SOUTH);
       
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game7");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game7");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game7");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
              score++;
              updateScoreLabel();
               cardLayout.show(cardPanel, "game7");
           }
       });
   
       // �� �߰�
       JLabel labelText = new JLabel("���� �Ҽӿ� �ش����� �ʴ� è�Ǿ��� �̸���?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   private static JPanel createGamePanel7() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // �̹����� �г��� �߾ӿ� �߰�
       ImageIcon imageIcon = new ImageIcon("image/BandleCity.jpeg");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // ��ư�� �г��� �Ʒ��� �߰�
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // ��ư 1
       JButton button1 = new JButton("�ǻ�");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // ��ư 2
       JButton button2 = new JButton("����");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // ��ư 3
       JButton button3 = new JButton("Ŭ����");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // ��ư 4
       JButton button4 = new JButton("�ڸ�Ű");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
       
       panel.add(buttonPanel, BorderLayout.SOUTH);
       
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game8");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game8");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game8");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
              score++;
              updateScoreLabel();
               cardLayout.show(cardPanel, "game8");
   
           }
       });
   
   
       // �� �߰�
       JLabel labelText = new JLabel("���� �Ҽӿ� �ش��ϴ� è�Ǿ��� �̸���?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   private static JPanel createGamePanel8() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // �̹����� �г��� �߾ӿ� �߰�
       ImageIcon imageIcon = new ImageIcon("image/Quiz7.png");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // ��ư�� �г��� �Ʒ��� �߰�
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // ��ư 1
       JButton button1 = new JButton("����� ��ö�� ����");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // ��ư 2
       JButton button2 = new JButton("����� ������ ����");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // ��ư 3
       JButton button3 = new JButton("����� �г��� ����");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // ��ư 4
       JButton button4 = new JButton("��ģ �������� �����");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
       
       panel.add(buttonPanel, BorderLayout.SOUTH);
       
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game9");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game9");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game9");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
              score++;
              updateScoreLabel();
               cardLayout.show(cardPanel, "game9");
           }
       });
   
       // �� �߰�
       JLabel labelText = new JLabel("���� �������� �̸����� �˸��� ����?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   private static JPanel createGamePanel9() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // �̹����� �г��� �߾ӿ� �߰�
       ImageIcon imageIcon = new ImageIcon("image/Quiz9.png");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // ��ư�� �г��� �Ʒ��� �߰�
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // ��ư 1
       JButton button1 = new JButton("����� ��ö�� ����");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // ��ư 2
       JButton button2 = new JButton("����� ������ ����");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // ��ư 3
       JButton button3 = new JButton("����� �г��� ����");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // ��ư 4
       JButton button4 = new JButton("��ģ �������� �����");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
       
       panel.add(buttonPanel, BorderLayout.SOUTH);
       
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game10");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game10");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
              score++;
              updateScoreLabel();
               cardLayout.show(cardPanel, "game10");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "game10");
           }
       });
   
       // �� �߰�
       JLabel labelText = new JLabel("���� �������� �̸����� �˸��� ����?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }
   
   private static JPanel createGamePanel10() {
       JPanel panel = new JPanel(new BorderLayout());
   
       // �̹����� �г��� �߾ӿ� �߰�
       ImageIcon imageIcon = new ImageIcon("image/Jag.png");
       JLabel imageLabel = new JLabel(imageIcon);
       panel.add(imageLabel, BorderLayout.CENTER);
   
       // ��ư�� �г��� �Ʒ��� �߰�
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       // ��ư 1
       JButton button1 = new JButton("�𷼷�");
       button1.setPreferredSize(new Dimension(150, 50));
       button1.setFocusPainted(false);
       button1.setBackground(Color.WHITE);
       button1.setForeground(Color.BLACK);
       buttonPanel.add(button1);
   
       // ��ư 2
       JButton button2 = new JButton("����");
       button2.setPreferredSize(new Dimension(150, 50));
       button2.setFocusPainted(false);
       button2.setBackground(Color.WHITE);
       button2.setForeground(Color.BLACK);
       buttonPanel.add(button2);
   
       // ��ư 3
       JButton button3 = new JButton("���");
       button3.setPreferredSize(new Dimension(150, 50));
       button3.setFocusPainted(false);
       button3.setBackground(Color.WHITE);
       button3.setForeground(Color.BLACK);
       buttonPanel.add(button3);
   
       // ��ư 4
       JButton button4 = new JButton("���̾�");
       button4.setPreferredSize(new Dimension(150, 50));
       button4.setFocusPainted(false);
       button4.setBackground(Color.WHITE);
       button4.setForeground(Color.BLACK);
       buttonPanel.add(button4);
       
       panel.add(buttonPanel, BorderLayout.SOUTH);
       
       button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "score");
           }
       });
   
       button2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "score");
           }
       });
   
       button3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
              score++;
              updateScoreLabel();
               cardLayout.show(cardPanel, "score");
           }
       });
   
       button4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ���� �гη� �̵��մϴ�.
               cardLayout.show(cardPanel, "score");
           }
       });
   
       // �� �߰�
       JLabel labelText = new JLabel("���� �������� �̸���?");
       labelText.setHorizontalAlignment(JLabel.CENTER);
       labelText.setFont(new Font(labelText.getFont().getName(), Font.PLAIN, 44));
       panel.add(labelText, BorderLayout.NORTH);
   
       return panel;
   }


   private static JPanel createScorePanel() {
       // ������ ǥ���� �г�
       JPanel panel = new JPanel(new BorderLayout());

       // ���� ����Ͽ� ������ ǥ��
       scoreLabel = new JLabel("����� ������ " + score + "�� �Դϴ�.");
       scoreLabel.setHorizontalAlignment(JLabel.CENTER);
       scoreLabel.setFont(new Font(scoreLabel.getFont().getName(), Font.PLAIN, 44));
       panel.add(scoreLabel, BorderLayout.CENTER);

       // ���� ȭ������ ���ư��� ��ư ����
       JButton backButton = new JButton("�ʱ� ȭ������ ���ư���");
       backButton.setBounds(600, 500, 100, 50);
       backButton.setBorderPainted(false);
       backButton.setFocusPainted(false);
       backButton.setBackground(Color.WHITE);
       backButton.setForeground(Color.BLACK);

       // ���� ȭ������ ���ư��� ActionListener �߰�
       backButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               cardLayout.show(cardPanel, "initial");
           }
       });

       // ���� ��ư ����
       JButton exitButton = new JButton("���� ����");
       exitButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
       exitButton.setBounds(580, 560, 100, 50);
       exitButton.setBorderPainted(false);
       exitButton.setFocusPainted(false);
       exitButton.setBackground(Color.WHITE);
       exitButton.setForeground(Color.BLACK);

       // ���� ��ư�� ActionListener �߰�
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
        scoreLabel.setText("����� ������ " + score + "�� �Դϴ�.");
    }


}