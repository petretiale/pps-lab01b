package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

public class LogicTest {

    private final int SIZE = 5;
    private final Pair<Integer, Integer> START_POS = new Pair<>(0, 0);
    private final Pair<Integer, Integer> AWAY_POS = new Pair<>(4, 4);
    private final Pair<Integer, Integer> VALID_L_MOVE = new Pair<>(2, 1);

    @Test
    void testSuccessfulHit() {
        Board board = new Board(SIZE, START_POS, VALID_L_MOVE);
        LogicsImpl logic = new LogicsImpl(board);
        Assertions.assertTrue(logic.hit(VALID_L_MOVE.getX(), VALID_L_MOVE.getY()));
    }

    @Test
    void testInvalidMove() {
        Board board = new Board(SIZE, START_POS, AWAY_POS);
        LogicsImpl logic = new LogicsImpl(board);
        final Pair<Integer, Integer> illegalMove= new Pair<>(0, 1);
        Assertions.assertFalse(logic.hit(illegalMove.getX(), illegalMove.getY()));
    }

    @Test
    void testHitOutOfBounds() {
        LogicsImpl logic = new LogicsImpl(SIZE);
        int wrongCol = -1;
        int wrongRow = -1;
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> logic.hit(wrongRow, wrongCol));
    }
}
