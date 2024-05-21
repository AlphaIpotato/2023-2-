package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




class GameCategory1 extends JFrame {
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton;

    private String[] easyQuizData = {
        "ㅇㅂㅌ", "아바타",
        "ㅌㅇㅌㄴ", "타이타닉",
        "ㅇㅌㅅㅌㄹ", "인터스텔라",
        "ㅇㅂㅇㅌㅇ", "어바웃타임",
       "ㅅㅌㅇㅈ", "스타워즈", 
       "ㄱㅎㅈㅇ", "극한직업",
       "ㅋㅌ ㅇㅁㄹㅋ", "캡틴 아메리카",
       "ㅇㄹㅁㅌ", "엘리멘탈",
       "ㅌㅇㅅㅌㄹ", "토이스토리",
       "ㅇㄹㄷ", "알라딘",
    };

    private String[] hardQuizData = {
        "ㅊㄹㅇ ㅊㅋㄹㄱㅈ", "찰리와 초콜릿공장",
        "ㄱㄴ ㅂ ㄲㅇ ㅇㄹㅇ ㅇㄹㄴ ㅇㅈ ㅁㄹㄷ", "그날 본 꽃의 이름을 우리는 아직 모른다",
        "ㄴㅇ ㅊㅈㅇ ㅁㄱㅅㅇ", "너의 췌장을 먹고싶어",
        "ㅂㄹㄱ ㅎㄲ ㅅㄹㅈㄷ", "바람과 함께 사라지다",
       "ㅇㅂㅈㅅ:ㅇㅍㄴㅌ ㅇ", "어벤져스:인피니티 워", 
       "ㅅㄱㅎㄲ-ㅈㅇ ㅂ", "신과함께-죄와 벌",
       "ㅂㄴㅇ ㅈㅈ:ㄷ ㅇㅅㅌㄹ", "분노의 질주:더 익스트림",
       "ㅇㅁㅎㄱ ㅇㄷㅎㄱ", "은밀하게 위대하게",
       "ㄴㅇ ㄱ ㄱㅇ ㄱㄴㅈㅁㅇ", "님아 그 강을 건너지마오",
       "ㅎㅇㅇ ㅇㅈㅇㄴ ㅅ", "하울의 움직이는 성",
        // 더 많은 어려운 퀴즈 데이터를 추가하세요
    };

    private String[] currentQuizData;

    private int currentQuizIndex = 0;
    private int correctCount = 0;
    private int incorrectCount = 0;

    public GameCategory1(String difficulty) {
        setTitle("영화 카테고리 - 초성 퀴즈");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        if ("쉬움".equalsIgnoreCase(difficulty)) {
            currentQuizData = easyQuizData;
        } else if ("어려움".equalsIgnoreCase(difficulty)) {
            currentQuizData = hardQuizData;
        }
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        questionLabel = new JLabel("영화 카테고리 - 초성 퀴즈");
        questionLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(questionLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 1));

        JLabel hintLabel = new JLabel("초성: " + currentQuizData[currentQuizIndex]);
        hintLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        centerPanel.add(hintLabel);

        answerField = new JTextField();
        answerField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        centerPanel.add(answerField);

        panel.add(centerPanel, BorderLayout.CENTER);

        submitButton = new JButton("제출");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userAnswer = answerField.getText().trim();
                String correctAnswer = currentQuizData[currentQuizIndex + 1];

                if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                    correctCount++;
                } else {
                    incorrectCount++;
                }

                currentQuizIndex += 2;

                if (currentQuizIndex < currentQuizData.length) {
                    hintLabel.setText("초성: " + currentQuizData[currentQuizIndex]);
                } else {
                    JOptionPane.showMessageDialog(null, "퀴즈 종료!\n맞춘 개수: " + correctCount + "\n틀린 개수: " + incorrectCount);
                    dispose();
                }

                answerField.setText("");
            }
        });

        panel.add(submitButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}


