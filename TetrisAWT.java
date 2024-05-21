package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TetrisAWT extends JFrame implements KeyListener {
    private static final int BOARD_WIDTH = 10; // ���� ������ ���� ĭ ��
    private static final int BOARD_HEIGHT = 20; // ���� ������ ���� ĭ ��
    private static final int SQUARE_SIZE = 30; // �� �簢���� ũ��(�ȼ�)

    private int[][] board = new int[BOARD_HEIGHT][BOARD_WIDTH]; // ���� ���带 ǥ���ϴ� 2���� �迭
    private int[][] currentShape; // ���� �̵� ���� ����
    private int currentX = BOARD_WIDTH / 2 - 1; // ���� ������ X ��ġ
    private int currentY = 0; // ���� ������ Y ��ġ

    public TetrisAWT() {
        setTitle("Tetris AWT"); // â ���� ����
        setSize(BOARD_WIDTH * SQUARE_SIZE, BOARD_HEIGHT * SQUARE_SIZE); // â ũ�� ����
        setDefaultCloseOperation(EXIT_ON_CLOSE); // â ���� ���� ����
        setLocationRelativeTo(null); // â ��ġ�� ȭ�� �߾ӿ� ��ġ
        setResizable(false); // â ũ�� ���� �Ұ����ϰ� ����
        addKeyListener(this); // Ű �̺�Ʈ ������ �߰�

        createNewShape(); // �� ���� ����
    }

    // �� ���� ���� �޼���
    private void createNewShape() {
        currentShape = new int[][]{
                {1, 1},
                {1, 1}
        }; // 2x2 �簢�� ���� ����
    }

    // �̵� ���� ���� Ȯ�� �޼���
    private boolean canMoveTo(int newX, int newY) {
        // ���� ������ �� ��ġ�� �̵��� �� �ִ��� �˻�
        for (int row = 0; row < currentShape.length; row++) {
            for (int col = 0; col < currentShape[row].length; col++) {
                if (currentShape[row][col] == 1) {
                    int boardX = newX + col;
                    int boardY = newY + row;

                    // ������ ���� ���� ���ο� �ִ���, �ٸ� ������ ��ġ���� Ȯ��
                    if (boardX < 0 || boardX >= BOARD_WIDTH || boardY >= BOARD_HEIGHT || board[boardY][boardX] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // ���� ������ ���� ���忡 �����ϴ� �޼���
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

            // �ϼ��� ������ ������ �����ϰ� ���� ���ε��� �Ʒ��� �̵�
            if (isLineComplete) {
                for (int r = row; r > 0; r--) {
                    for (int col = 0; col < BOARD_WIDTH; col++) {
                        board[r][col] = board[r - 1][col];
                    }
                }
            } else {
                row--; // �ϼ��� ������ ������ ���� ���� Ȯ��
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // ���� ���� �׸���
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (board[row][col] == 1) {
                    g.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                }
            }
        }

        // ���� ���� �׸���
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

    // Ű �̺�Ʈ ó��
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT) {// ���� ȭ��ǥ Ű ó��
            if (canMoveTo(currentX - 1, currentY)) {
                currentX--;
            }
        } else if (keyCode == KeyEvent.VK_RIGHT) {// ������ ȭ��ǥ Ű ó��
            if (canMoveTo(currentX + 1, currentY)) {
                currentX++;
            }
        } else if (keyCode == KeyEvent.VK_DOWN) {// �Ʒ� ȭ��ǥ Ű ó��
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

        repaint(); // ȭ�� ����
    }

    // �Ʒ� �޼���� �������� �ʾ����� KeyListener �������̽��� �����ϱ� ���� �ʿ���
    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TetrisAWT tetris = new TetrisAWT();
                tetris.setVisible(true); // ���� â�� ���̰� ��
            }
        });
    }
}