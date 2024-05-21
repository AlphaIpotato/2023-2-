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

    private boolean gameInProgress = false; // 게임 진행 중 여부를 나타내는 플래그

    public CardMatchingGame() {
        frame = new JFrame("카드 뒤집기 게임");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 1000);

        // 왼쪽 패널 (메뉴)
        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        Color MbackgroundColor = new Color(255, 221, 115);
        menuPanel.setBackground(MbackgroundColor);
        
        
        // 오른쪽 패널 (게임)
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridBagLayout()); // GridBagLayout으로 변경
        Color GbackgroundColor = new Color(255, 255, 176);
        gamePanel.setBackground(GbackgroundColor);
        
        // 게임 제목
        JLabel title = new JLabel("카드 뒤집기");
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(title);

        // 게임 시작 버튼
        ImageIcon startButtonImage = new ImageIcon("image/start.png"); // 이미지 파일 경로 지정
        JButton startButton = new JButton(startButtonImage);
        configureMenuButton(startButton, e -> showDifficultyMenu());
        menuPanel.add(startButton);

        // 게임 종료 버튼
        ImageIcon exitButtonImage = new ImageIcon("image/quit.png"); // 이미지 파일 경로 지정
        JButton exitButton = new JButton(exitButtonImage);
        configureMenuButton(exitButton, e -> System.exit(0));
        menuPanel.add(exitButton);



        // JSplitPane으로 메뉴 패널과 게임 패널을 분할된 상태로 추가
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menuPanel, gamePanel);
        splitPane.setDividerLocation(0.2);
        splitPane.setEnabled(false);

        
        frame.add(splitPane);
        frame.setVisible(true);
    }

    public void showMainMenu() {
        // 기존 메뉴 패널의 컴포넌트를 모두 제거
        menuPanel.removeAll();
        menuPanel.revalidate();
        menuPanel.repaint();

        // 화면 상단에 게임 제목 표시
        JLabel title = new JLabel("카드 뒤집기");
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(title);

        // 게임 시작 버튼
        ImageIcon startButtonImage = new ImageIcon("image/start.png");
        JButton startButton = new JButton(startButtonImage);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.addActionListener(e -> showDifficultyMenu());
        menuPanel.add(startButton);

        // 게임 종료 버튼
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
        menuPanel.removeAll(); // 메뉴 패널 내용을 지우고 난이도 메뉴를 표시

        // 화면 상단에 게임 제목 표시
        JLabel title = new JLabel("카드 뒤집기");
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(title);

        // 난이도 선택 버튼에 이미지 적용
        ImageIcon beginnerButtonImage = new ImageIcon("image/초보.png");
        JButton beginnerButton = new JButton(beginnerButtonImage);
        beginnerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        beginnerButton.setBorderPainted(false);
        beginnerButton.setFocusPainted(false);
        beginnerButton.setContentAreaFilled(false);
        beginnerButton.addActionListener(e -> startDifficultyCountdown(5, 6, 0, 15));
        
        String beginnertooltip = "<html><img src='file:image/초보tooltip.png' width='300' height='300'>" +
                "<br>초보 난이도 (5 X 6) </html>";
        beginnerButton.setToolTipText(beginnertooltip);
        
        
        ImageIcon intermediateButtonImage = new ImageIcon("image/중수.png");
        JButton intermediateButton = new JButton(intermediateButtonImage);
        intermediateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        intermediateButton.setBorderPainted(false);
        intermediateButton.setFocusPainted(false);
        intermediateButton.setContentAreaFilled(false);
        intermediateButton.addActionListener(e -> startDifficultyCountdown(6, 8, 0, 24));

        String intermediatetooltip = "<html><img src='file:image/중수tooltip.png' width='300' height='300'>" +
                "<br>중수 난이도 (6 X 8) </html>";
        intermediateButton.setToolTipText(intermediatetooltip);
        
        
        ImageIcon expertButtonImage = new ImageIcon("image/고수.png");
        JButton expertButton = new JButton(expertButtonImage);
        expertButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        expertButton.setBorderPainted(false);
        expertButton.setFocusPainted(false);
        expertButton.setContentAreaFilled(false);
        expertButton.addActionListener(e -> startDifficultyCountdown(7, 10, 300, 35));
        
        String experttooltip = "<html><img src='file:image/고수tooltip.png' width='300' height='300'>" +
                "<br>고수 난이도 (7 X 10) + 제한시간 5분 </html>";
        expertButton.setToolTipText(experttooltip);

        
        ImageIcon masterButtonImage = new ImageIcon("image/쌉고수.png");
        JButton masterButton = new JButton(masterButtonImage);
        masterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        masterButton.setBorderPainted(false);
        masterButton.setFocusPainted(false);
        masterButton.setContentAreaFilled(false);
        masterButton.addActionListener(e -> startDifficultyCountdown(8, 10, 180, 40));
        
        String mastertooltip = "<html><img src='file:image/쌉고수tooltip.png' width='300' height='300'>" +
                "<br>고수 난이도 (8 X 10) + 제한시간 3분 </html>";
        masterButton.setToolTipText(mastertooltip);
        

        // 버튼을 세로로 나열하고 가운데 정렬
        Box buttonBox = Box.createVerticalBox();
        buttonBox.add(Box.createVerticalGlue());
        buttonBox.add(beginnerButton);
        buttonBox.add(intermediateButton);
        buttonBox.add(expertButton);
        buttonBox.add(masterButton);
        buttonBox.add(Box.createVerticalGlue());

        menuPanel.add(buttonBox);
        menuPanel.revalidate();
        frame.revalidate(); // 패널을 업데이트하고 다시 그리기
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
    	
    	
    	gamePanel.removeAll(); // 기존 컴포넌트 지우기
    	gamePanel.revalidate();
        gamePanel.repaint();
        
        
    	startGame(rows, cols, timeLimit, totalPairs);
    	flipAllCardsToFront();
    	
    	
        // 카운트 다운을 표시하는 레이블 추가
        JLabel countdownLabel = new JLabel("게임 시작까지 " + countdownSeconds + "초...");
        countdownLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        countdownLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        gamePanel.add(countdownLabel);

        gameInProgress = true; // 게임이 진행 중임을 나타내는 플래그 설정

        gamePanel.revalidate(); // 패널을 업데이트하고 다시 그리기

        // 3초 후에 게임 시작
        Timer countdownTimer = new Timer();
        countdownTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                countdownLabel.setText("게임 시작까지 " + countdownSeconds + "초...");
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

        gamePanel.setLayout(new GridBagLayout()); // GridBagLayout으로 다시 설정

        cardsRemaining = rows * cols;
        cardPairs = totalPairs;
        playTime = timeLimit;

        List<Card> cardList = createCardPairs(totalPairs);
        Collections.shuffle(cardList);

        GridBagConstraints constraints = new GridBagConstraints();

        for (Card card : cardList) {
            JButton cardButton = createCardButton(card);

            // 각 카드의 위치 및 간격을 설정
            constraints.gridx = cardList.indexOf(card) % cols;
            constraints.gridy = cardList.indexOf(card) / cols;
            constraints.insets = new Insets(5, 5, 5, 5); // 원하는 간격으로 조절

            gamePanel.add(cardButton, constraints);
        }

        frame.revalidate(); // 패널을 업데이트하고 다시 그리기
    }


    private void startGameTimer() {
        gameTimer = new Timer();
        JLabel timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        timeLabel.setBounds(0, 0, 100, 20);
        
        gamePanel.add(timeLabel);
        gamePanel.revalidate();
        
        if (playTime == 0) {
            // 누적 플레이타임 보이기
            gameTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    playTime++;
                    // 타이머 디스플레이 업데이트
                    timeLabel.setText(String.format("%02d:%02d:%02d", playTime / 3600, (playTime % 3600) / 60, playTime % 60));
                
                }
            }, 1000, 1000);
        } else {
            // TimeLimit으로 받은 시간만큼 타이머 흐르기
            gameTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    playTime--;
                    if (playTime < 1) {
                    	GameOver();
                        gameTimer.cancel();
                  
                    }
                    // 타이머 디스플레이 업데이트
                    timeLabel.setText(String.format("%02d:%02d:%02d", playTime / 3600, (playTime % 3600) / 60, playTime % 60));
                }
            }, 1000, 1000);
        }
    }
    
    private void GameOver() {
    	gamePanel.removeAll();
    	gamePanel.revalidate();
    	gamePanel.repaint();
    	
        JLabel Gameover = new JLabel("당신은 ☆감자☆입니다! 실패했어요!");
        Gameover.setFont(new Font("SansSerif", Font.BOLD, 70));
        Gameover.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        gamePanel.add(Gameover);
    	
    }
    
    private void GameClear() {
        gamePanel.removeAll();
        gamePanel.revalidate();
        gamePanel.repaint();

        JLabel GameClear = new JLabel("와우! 모든 카드를 맞췄어요!");
        GameClear.setFont(new Font("SansSerif", Font.BOLD, 70));
        GameClear.setAlignmentX(Component.CENTER_ALIGNMENT);

        gamePanel.add(GameClear);
    }

    private void showGameMenu() {
    	menuPanel.removeAll();
    	menuPanel.revalidate();
    	menuPanel.repaint();
    	
        JLabel title = new JLabel("카드 뒤집기");
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(title);

        // "다시하기" 버튼에 이미지 적용
        ImageIcon restartButtonImage = new ImageIcon("image/restart.png");
        JButton restartButton = new JButton(restartButtonImage);
        configureMenuButton(restartButton, e -> { gameTimer.cancel(); showDifficultyMenu();});

        // "처음으로" 버튼에 이미지 적용
        ImageIcon HomeButtonImage = new ImageIcon("image/home.png");
        JButton HomeButton = new JButton(HomeButtonImage);
        configureMenuButton(HomeButton, e -> Home());

        // "종료" 버튼에 이미지 적용
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
        frame.revalidate(); // 패널을 업데이트하고 다시 그리기
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
    
    

 // 캐시를 생성합니다.
    private HashMap<Integer, ImageIcon> cardImageCache = new HashMap<>();

    // 카드 쌍을 생성합니다.
    private List<Card> createCardPairs(int totalPairs) {
        List<Card> cardList = new ArrayList<>();
        for (int i = 0; i < totalPairs; i++) {
            Card card1 = new Card(i);
            Card card2 = new Card(i);

            // 캐시에서 이미지가 이미 로드되었는지 확인합니다.
            ImageIcon cardImage = cardImageCache.get(i);
            if (cardImage == null) {
                // 디스크에서 이미지를 로드합니다.
                cardImage = new ImageIcon("path/to/image/file.png");

                // 이미지를 캐시에 추가합니다.
                cardImageCache.put(i, cardImage);
            }

            // 카드의 버튼에 이미지를 설정합니다.
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