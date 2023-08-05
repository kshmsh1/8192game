package org.cis1200.eightoneninetwo;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class is a model for 8192.
 * Run this file to see the main method play a game of 8192.
 */
public class Game8192 {

    private int[][] board;
    private boolean gameOver;
    private int score;
    private static final int SIZE = 6;

    private Set<Integer> numbers = new TreeSet<>();

    /**
     * Constructor sets up game state.
     */
    public Game8192() {
        reset();
    }

    private void addRandomTile() {
        int position = -1;
        int empty = 0;

        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                if (board[i][j] == 0) {
                    empty++;
                    Random rand = new Random();
                    if (rand.nextInt(empty) == 0) {
                        position = i * SIZE + j;
                    }
                }
            }
        }

        if (position != -1) {
            int val = (new Random().nextInt(10) == 0) ? 4 : 2;
            board[position / SIZE][position % SIZE] = val;
        }

        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                if (!numbers.contains(board[i][j])) {
                    numbers.add(board[i][j]);
                }
            }
        }
    }

    /**
     * reset (re-)sets the game state to start a new game.
     */
    public void reset() {
        board = new int[SIZE][SIZE];
        gameOver = false;
        score = 0;
        addRandomTile();
        addRandomTile();
    }

    public int getScore() {
        return score;
    }

    public int[][] getBoard() {
        return board;
    }

    public void processMove(int keyCode, boolean test) {
        int[][] oldBoard = copyBoard(board);

        switch (keyCode) {
            case 38, 87:
                moveUp();
                break;
            case 40, 83:
                moveDown();
                break;
            case 37, 65:
                moveLeft();
                break;
            case 39, 68:
                moveRight();
                break;
            default:
                return;
        }

        if (!boardsEqual(oldBoard, board) && !test) {
            addRandomTile();
            checkGameOver();
        }
    }

    private void moveUp() {
        for (int col = 0; col < SIZE; col++) {
            int[] newCol = new int[SIZE];
            int newIndex = 0;
            int lastMergedValue = 0;

            for (int row = 0; row < SIZE; row++) {
                int value = board[row][col];
                if (value != 0) {
                    if (value == lastMergedValue) {
                        newCol[newIndex - 1] = value * 2;
                        lastMergedValue = 0;
                        score += value * 2;
                    } else {
                        newCol[newIndex] = value;
                        lastMergedValue = value;
                        newIndex++;
                    }
                }
            }
            for (int row = 0; row < SIZE; row++) {
                board[row][col] = newCol[row];
            }
        }
    }

    private void moveDown() {
        for (int col = 0; col < SIZE; col++) {
            int[] newCol = new int[SIZE];
            int newIndex = SIZE - 1;
            int lastMergedValue = 0;

            for (int row = SIZE - 1; row >= 0; row--) {
                int value = board[row][col];
                if (value != 0) {
                    if (value == lastMergedValue) {
                        newCol[newIndex + 1] = value * 2;
                        lastMergedValue = 0;
                        score += value * 2;
                    } else {
                        newCol[newIndex] = value;
                        lastMergedValue = value;
                        newIndex--;
                    }
                }
            }
            for (int row = 0; row < SIZE; row++) {
                board[row][col] = newCol[row];
            }
        }
    }

    private void moveLeft() {
        for (int row = 0; row < SIZE; row++) {
            int[] newRow = new int[SIZE];
            int newIndex = 0;
            int lastMergedValue = 0;

            for (int col = 0; col < SIZE; col++) {
                int value = board[row][col];
                if (value != 0) {
                    if (value == lastMergedValue) {
                        newRow[newIndex - 1] = value * 2;
                        lastMergedValue = 0;
                        score += value * 2;
                    } else {
                        newRow[newIndex] = value;
                        lastMergedValue = value;
                        newIndex++;
                    }
                }
            }
            board[row] = newRow;
        }
    }

    private void moveRight() {
        for (int row = 0; row < SIZE; row++) {
            int[] newRow = new int[SIZE];
            int newIndex = SIZE - 1;
            int lastMergedValue = 0;

            for (int col = SIZE - 1; col >= 0; col--) {
                int value = board[row][col];
                if (value != 0) {
                    if (value == lastMergedValue) {
                        newRow[newIndex + 1] = value * 2;
                        lastMergedValue = 0;
                        score += value * 2;
                    } else {
                        newRow[newIndex] = value;
                        lastMergedValue = value;
                        newIndex--;
                    }
                }
            }
            board[row] = newRow;
        }
    }

    private int[][] copyBoard(int[][] initialBoard) {
        int[][] copy = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; ++i) {
            System.arraycopy(initialBoard[i], 0, copy[i], 0, SIZE);
        }
        return copy;
    }

    private boolean boardsEqual(int[][] board1, int[][] board2) {
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                if (board1[i][j] != board2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasEmptyTile() {
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                if (board[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean tilesCanMerge() {
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                int value = board[i][j];
                if ((i > 0 && board[i - 1][j] == value) ||
                        (i < SIZE - 1 && board[i + 1][j] == value) ||
                        (j > 0 && board[i][j - 1] == value) ||
                        (j < SIZE - 1 && board[i][j + 1] == value)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkGameOver() {
        if (!tilesCanMerge() && !hasEmptyTile()) {
            gameOver = true;
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean hasWon() {
        if (numbers.contains(8192)) {
            return true;
        }
        return false;
    }

    public void setBoard(int[][] arr) {
        if ((arr[0].length != board[0].length) || (arr.length != board.length)) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = arr[i][j];
            }
        }
    }

    /**
     * printGameState prints the current game state for debugging.
     */
    public void printGameState() {
        System.out.println("\n\nTurn " + "insert something here" + ":\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            if (i < 2) {
                System.out.println("\n---------");
            }
        }
    }

    /**
     * This main method illustrates how the model is completely independent of
     * the view and controller. We can play the game from start to finish
     * without ever creating a Java Swing object. This is modularity in action,
     * and modularity is the bedrock of the Model-View-Controller design framework.
     *
     * Run this file to see the output of this method in your console.
     */
    public static void main(String[] args) {
        Game8192 game = new Game8192();
    }
}