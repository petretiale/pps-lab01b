package it.unibo.pps.e2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    private final int SIZE = 5;
    private final Pair<Integer, Integer> KNIGHT_START_POS = new Pair<>(0, 0);
    private final Pair<Integer, Integer> PAWN_START_POS = new Pair<>(4, 4);

    @Test
    void testKnightStartsAtCorrectPosition() {
        Board board = new Board(SIZE, KNIGHT_START_POS, PAWN_START_POS);
        Assertions.assertTrue(board.hasKnight(KNIGHT_START_POS.getX(), KNIGHT_START_POS.getY()));
    }

    @Test
    void testPawnStartsAtCorrectPosition() {
        Board board = new Board(SIZE, KNIGHT_START_POS, PAWN_START_POS);
        Assertions.assertTrue(board.hasPawn(PAWN_START_POS.getX(), PAWN_START_POS.getY()));
    }

    @Test
    void testKnightPositionUpdatesAfterMove() {
        Board board = new Board(SIZE, KNIGHT_START_POS, PAWN_START_POS);
        Pair<Integer, Integer> newPos = new Pair<>(1, 2);
        board.moveKnight(newPos.getX(), newPos.getY());
        Assertions.assertEquals(newPos, board.getKnightPosition());
    }

    @Test
    void testKnightIsNoLongerAtOldPositionAfterMove() {
        Board board = new Board(SIZE, KNIGHT_START_POS, PAWN_START_POS);
        Pair<Integer, Integer> newPos = new Pair<>(1, 2);
        board.moveKnight(newPos.getX(), newPos.getY());
        Assertions.assertFalse(board.hasKnight(KNIGHT_START_POS.getX(), KNIGHT_START_POS.getY()));
    }

    @Test
    void testGetSize() {
        Board board = new Board(SIZE);
        Assertions.assertEquals(SIZE, board.getSize());
    }
}
