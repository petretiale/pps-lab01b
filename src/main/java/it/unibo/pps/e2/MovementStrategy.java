package it.unibo.pps.e2;

public interface MovementStrategy {
    boolean isValid(Pair<Integer, Integer> from, Pair<Integer, Integer> to);
}