//GameCategory2 - 음식 카테고리
class GameCategory2 extends JFrame {
  private JLabel questionLabel;
  private JTextField answerField;
  private JButton submitButton;

  private String[] easyQuizData = {
        "ㄹㅁ", "라면",
        "ㄲㄹㅂㄴㄹ ㅍㅅㅌ", "까르보나라 파스타",
        "ㄸㅂㅇ", "떡볶이",
        "ㅎㅂㄱ", "햄버거",
        "ㄷㅂㅇㅌ", "닭볶음탕",
        "ㄱㅈㅌㄱ", "감자튀김",
        "ㅇㄱㅉ", "아구찜",
        "ㄱㄹㄱㅈㄹ ㅍㅈ", "고르곤졸라 피자",
        "ㅉㅈㅁ", "짜장면",
        "ㄱㅊㅂㅇㅂ", "김치볶음밥"
      // 더 많은 쉬운 퀴즈 데이터를 추가하세요
  };

  private String[] hardQuizData = {
        "ㅍㄹㅊㅌㅅㅌ", "프렌치토스트",
        "ㅇㅋㄴㅁㅇㅋ", "오코노미야키",
        "ㅇㄹㅇㅇㅇㅇ", "알리오올리오",
        "ㄴㄱㅅㅋ ㅉㅃ", "나가사키 짬뽕",
        "ㄲㅂㄹㅇ", "꿔바로우",
        "ㅋㄹㄷㄲㅅ", "카레돈까스",
        "ㅈㅈㅂㅂㅂ", "전주비빔밥",
        "ㅇㄴㄱㅈ", "양념게장",
        "ㄸㅇㄲ", "똠양꿍",
        "ㅅㅂㅇㅎㅅ", "슈바인학센"
      // 더 많은 어려운 퀴즈 데이터를 추가하세요
  };

  private String[] currentQuizData;

  private int currentQuizIndex = 0;
  private int correctCount = 0;
  private int incorrectCount = 0;

  public GameCategory2(String difficulty) {
      setTitle("음식 카테고리 - 초성 퀴즈");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(400, 200);
      setLocationRelativeTo(null);

      if ("쉬움".equalsIgnoreCase(difficulty)) {
           currentQuizData = easyQuizData;
       } else if ("어려움".equalsIgnoreCase(difficulty)) {
           currentQuizData = hardQuizData;
       }

      JPanel panel = new JPanel();
      panel.setLayout(new BorderLayout());

      // 나머지 코드는 GameCategory1과 유사하게 작동합니다
  }
}

class GameCategory3 extends JFrame {
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton;

    private String[] easyQuizData = {
        "ㄱㅇㅇ", "고양이",
        "ㄴㄷ", "늑대",
        "ㅎㅇㅇㄴ", "하이에나",
        "ㅇㅃㅁ", "올빼미",
        "ㄸㄸㄱㄹ", "딱따구리",
        "ㄷㄹㅈ", "다람쥐",
        "ㅇㅍㅋ", "알파카",
        "ㄷㄱㄹ", "돌고래",
        "ㄷㄴㄱ", "당나귀",
        "ㅎㅅㅌ", "햄스터"
        // 더 많은 쉬운 퀴즈 데이터를 추가하세요
    };

    private String[] hardQuizData = {
        "ㅂㄷㅋㄲㄹ", "바다코끼리",
        "ㄱㅁㅎㄱ", "개미핥기",
        "ㅂㄷㅂㅇ", "반딧불이",
        "ㅇㄹㅁㄷㄹ", "아르마딜로",
        "ㄴㅁㄴㅂ", "나무늘보",
        "ㄱㄴㅍㄱ", "기니피그",
        "ㅇㄹㄲㄹ ㅇㅇㅇㅅㅇ", "알락꼬리 여우원숭이",
        "ㄹㅅㅍㄷ", "랫서판다",
        "ㅋㅍㅂㄹ", "카피바라",
        "ㄱㅅㄷㅊ", "고슴도치",
        // 더 많은 어려운 퀴즈 데이터를 추가하세요
    };

