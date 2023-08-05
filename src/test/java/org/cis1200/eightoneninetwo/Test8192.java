package org.cis1200.eightoneninetwo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Test8192 {

    @Test
    public void testMoveLeftArrow() {
        Game8192 game = new Game8192();

        int[][] board = { { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 },
            { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 } };

        game.setBoard(board);
        game.processMove(37, true);

        int[][] currentBoard = game.getBoard();
        int[][] expectedBoard = { { 4, 4, 4, 8, 0, 0 }, { 4, 4, 4, 8, 0, 0 }, { 4, 4, 4, 8, 0, 0 },
            { 4, 4, 4, 8, 0, 0 }, { 4, 4, 4, 8, 0, 0 }, { 4, 4, 4, 8, 0, 0 } };

        assertArrayEquals(expectedBoard, currentBoard);
    }

    @Test
    public void testMoveLeftA() {
        Game8192 game = new Game8192();

        int[][] board = { { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 },
            { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 } };

        game.setBoard(board);
        game.processMove(65, true);

        int[][] currentBoard = game.getBoard();
        int[][] expectedBoard = { { 4, 4, 4, 8, 0, 0 }, { 4, 4, 4, 8, 0, 0 }, { 4, 4, 4, 8, 0, 0 },
            { 4, 4, 4, 8, 0, 0 }, { 4, 4, 4, 8, 0, 0 }, { 4, 4, 4, 8, 0, 0 } };

        assertArrayEquals(expectedBoard, currentBoard);
    }

    @Test
    public void testMoveRightArrow() {
        Game8192 game = new Game8192();

        int[][] board = { { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 },
            { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 } };

        game.setBoard(board);
        game.processMove(39, true);

        int[][] currentBoard = game.getBoard();
        int[][] expectedBoard = { { 0, 0, 4, 4, 4, 8 }, { 0, 0, 4, 4, 4, 8 }, { 0, 0, 4, 4, 4, 8 },
            { 0, 0, 4, 4, 4, 8 }, { 0, 0, 4, 4, 4, 8 }, { 0, 0, 4, 4, 4, 8 } };

        assertArrayEquals(expectedBoard, currentBoard);
    }

    @Test
    public void testMoveRightD() {
        Game8192 game = new Game8192();

        int[][] board = { { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 },
            { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 } };

        game.setBoard(board);
        game.processMove(68, true);

        int[][] currentBoard = game.getBoard();
        int[][] expectedBoard = { { 0, 0, 4, 4, 4, 8 }, { 0, 0, 4, 4, 4, 8 }, { 0, 0, 4, 4, 4, 8 },
            { 0, 0, 4, 4, 4, 8 }, { 0, 0, 4, 4, 4, 8 }, { 0, 0, 4, 4, 4, 8 } };

        assertArrayEquals(expectedBoard, currentBoard);
    }

    @Test
    public void testMoveUpArrow() {
        Game8192 game = new Game8192();

        int[][] board = { { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 },
            { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 } };

        game.setBoard(board);
        game.processMove(38, true);

        int[][] currentBoard = game.getBoard();
        int[][] expectedBoard = { { 4, 4, 4, 4, 8, 16 }, { 4, 4, 4, 4, 8, 16 },
            { 4, 4, 4, 4, 8, 16 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 } };

        assertArrayEquals(expectedBoard, currentBoard);
    }

    @Test
    public void testMoveUpW() {
        Game8192 game = new Game8192();

        int[][] board = { { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 },
            { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 } };

        game.setBoard(board);
        game.processMove(87, true);

        int[][] currentBoard = game.getBoard();
        int[][] expectedBoard = { { 4, 4, 4, 4, 8, 16 }, { 4, 4, 4, 4, 8, 16 },
            { 4, 4, 4, 4, 8, 16 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 } };

        assertArrayEquals(expectedBoard, currentBoard);
    }

    @Test
    public void testMoveDownArrow() {
        Game8192 game = new Game8192();

        int[][] board = { { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 },
            { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 } };

        game.setBoard(board);
        game.processMove(40, true);

        int[][] currentBoard = game.getBoard();
        int[][] expectedBoard = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
            { 4, 4, 4, 4, 8, 16 }, { 4, 4, 4, 4, 8, 16 }, { 4, 4, 4, 4, 8, 16 } };

        assertArrayEquals(expectedBoard, currentBoard);
    }

    @Test
    public void testMoveDownS() {
        Game8192 game = new Game8192();

        int[][] board = { { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 },
            { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 }, { 2, 2, 2, 2, 4, 8 } };

        game.setBoard(board);
        game.processMove(83, true);

        int[][] currentBoard = game.getBoard();
        int[][] expectedBoard = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
            { 4, 4, 4, 4, 8, 16 }, { 4, 4, 4, 4, 8, 16 }, { 4, 4, 4, 4, 8, 16 } };

        assertArrayEquals(expectedBoard, currentBoard);
    }

    @Test
    public void testBoardIsFullNo8192() {
        Game8192 game = new Game8192();

        int[][] board = { { 2, 4, 8, 16, 2, 4 }, { 4, 2, 16, 8, 4, 2 }, { 2, 4, 8, 16, 2, 4 },
            { 4, 2, 16, 8, 4, 2 }, { 2, 4, 8, 16, 2, 4 }, { 4, 2, 16, 8, 4, 2 } };

        game.setBoard(board);
        game.processMove(83, true);

        int[][] currentBoard = game.getBoard();

        assertArrayEquals(board, currentBoard);
    }

    @Test
    public void testBoardIsFullWith8192() {
        Game8192 game = new Game8192();

        int[][] board = { { 2, 4, 8, 16, 2, 4 }, { 4, 2, 16, 8, 4, 2 }, { 2, 4, 8, 16, 2, 4 },
            { 4, 2, 16, 8, 4, 2 }, { 2, 4, 8, 16, 2, 4 }, { 4, 2, 16, 8, 4, 8192 } };

        game.setBoard(board);
        game.processMove(65, true);

        int[][] currentBoard = game.getBoard();

        assertArrayEquals(board, currentBoard);
    }

}
