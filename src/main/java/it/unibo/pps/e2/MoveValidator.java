package it.unibo.pps.e2;

public interface MoveValidator {
    boolean isValid(Pair<Integer, Integer> from, Pair<Integer, Integer> to);
}
