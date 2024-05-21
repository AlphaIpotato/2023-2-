package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Main  {
	
	
	
    private JPanel cardPanel;
    private CardLayout cardLayout;

    
   private JFrame Mainframe = new JFrame(); // 초기화된 Mainframe 변수
   
   public Main() {

       cardLayout = new CardLayout();
       cardPanel = new JPanel(cardLayout);
       Mainframe.add(cardPanel);

       // 프레임 설정
       Mainframe.setTitle("게임 메뉴");
       Mainframe.setSize(600, 600);
       Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              
       Color backgroundColor = new Color(206, 242, 121);
       Mainframe.getContentPane().setBackground(backgroundColor);
       
       Mainframe.setLayout(new BorderLayout()); // BorderLayout으로 변경

       
       
       // "원하는 게임을 선택하세요!" 라벨을 상단에 추가
       JLabel label = new JLabel("원하는 게임을 선택하세요!");
       label.setHorizontalAlignment(SwingConstants.CENTER);
       Mainframe.add(label, BorderLayout.NORTH);
       
       Font labelFont = label.getFont();
       label.setFont(new Font(labelFont.getName(), Font.PLAIN, 30)); // 20픽셀로 변경

       // Create a panel for buttons and set its layout
       JPanel buttonPanel = new JPanel();
       buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
       
       Color buttonPanelColor = new Color(250, 244, 192);
       buttonPanel.setBackground(buttonPanelColor);
       
       buttonPanel.add(Box.createRigidArea(new Dimension(0, 60)));
       
       
        // 게임 카테고리 버튼 생성
        ImageIcon CardMatcingButtonImage = new ImageIcon("image/shuiba_button.png"); // 이미지 파일 경로 지정
        JButton CardMatcingButton = new JButton(CardMatcingButtonImage);       
        CardMatcingButton.addActionListener(e -> actionPerformed(1));
        CardMatcingButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        CardMatcingButton.setBorderPainted(false);
        CardMatcingButton.setFocusPainted(true);
        CardMatcingButton.setContentAreaFilled(false);
        
        
        // 구빈이꺼 
        ImageIcon LQuiz_buttonImage = new ImageIcon("image/LQuiz_Button.png"); // 이미지 파일 경로 지정
        JButton LQuiz_Button = new JButton(LQuiz_buttonImage);       
        LQuiz_Button.addActionListener(e -> actionPerformed(2));
        LQuiz_Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        LQuiz_Button.setBorderPainted(false);
        LQuiz_Button.setFocusPainted(true);
        LQuiz_Button.setContentAreaFilled(false);
        LQuiz_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // front 클래스의 객체를 생성하여 GUI 초기화
                SwingUtilities.invokeLater(() -> {
                    new LQuiz(cardPanel, cardLayout);
                });
            }
        });

        
        
        // 은호꺼
        ImageIcon Mole_Hit_GameImage = new ImageIcon("image/Mole_Button.png"); // 이미지 파일 경로 지정
        JButton Mole_Hit_Button = new JButton(Mole_Hit_GameImage);       
        Mole_Hit_Button.addActionListener(e -> actionPerformed(3));
        Mole_Hit_Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        Mole_Hit_Button.setBorderPainted(false);
        Mole_Hit_Button.setFocusPainted(true);
        Mole_Hit_Button.setContentAreaFilled(false);
        
        
        // 주연이꺼
        ImageIcon Tetris_GameImage = new ImageIcon("image/Tetris_Button.png"); // 이미지 파일 경로 지정
        JButton Tetris_Button = new JButton(Tetris_GameImage);       
        Tetris_Button.addActionListener(e -> actionPerformed(4));
        Tetris_Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        Tetris_Button.setBorderPainted(false);
        Tetris_Button.setFocusPainted(true);
        Tetris_Button.setContentAreaFilled(false);
        
        // 소연이꺼
        ImageIcon Quiz_GameImage = new ImageIcon("image/Quiz_Button.png"); // �대�몄� ���� 寃쎈� 吏���
        JButton Quiz_Button = new JButton(Quiz_GameImage);       
        Quiz_Button.addActionListener(e -> actionPerformed(5));
        Quiz_Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        Quiz_Button.setBorderPainted(false);
        Quiz_Button.setFocusPainted(true);
        Quiz_Button.setContentAreaFilled(false);

        
        
        // 버튼을 프레임에 추가
        // Add buttons to the button panel
        buttonPanel.add(CardMatcingButton);
        buttonPanel.add(LQuiz_Button);
        buttonPanel.add(Mole_Hit_Button);
        buttonPanel.add(Tetris_Button);
        buttonPanel.add(Quiz_Button);

        // Add button panel to the CENTER region
        Mainframe.add(buttonPanel, BorderLayout.CENTER);

        // 프레임 표시
        Mainframe.setVisible(true);
    }
 
    
    public void actionPerformed(int a) {
        try {
            if (a == 1) {
                executeClass("game.CardMatchingGame");
                Mainframe.setVisible(false);

            } else if (a == 2) {
                executeClass("game.LQuiz");
                Mainframe.setVisible(false);

            } else if (a == 3) {
            	executeClass("game.Mole_Hit");
                Mainframe.setVisible(false);

            } else if (a == 4) {
            	Tetris.main(new String[]{});
                Mainframe.setVisible(false);

            } else if (a == 5) {
            	executeClass("game.Quiz");
                Mainframe.setVisible(false);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    private void executeClass(String className) {
        try {
            Class<?> loadedClass = Class.forName(className);
            Object classObject = loadedClass.getDeclaredConstructor().newInstance();

            if (classObject instanceof JFrame) {
                JFrame frame = (JFrame) classObject;
                frame.setVisible(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main();
        });
    }
}