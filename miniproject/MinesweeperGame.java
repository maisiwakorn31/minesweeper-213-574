import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MinesweeperGame extends JPanel {
    private int rows, cols, numBombs;
    private JButton[][] buttons;
    private boolean[][] bombs;
    private int[][] adjacentBombs;

    private JFrame parentWindow;

    
    public MinesweeperGame(int rows, int cols, int numBombs, JFrame parentWindow) {
        this.rows = rows;
        this.cols = cols;
        this.numBombs = numBombs;
        this.buttons = new JButton[rows][cols];
        this.bombs = new boolean[rows][cols];
        this.adjacentBombs = new int[rows][cols];
        this.parentWindow = parentWindow;  
        
        setLayout(new GridLayout(rows, cols));

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(40, 40));

                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(e -> reveal(row, col));

                add(buttons[i][j]);
            }
        }

        
        placeBombs();
        
        calculateAdjacentBombs();
    }

    
    private void placeBombs() {
        Random rand = new Random();
        int placedBombs = 0;

        while (placedBombs < numBombs) {
            int row = rand.nextInt(rows);
            int col = rand.nextInt(cols);

            if (!bombs[row][col]) {
                bombs[row][col] = true;
                placedBombs++;
            }
        }
    }

    
    private void calculateAdjacentBombs() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (bombs[row][col]) {
                    continue;  
                }

                int bombCount = 0;
                
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int r = row + i;
                        int c = col + j;

                        
                        if (r >= 0 && r < rows && c >= 0 && c < cols && bombs[r][c]) {
                            bombCount++;
                        }
                    }
                }

                adjacentBombs[row][col] = bombCount;
            }
        }
    }

    
    private void reveal(int row, int col) {
        
        if (!buttons[row][col].isEnabled()) {
            return;
        }

        
        if (bombs[row][col]) {
            buttons[row][col].setBackground(Color.RED);  
            buttons[row][col].setText("B");
            JOptionPane.showMessageDialog(this, "Game Over!", "Bomb", JOptionPane.ERROR_MESSAGE);

            int response = JOptionPane.showConfirmDialog(this, "Do you want to play again?", "Restart", JOptionPane.YES_NO_OPTION);

            if (response == JOptionPane.YES_OPTION) {
                restartGame();  
            } else {
                
                parentWindow.dispose();  
                new Gui();  
            }
        } else {
            int bombCount = adjacentBombs[row][col];
            buttons[row][col].setEnabled(false);  
            buttons[row][col].setBackground(Color.LIGHT_GRAY);
            buttons[row][col].setText(bombCount > 0 ? String.valueOf(bombCount) : "");

            
            if (bombCount == 0) {
                revealAdjacentCells(row, col);
            }
        }
    }

    
    private void revealAdjacentCells(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int r = row + i;
                int c = col + j;

                
                if (r >= 0 && r < rows && c >= 0 && c < cols && buttons[r][c].isEnabled()) {
                    reveal(r, c);
                }
            }
        }
    }

    
    private void restartGame() {
        
        removeAll();
        revalidate();
        repaint();

        
        this.buttons = new JButton[rows][cols];
        this.bombs = new boolean[rows][cols];
        this.adjacentBombs = new int[rows][cols];

        
        setLayout(new GridLayout(rows, cols));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(40, 40));

                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(e -> reveal(row, col));

                add(buttons[i][j]);
            }
        }

        placeBombs();
        calculateAdjacentBombs();
    }
}