    private String[] currentQuizData;

    private int currentQuizIndex = 0;
    private int correctCount = 0;
    private int incorrectCount = 0;

    public GameCategory3(String difficulty) {
        setTitle("동물 카테고리 - 초성 퀴즈");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        if ("쉬움".equalsIgnoreCase(difficulty)) {
            currentQuizData = easyQuizData;
        } else if ("어려움".equalsIgnoreCase(difficulty)) {
            currentQuizData = hardQuizData;
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        questionLabel = new JLabel("동물 카테고리 - 초성 퀴즈");
        questionLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(questionLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 1));

        JLabel hintLabel = new JLabel("초성: " + currentQuizData[currentQuizIndex]);
        hintLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        centerPanel.add(hintLabel);

        answerField = new JTextField();
        answerField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        centerPanel.add(answerField);

        panel.add(centerPanel, BorderLayout.CENTER);

        submitButton = new JButton("제출");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userAnswer = answerField.getText().trim();
                String correctAnswer = currentQuizData[currentQuizIndex + 1];

                if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                    correctCount++;
                } else {
                    incorrectCount++;
                }

                currentQuizIndex += 2;

                if (currentQuizIndex < currentQuizData.length) {
                    hintLabel.setText("초성: " + currentQuizData[currentQuizIndex]);
                } else {
                    JOptionPane.showMessageDialog(null, "퀴즈 종료!\n맞춘 개수: " + correctCount + "\n틀린 개수: " + incorrectCount);
                    dispose();
                }

                answerField.setText("");
            }
        });

        panel.add(submitButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}

class GameCategory4 extends JFrame {
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton;

    private String[] easyQuizData = {
        "ㅍㅁㅇㄹㄷ", "필마이리듬",
        "ㄷㄹㄷㄹ", "달라달라",
        "ㅅㅇㄱ", "색안경",
        "ㅅㅉㅅㄹㅇ", "살짝설렜어",
        "ㄱㅇㄱㅌ", "겟어기타",
        "ㅅㅇㄱ", "손오공",
        "ㅍㅇㅌ ㅎㅇㅈ", "파이팅 해야지",
        "ㅂㅋㅂ", "벤쿠버",
        "ㅎㄹㅇㅇ ㄲ", "후라이의 꿈",
        // 더 많은 쉬운 퀴즈 데이터를 추가하세요
    };

    private String[] hardQuizData = {
        "ㄴ ㄱㅃㅇ ㄴㄱ ㅂㅌㄹㄹ ㄲㄴㄱㅇ", "내 기쁨은 너가 벤틀리를 끄는거야",
        "ㄱㅁ ㅅㅇㅇ ㅍㅇㄴ ㅈㅁ", "건물 사이에 피어난 장미",
        "ㅇ ㅅㅅㅇ ㄲㅇ ㄷㅅ ㅆ ㅂㄹㅎ", "이 소설의 끝을 다시 써 보려해",
        "ㅇㄸㄱ ㅇㅂㄲㅈ ㅅㄹㅎㄱㅇ,ㄴ ㅅㄹㅎㄴㄱㅈ", "어떻게 이별까지 사랑하겠어,널 사랑하는거지",
        "ㅅㄹㅇㅇㅎㅅㄷㅂㅇㅅ", "사랑은은하수다방에서",
        "ㅇㄴ ㄴ ㅁㄹㅇㅅ ㅃㅇ ㅈㄹㄷ", "어느 날 머리에서 뿔이 자랐다",
        "ㅇㄹㅁ ㅇㄷㄱ ㅇㄴㄷ ㄴ ㅇㅇㅅㅁ ㅅㅁ ㄴㄹ", "이러면 안될거 아는데 니 앞에서만 서면 나락",
        "ㄱㄱ ㅇㅁ ㅇㄹㅇ ㅈㅁㅇ ㅇㄴㄱㅇ", "그건 아마 우리의 잘못은 아닐거야",
        "ㅈㅇ ㄱㄷㅇ ㅇㅎ ㅅ", "작은 것들을 위한 시",
        "ㅎㄷㄹㄴ ㄲㄷ ㅅㅇㅅ ㄴ ㅅㅍㅎㅇ ㄴㄲㅈㄱㅇ", "흔들리는 꽃들 속에서 니 샴푸향이 느껴진거야",
        // 더 많은 어려운 퀴즈 데이터를 추가하세요
    };

