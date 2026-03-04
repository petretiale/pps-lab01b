package it.unibo.pps.e2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnightMovementStrategyTest {

    private final MovementStrategy knightMovement = new KnightMovementStrategy();
    private final Pair<Integer, Integer> CENTER = new Pair<>(2, 2);

    @Test
    void testValidMoveUpLeft() {
        Pair<Integer, Integer> upLeftMove = new Pair<>(1, 0);
        Assertions.assertTrue(knightMovement.isValid(CENTER, upLeftMove));
    }

    @Test
    void testValidMoveUpRight() {
        Pair<Integer, Integer> upRightMove = new Pair<>(3, 0);
        Assertions.assertTrue(knightMovement.isValid(CENTER, upRightMove));
    }

    @Test
    void testInvalidMoveVerticalOnly() {
        Pair<Integer, Integer> straightVerticalMove = new Pair<>(2, 4);
        Assertions.assertFalse(knightMovement.isValid(CENTER, straightVerticalMove));
    }

    @Test
    void testInvalidMoveHorizontalOnly() {
        Pair<Integer, Integer> straightHorizontalMove = new Pair<>(4, 2);
        Assertions.assertFalse(knightMovement.isValid(CENTER, straightHorizontalMove));
    }

    @Test
    void testInvalidMoveDiagonalShort() {
        Pair<Integer, Integer> diagonalMove = new Pair<>(3, 3);
        Assertions.assertFalse(knightMovement.isValid(CENTER, diagonalMove));
    }
}
