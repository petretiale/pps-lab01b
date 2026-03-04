package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

public class LogicTest {

    private final int SIZE = 5;

    private final Pair<Integer, Integer> START_POS = new Pair<>(0, 0);
    private final Pair<Integer, Integer> AWAY_POS = new Pair<>(4, 4);
    private final Pair<Integer, Integer> VALID_L_MOVE = new Pair<>(1, 2);
    private final Pair<Integer, Integer> INVALID_MOVE = new Pair<>(0, 1);

    @Test
    public void testKnightMovesCorrectly() {
        Logics logic = new LogicsImpl(SIZE, START_POS, AWAY_POS);

        boolean hit = logic.hit(1, 2);

        Assertions.assertFalse(hit);
        Assertions.assertTrue(logic.hasKnight(VALID_L_MOVE.getX(), VALID_L_MOVE.getY()));
        Assertions.assertFalse(logic.hasKnight(START_POS.getX(), START_POS.getY()));
    }

    @Test
    public void testKnightHitsPawn() {
        Pair<Integer, Integer> pawnPos = new Pair<>(2, 1);
        Logics logic = new LogicsImpl(SIZE, START_POS, pawnPos);

        Assertions.assertTrue(logic.hit(pawnPos.getX(), pawnPos.getY()));
        Assertions.assertTrue(logic.hasKnight(pawnPos.getX(), pawnPos.getY()));
    }

    @Test
    public void testInvalidMove() {
        Logics logic = new LogicsImpl(SIZE, START_POS, AWAY_POS);;

        Assertions.assertFalse(logic.hit(INVALID_MOVE.getX(), INVALID_MOVE.getY()));
        Assertions.assertTrue(logic.hasKnight(START_POS.getX(), START_POS.getY()));
    }

    @Test
    public void testKnightCannotJumpOutsideBoard() {
        Logics logic = new LogicsImpl(SIZE, START_POS, AWAY_POS);

        Assertions.assertFalse(logic.hit(INVALID_MOVE.getX(), INVALID_MOVE.getY()));
        Assertions.assertTrue(logic.hasKnight(START_POS.getX(), START_POS.getY()));
    }

    @Test
    public void testHitReturnsFalseWhenNotOnPawn() {
        Logics logic = new LogicsImpl(SIZE, START_POS, AWAY_POS);
        Pair<Integer, Integer> pawnPos = new Pair<>(2, 1);
        boolean hit = logic.hit(pawnPos.getX(), pawnPos.getY());
        Assertions.assertFalse(hit);
    }
}