    private String[] currentQuizData;

    private int currentQuizIndex = 0;
    private int correctCount = 0;
    private int incorrectCount = 0;

    public GameCategory4(String difficulty) {
        setTitle("음악 카테고리 - 초성 퀴즈");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        if ("쉬움".equalsIgnoreCase(difficulty)) {
            currentQuizData = easyQuizData;
        } else if ("어려움".equalsIgnoreCase(difficulty)) {
            currentQuizData = hardQuizData;
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        questionLabel = new JLabel("음악 카테고리 - 초성 퀴즈");
        questionLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(questionLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 1));

        JLabel hintLabel = new JLabel("초성: " + currentQuizData[currentQuizIndex]);
        hintLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        centerPanel.add(hintLabel);

        answerField = new JTextField();
        answerField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        centerPanel.add(answerField);

        panel.add(centerPanel, BorderLayout.CENTER);

        submitButton = new JButton("제출");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userAnswer = answerField.getText().trim();
                String correctAnswer = currentQuizData[currentQuizIndex + 1];

                if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                    correctCount++;
                } else {
                    incorrectCount++;
                }

                currentQuizIndex += 2;

                if (currentQuizIndex < currentQuizData.length) {
                    hintLabel.setText("초성: " + currentQuizData[currentQuizIndex]);
                } else {
                    JOptionPane.showMessageDialog(null, "퀴즈 종료!\n맞춘 개수: " + correctCount + "\n틀린 개수: " + incorrectCount);
                    dispose();
                }

                answerField.setText("");
            }
        });

        panel.add(submitButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}

class Quiz extends JFrame {
    public Quiz() {
        setTitle("초성 퀴즈 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("초성 퀴즈 게임");
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel, BorderLayout.CENTER);

        JButton startButton = new JButton("게임 시작!");
        panel.add(startButton, BorderLayout.SOUTH);

        startButton.addActionListener(e -> showCategoryButtons());

        add(panel);
        setVisible(true);
    }

    private void showCategoryButtons() {
        setTitle("카테고리 선택");
        getContentPane().removeAll();

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(10, 10, 10, 10);

        JButton movieButton = new JButton("영화");
        JButton foodButton = new JButton("음식");
        JButton animalButton = new JButton("동물");
        JButton musicButton = new JButton("음악");

        panel.add(movieButton, constraints);
        panel.add(foodButton, constraints);
        panel.add(animalButton, constraints);
        panel.add(musicButton, constraints);

        movieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDifficultyDialog("영화");
            }
        });

        foodButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDifficultyDialog("음식");
            }
        });

        animalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDifficultyDialog("동물");
            }
        });

        musicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDifficultyDialog("음악");
            }
        });

        add(panel);
        revalidate();
        repaint();
    }

    private void showDifficultyDialog(String category) {
        String difficulty = (String) JOptionPane.showInputDialog(null, "난이도를 선택하세요:", "난이도 선택", JOptionPane.QUESTION_MESSAGE, null, new String[]{"쉬움", "어려움"}, "쉬움");
        if (difficulty != null) {
            switch (category) {
                case "영화":
                    new GameCategory1(difficulty);
                    break;
                case "음식":
                    new GameCategory2(difficulty);
                    break;
                case "동물":
                    new GameCategory3(difficulty);
                    break;
                case "음악":
                    new GameCategory4(difficulty);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Quiz();
            }
        });
    }
}