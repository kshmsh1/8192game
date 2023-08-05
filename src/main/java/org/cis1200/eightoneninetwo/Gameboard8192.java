package org.cis1200.eightoneninetwo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class instantiates an 8192 object, which is the model for the game.
 * As the user presses keys related to the game, the model is updated. Whenever
 * the model is updated, the game board repaints itself and updates its status
 * JLabel to reflect the current state of the model.
 * 
 * This game adheres to a Model-View-Controller design framework. This
 * framework is very effective for turn-based games.
 * 
 * In a Model-View-Controller framework, GameBoard stores the model as a field
 * and acts as both the controller (with a MouseListener) and the view (with
 * its paintComponent method and the status JLabel).
 */
@SuppressWarnings("serial")
public class Gameboard8192 extends JPanel {

    private Game8192 game; // model for the game
    private JLabel status; // current status text

    // Game constants
    public static final int BOARD_WIDTH = 600;
    public static final int BOARD_HEIGHT = 600;
    public static final int CELL_SIZE = BOARD_WIDTH / 6;

    /**
     * Initializes the game board.
     */
    public Gameboard8192(JLabel statusInit) {
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Enable keyboard focus on the court area. When this component has the
        // keyboard focus, key events are handled by its key listener.
        setFocusable(true);

        game = new Game8192(); // initializes model for the game
        status = statusInit; // initializes the status JLabel

        // Listens for key presses. Updates the model, then updates the game
        // board based off of the updated model.
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (game.isGameOver() || game.hasWon()) {
                    return;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP
                        || e.getKeyCode() == KeyEvent.VK_DOWN
                        || e.getKeyCode() == KeyEvent.VK_LEFT
                        || e.getKeyCode() == KeyEvent.VK_RIGHT
                        || e.getKeyCode() == KeyEvent.VK_W
                        || e.getKeyCode() == KeyEvent.VK_S
                        || e.getKeyCode() == KeyEvent.VK_A
                        || e.getKeyCode() == KeyEvent.VK_D) {
                    game.processMove(e.getKeyCode(), false);
                    updateStatus(); // updates the status JLabel
                    repaint(); // repaints the game board
                }
            }
        });
    }

    public void saveGame(String filename) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            int[][] board = game.getBoard();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    writer.print(board[i][j]);
                    if (j < board[i].length - 1) {
                        writer.print(",");
                    }
                }
                writer.println();
            }
            status.setText("Game saved to " + filename);
        } catch (IOException e) {
            status.setText("Error saving game to " + filename);
        } finally {
            requestFocusInWindow();
        }
    }

    public void loadGame(String filename) {
        try {
            java.util.Scanner s = new java.util.Scanner(new File(filename));
            int[][] board = new int[6][6];
            int count = 0;
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] parts = line.split(",");
                int[] arr = new int[6];
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(parts[i]);
                    arr[i] = Integer.parseInt(parts[i]);
                }
                board[count] = arr;
                count++;
            }
            game.setBoard(board);
            updateStatus();
            repaint();
            status.setText("Game loaded from " + filename);
        } catch (IOException e) {
            status.setText("Error loading game from " + filename);
        } finally {
            requestFocusInWindow();
        }
    }

    /**
     * (Re-)sets the game to its initial state.
     */
    public void reset() {
        game.reset();
        status.setText("New Game");
        repaint();
        requestFocusInWindow();
    }

    /**
     * Updates the JLabel to reflect the current state of the game.
     */
    private void updateStatus() {
        if (game.isGameOver()) {
            status.setText("Game Over");
        } else if (game.hasWon()) {
            status.setText("You won! What a legend - click the reset button to start a new game!");
        } else {
            status.setText("Score: " + game.getScore());
        }
    }

    /**
     * Draws the game board.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[][] board = game.getBoard();

        // Draws board grid
        g.drawLine(100, 100, 100, 700);
        g.drawLine(100, 100, 700, 100);
        g.drawLine(100, 700, 100, 100);
        g.drawLine(700, 100, 100, 100);

        // Draws X's and O's
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                int cellValue = board[i][j];
                if (cellValue != 0) {
                    g.setColor(Color.BLUE);
                    g.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
                    g.drawString(
                            String.valueOf(cellValue), j * CELL_SIZE + CELL_SIZE / 2 - 10,
                            i * CELL_SIZE + CELL_SIZE / 2 + 5
                    );
                }
            }
        }

        g.setColor(Color.BLUE);
        for (int i = 0; i <= 6; i++) {
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, BOARD_HEIGHT);
            g.drawLine(0, i * CELL_SIZE, BOARD_WIDTH, i * CELL_SIZE);
        }
    }

    /**
     * Returns the current state of the game as a CSV formatted string.
     * The first row contains the column headers ("row,col,value").
     * Each subsequent row contains the cell row, column, and value separated by
     * commas.
     */
    public String getCurrentStateAsCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append("row,col,value\n");
        int[][] board = game.getBoard();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(i).append(",").append(j).append(",").append(board[i][j]).append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * Returns the size of the game board.
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
    }
}