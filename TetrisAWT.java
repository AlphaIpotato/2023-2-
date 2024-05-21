package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TetrisAWT extends JFrame implements KeyListener {
    private static final int BOARD_WIDTH = 10; // 게임 보드의 가로 칸 수
    private static final int BOARD_HEIGHT = 20; // 게임 보드의 세로 칸 수
    private static final int SQUARE_SIZE = 30; // 각 사각형의 크기(픽셀)

    private int[][] board = new int[BOARD_HEIGHT][BOARD_WIDTH]; // 게임 보드를 표현하는 2차원 배열
    private int[][] currentShape; // 현재 이동 중인 도형
    private int currentX = BOARD_WIDTH / 2 - 1; // 현재 도형의 X 위치
    private int currentY = 0; // 현재 도형의 Y 위치

    public TetrisAWT() {
        setTitle("Tetris AWT"); // 창 제목 설정
        setSize(BOARD_WIDTH * SQUARE_SIZE, BOARD_HEIGHT * SQUARE_SIZE); // 창 크기 설정
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 창 닫힘 동작 설정
        setLocationRelativeTo(null); // 창 위치를 화면 중앙에 배치
        setResizable(false); // 창 크기 조절 불가능하게 설정
        addKeyListener(this); // 키 이벤트 리스너 추가

        createNewShape(); // 새 도형 생성
    }

    // 새 도형 생성 메서드
    private void createNewShape() {
        currentShape = new int[][]{
                {1, 1},
                {1, 1}
        }; // 2x2 사각형 도형 생성
    }

    // 이동 가능 여부 확인 메서드
    private boolean canMoveTo(int newX, int newY) {
        // 현재 도형이 새 위치로 이동할 수 있는지 검사
        for (int row = 0; row < currentShape.length; row++) {
            for (int col = 0; col < currentShape[row].length; col++) {
                if (currentShape[row][col] == 1) {
                    int boardX = newX + col;
                    int boardY = newY + row;

                    // 도형이 게임 보드 내부에 있는지, 다른 도형과 겹치는지 확인
                    if (boardX < 0 || boardX >= BOARD_WIDTH || boardY >= BOARD_HEIGHT || board[boardY][boardX] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // 현재 도형을 게임 보드에 병합하는 메서드
    private void mergeShapeToBoard() {
        for (int row = 0; row < currentShape.length; row++) {
            for (int col = 0; col < currentShape[row].length; col++) {
                if (currentShape[row][col] == 1) {
                    board[currentY + row][currentX + col] = 1;
                }
            }
        }
    }

    private void checkAndClearLines() {
        for (int row = BOARD_HEIGHT - 1; row >= 0; ) {
            boolean isLineComplete = true;
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (board[row][col] == 0) {
                    isLineComplete = false;
                    break;
                }
            }

            // 완성된 라인이 있으면 제거하고 위쪽 라인들을 아래로 이동
            if (isLineComplete) {
                for (int r = row; r > 0; r--) {
                    for (int col = 0; col < BOARD_WIDTH; col++) {
                        board[r][col] = board[r - 1][col];
                    }
                }
            } else {
                row--; // 완성된 라인이 없으면 다음 라인 확인
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 게임 보드 그리기
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (board[row][col] == 1) {
                    g.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                }
            }
        }

        // 현재 도형 그리기
        for (int row = 0; row < currentShape.length; row++) {
            for (int col = 0; col < currentShape[row].length; col++) {
                if (currentShape[row][col] == 1) {
                    g.fillRect((currentX + col) * SQUARE_SIZE, (currentY + row) * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    // 키 이벤트 처리
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT) {// 왼쪽 화살표 키 처리
            if (canMoveTo(currentX - 1, currentY)) {
                currentX--;
            }
        } else if (keyCode == KeyEvent.VK_RIGHT) {// 오른쪽 화살표 키 처리
            if (canMoveTo(currentX + 1, currentY)) {
                currentX++;
            }
        } else if (keyCode == KeyEvent.VK_DOWN) {// 아래 화살표 키 처리
            if (canMoveTo(currentX, currentY + 1)) {
                currentY++;
            } else {
                mergeShapeToBoard();
                checkAndClearLines();
                createNewShape();
                currentX = BOARD_WIDTH / 2 - 1;
                currentY = 0;
            }
        }

        repaint(); // 화면 갱신
    }

    // 아래 메서드는 구현되지 않았지만 KeyListener 인터페이스를 구현하기 위해 필요함
    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TetrisAWT tetris = new TetrisAWT();
                tetris.setVisible(true); // 게임 창을 보이게 함
            }
        });
    }
}