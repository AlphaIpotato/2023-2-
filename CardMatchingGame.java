package game;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionListener;
import java.util.HashMap;



public class CardMatchingGame {
    private JFrame frame;
    private JPanel menuPanel;
    private JPanel gamePanel;
    private JSplitPane splitPane;
    private Timer gameTimer;
    private int playTime;
    private int cardsRemaining;
    private int cardPairs;
    private Card firstSelectedCard;
    private Card secondSelectedCard;

    private int countdownSeconds = 3;

    private boolean gameInProgress = false; // ���� ���� �� ���θ� ��Ÿ���� �÷���

    public CardMatchingGame() {
        frame = new JFrame("ī�� ������ ����");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 1000);

        // ���� �г� (�޴�)
        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        Color MbackgroundColor = new Color(255, 221, 115);
        menuPanel.setBackground(MbackgroundColor);
        
        
        // ������ �г� (����)
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridBagLayout()); // GridBagLayout���� ����
        Color GbackgroundColor = new Color(255, 255, 176);
        gamePanel.setBackground(GbackgroundColor);
        
        // ���� ����
        JLabel title = new JLabel("ī�� ������");
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(title);

        // ���� ���� ��ư
        ImageIcon startButtonImage = new ImageIcon("image/start.png"); // �̹��� ���� ��� ����
        JButton startButton = new JButton(startButtonImage);
        configureMenuButton(startButton, e -> showDifficultyMenu());
        menuPanel.add(startButton);

        // ���� ���� ��ư
        ImageIcon exitButtonImage = new ImageIcon("image/quit.png"); // �̹��� ���� ��� ����
        JButton exitButton = new JButton(exitButtonImage);
        configureMenuButton(exitButton, e -> System.exit(0));
        menuPanel.add(exitButton);



        // JSplitPane���� �޴� �гΰ� ���� �г��� ���ҵ� ���·� �߰�
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menuPanel, gamePanel);
        splitPane.setDividerLocation(0.2);
        splitPane.setEnabled(false);

        
        frame.add(splitPane);
        frame.setVisible(true);
    }

    public void showMainMenu() {
        // ���� �޴� �г��� ������Ʈ�� ��� ����
        menuPanel.removeAll();
        menuPanel.revalidate();
        menuPanel.repaint();

        // ȭ�� ��ܿ� ���� ���� ǥ��
        JLabel title = new JLabel("ī�� ������");
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(title);

        // ���� ���� ��ư
        ImageIcon startButtonImage = new ImageIcon("image/start.png");
        JButton startButton = new JButton(startButtonImage);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.addActionListener(e -> showDifficultyMenu());
        menuPanel.add(startButton);

        // ���� ���� ��ư
        ImageIcon exitButtonImage = new ImageIcon("image/quit.png");
        JButton exitButton = new JButton(exitButtonImage);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.addActionListener(e -> System.exit(0));
        menuPanel.add(exitButton);

        menuPanel.revalidate();
    }


    public void showDifficultyMenu() {
        menuPanel.removeAll(); // �޴� �г� ������ ����� ���̵� �޴��� ǥ��

        // ȭ�� ��ܿ� ���� ���� ǥ��
        JLabel title = new JLabel("ī�� ������");
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(title);

        // ���̵� ���� ��ư�� �̹��� ����
        ImageIcon beginnerButtonImage = new ImageIcon("image/�ʺ�.png");
        JButton beginnerButton = new JButton(beginnerButtonImage);
        beginnerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        beginnerButton.setBorderPainted(false);
        beginnerButton.setFocusPainted(false);
        beginnerButton.setContentAreaFilled(false);
        beginnerButton.addActionListener(e -> startDifficultyCountdown(5, 6, 0, 15));
        
        String beginnertooltip = "<html><img src='file:image/�ʺ�tooltip.png' width='300' height='300'>" +
                "<br>�ʺ� ���̵� (5 X 6) </html>";
        beginnerButton.setToolTipText(beginnertooltip);
        
        
        ImageIcon intermediateButtonImage = new ImageIcon("image/�߼�.png");
        JButton intermediateButton = new JButton(intermediateButtonImage);
        intermediateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        intermediateButton.setBorderPainted(false);
        intermediateButton.setFocusPainted(false);
        intermediateButton.setContentAreaFilled(false);
        intermediateButton.addActionListener(e -> startDifficultyCountdown(6, 8, 0, 24));

        String intermediatetooltip = "<html><img src='file:image/�߼�tooltip.png' width='300' height='300'>" +
                "<br>�߼� ���̵� (6 X 8) </html>";
        intermediateButton.setToolTipText(intermediatetooltip);
        
        
        ImageIcon expertButtonImage = new ImageIcon("image/���.png");
        JButton expertButton = new JButton(expertButtonImage);
        expertButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        expertButton.setBorderPainted(false);
        expertButton.setFocusPainted(false);
        expertButton.setContentAreaFilled(false);
        expertButton.addActionListener(e -> startDifficultyCountdown(7, 10, 300, 35));
        
        String experttooltip = "<html><img src='file:image/���tooltip.png' width='300' height='300'>" +
                "<br>��� ���̵� (7 X 10) + ���ѽð� 5�� </html>";
        expertButton.setToolTipText(experttooltip);

        
        ImageIcon masterButtonImage = new ImageIcon("image/�԰��.png");
        JButton masterButton = new JButton(masterButtonImage);
        masterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        masterButton.setBorderPainted(false);
        masterButton.setFocusPainted(false);
        masterButton.setContentAreaFilled(false);
        masterButton.addActionListener(e -> startDifficultyCountdown(8, 10, 180, 40));
        
        String mastertooltip = "<html><img src='file:image/�԰��tooltip.png' width='300' height='300'>" +
                "<br>��� ���̵� (8 X 10) + ���ѽð� 3�� </html>";
        masterButton.setToolTipText(mastertooltip);
        

        // ��ư�� ���η� �����ϰ� ��� ����
        Box buttonBox = Box.createVerticalBox();
        buttonBox.add(Box.createVerticalGlue());
        buttonBox.add(beginnerButton);
        buttonBox.add(intermediateButton);
        buttonBox.add(expertButton);
        buttonBox.add(masterButton);
        buttonBox.add(Box.createVerticalGlue());

        menuPanel.add(buttonBox);
        menuPanel.revalidate();
        frame.revalidate(); // �г��� ������Ʈ�ϰ� �ٽ� �׸���
    }


    private void configureMenuButton(JButton button, ActionListener actionListener) {
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.addActionListener(actionListener);
    }

    private void startDifficultyCountdown(int rows, int cols, int timeLimit, int totalPairs) {
    	countdownSeconds = 3;
    	
    	
    	gamePanel.removeAll(); // ���� ������Ʈ �����
    	gamePanel.revalidate();
        gamePanel.repaint();
        
        
    	startGame(rows, cols, timeLimit, totalPairs);
    	flipAllCardsToFront();
    	
    	
        // ī��Ʈ �ٿ��� ǥ���ϴ� ���̺� �߰�
        JLabel countdownLabel = new JLabel("���� ���۱��� " + countdownSeconds + "��...");
        countdownLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        countdownLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        gamePanel.add(countdownLabel);

        gameInProgress = true; // ������ ���� ������ ��Ÿ���� �÷��� ����

        gamePanel.revalidate(); // �г��� ������Ʈ�ϰ� �ٽ� �׸���

        // 3�� �Ŀ� ���� ����
        Timer countdownTimer = new Timer();
        countdownTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                countdownLabel.setText("���� ���۱��� " + countdownSeconds + "��...");
                countdownSeconds--;

                if (countdownSeconds < 0) {
                    countdownTimer.cancel();                   
                    flipAllCardsToBack();
                    showGameMenu();
                    startGameTimer();
                    gamePanel.remove(countdownLabel);
                    gamePanel.revalidate();
                    gamePanel.repaint();
                    
                }
            }
        }, 0, 1000);
    }

    private void startGame(int rows, int cols, int timeLimit, int totalPairs) {

        gamePanel.removeAll();
        gamePanel.revalidate();
        gamePanel.repaint();

        gamePanel.setLayout(new GridBagLayout()); // GridBagLayout���� �ٽ� ����

        cardsRemaining = rows * cols;
        cardPairs = totalPairs;
        playTime = timeLimit;

        List<Card> cardList = createCardPairs(totalPairs);
        Collections.shuffle(cardList);

        GridBagConstraints constraints = new GridBagConstraints();

        for (Card card : cardList) {
            JButton cardButton = createCardButton(card);

            // �� ī���� ��ġ �� ������ ����
            constraints.gridx = cardList.indexOf(card) % cols;
            constraints.gridy = cardList.indexOf(card) / cols;
            constraints.insets = new Insets(5, 5, 5, 5); // ���ϴ� �������� ����

            gamePanel.add(cardButton, constraints);
        }

        frame.revalidate(); // �г��� ������Ʈ�ϰ� �ٽ� �׸���
    }


    private void startGameTimer() {
        gameTimer = new Timer();
        JLabel timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        timeLabel.setBounds(0, 0, 100, 20);
        
        gamePanel.add(timeLabel);
        gamePanel.revalidate();
        
        if (playTime == 0) {
            // ���� �÷���Ÿ�� ���̱�
            gameTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    playTime++;
                    // Ÿ�̸� ���÷��� ������Ʈ
                    timeLabel.setText(String.format("%02d:%02d:%02d", playTime / 3600, (playTime % 3600) / 60, playTime % 60));
                
                }
            }, 1000, 1000);
        } else {
            // TimeLimit���� ���� �ð���ŭ Ÿ�̸� �帣��
            gameTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    playTime--;
                    if (playTime < 1) {
                    	GameOver();
                        gameTimer.cancel();
                  
                    }
                    // Ÿ�̸� ���÷��� ������Ʈ
                    timeLabel.setText(String.format("%02d:%02d:%02d", playTime / 3600, (playTime % 3600) / 60, playTime % 60));
                }
            }, 1000, 1000);
        }
    }
    
    private void GameOver() {
    	gamePanel.removeAll();
    	gamePanel.revalidate();
    	gamePanel.repaint();
    	
        JLabel Gameover = new JLabel("����� �ٰ��ڡ��Դϴ�! �����߾��!");
        Gameover.setFont(new Font("SansSerif", Font.BOLD, 70));
        Gameover.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        gamePanel.add(Gameover);
    	
    }
    
    private void GameClear() {
        gamePanel.removeAll();
        gamePanel.revalidate();
        gamePanel.repaint();

        JLabel GameClear = new JLabel("�Ϳ�! ��� ī�带 ������!");
        GameClear.setFont(new Font("SansSerif", Font.BOLD, 70));
        GameClear.setAlignmentX(Component.CENTER_ALIGNMENT);

        gamePanel.add(GameClear);
    }

    private void showGameMenu() {
    	menuPanel.removeAll();
    	menuPanel.revalidate();
    	menuPanel.repaint();
    	
        JLabel title = new JLabel("ī�� ������");
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(title);

        // "�ٽ��ϱ�" ��ư�� �̹��� ����
        ImageIcon restartButtonImage = new ImageIcon("image/restart.png");
        JButton restartButton = new JButton(restartButtonImage);
        configureMenuButton(restartButton, e -> { gameTimer.cancel(); showDifficultyMenu();});

        // "ó������" ��ư�� �̹��� ����
        ImageIcon HomeButtonImage = new ImageIcon("image/home.png");
        JButton HomeButton = new JButton(HomeButtonImage);
        configureMenuButton(HomeButton, e -> Home());

        // "����" ��ư�� �̹��� ����
        ImageIcon exitButtonImage = new ImageIcon("image/quit.png");
        JButton exitButton = new JButton(exitButtonImage);
        configureMenuButton(exitButton, e -> System.exit(0));

        Box buttonBox = Box.createVerticalBox();
        buttonBox.add(Box.createVerticalGlue());
        buttonBox.add(restartButton);
        buttonBox.add(HomeButton);
        buttonBox.add(exitButton);
        buttonBox.add(Box.createVerticalGlue());

        menuPanel.add(buttonBox);
        menuPanel.revalidate();
        frame.revalidate(); // �г��� ������Ʈ�ϰ� �ٽ� �׸���
    }
    
    private void Home () {
    	gamePanel.removeAll();
    	gamePanel.revalidate();
    	gamePanel.repaint();
    	menuPanel.removeAll();
    	menuPanel.revalidate();
    	menuPanel.repaint();
    	
    	showMainMenu();    	
    }
    
    

 // ĳ�ø� �����մϴ�.
    private HashMap<Integer, ImageIcon> cardImageCache = new HashMap<>();

    // ī�� ���� �����մϴ�.
    private List<Card> createCardPairs(int totalPairs) {
        List<Card> cardList = new ArrayList<>();
        for (int i = 0; i < totalPairs; i++) {
            Card card1 = new Card(i);
            Card card2 = new Card(i);

            // ĳ�ÿ��� �̹����� �̹� �ε�Ǿ����� Ȯ���մϴ�.
            ImageIcon cardImage = cardImageCache.get(i);
            if (cardImage == null) {
                // ��ũ���� �̹����� �ε��մϴ�.
                cardImage = new ImageIcon("path/to/image/file.png");

                // �̹����� ĳ�ÿ� �߰��մϴ�.
                cardImageCache.put(i, cardImage);
            }

            // ī���� ��ư�� �̹����� �����մϴ�.
            card1.getButton().setIcon(cardImage);
            card2.getButton().setIcon(cardImage);

            cardList.add(card1);
            cardList.add(card2);
        }
        return cardList;
    }
    
  class Card {
        private int value;
        private boolean isFaceUp;
        private JButton button;

        public Card(int value) {
            this.value = value;
            this.isFaceUp = false;
            this.button = new JButton();
            this.button.setPreferredSize(new Dimension(200, 300));
            this.button.setMargin(new Insets(0, 0, 0, 0));
            this.button.setBorderPainted(false);
            this.button.setFocusPainted(false);
            this.button.setContentAreaFilled(false);
        }

        public JButton getButton() {
            return button;
        }

        public int getValue() {
            return value;
        }
    }

    private JButton createCardButton(Card card) {
        JButton cardButton = card.getButton();
        cardButton.addActionListener(e -> handleCardClick(cardButton, card));
        cardButton.putClientProperty("card", card);
        return cardButton;
    }

    private boolean isHandlingClick;

    private void handleCardClick(JButton cardButton, Card card) {
        if (isHandlingClick || (firstSelectedCard != null && secondSelectedCard != null) || card.isFaceUp) {
            return;
        }

        cardButton.setIcon(new ImageIcon("image/card_" + card.getValue() + ".png"));
        card.isFaceUp = true;

        if (firstSelectedCard == null) {
            firstSelectedCard = card;
        } else if (secondSelectedCard == null) {
            secondSelectedCard = card;
            if (firstSelectedCard.getValue() == secondSelectedCard.getValue()) {
                firstSelectedCard = null;
                secondSelectedCard = null;
                cardsRemaining -= 2;
                if (cardsRemaining == 0) {
                    GameClear();
                    gameTimer.cancel();
                }
            } else {
                isHandlingClick = true;

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        cardButton.setIcon(new ImageIcon("image/card_back.png"));
                        card.isFaceUp = false;
                        firstSelectedCard.getButton().setIcon(new ImageIcon("image/card_back.png"));
                        firstSelectedCard.isFaceUp = false;
                        firstSelectedCard = null;
                        secondSelectedCard = null;
                        isHandlingClick = false;
                        timer.cancel();
                    }
                }, 1000);
            }
        }
    }

    private void flipAllCardsToBack() {
        for (Component component : gamePanel.getComponents()) {
            if (component instanceof JButton) {
                JButton cardButton = (JButton) component;
                Card card = (Card) cardButton.getClientProperty("card");
                cardButton.setIcon(new ImageIcon("image/card_back.png"));
                card.isFaceUp = false;
            }
        }
    }
    private void flipAllCardsToFront() {
        for (Component component : gamePanel.getComponents()) {
            if (component instanceof JButton) {
                JButton cardButton = (JButton) component;
                Card card = (Card) cardButton.getClientProperty("card");
                cardButton.setIcon(new ImageIcon("image/card_" + card.getValue() + ".png"));
                card.isFaceUp = true;
            }
        }
    }

  

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CardMatchingGame();
        });
    }
}