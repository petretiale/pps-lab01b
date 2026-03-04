package it.unibo.pps.e2;

public class KnightMoveValidator implements MoveValidator{
    @Override
    public boolean isValid(Pair<Integer, Integer> from, Pair<Integer, Integer> to) {
        int x = Math.abs(to.getX() - from.getX());
        int y = Math.abs(to.getY() - from.getY());
        return x!=0 && y!=0 && x+y==3;
    }
}
