package it.unibo.pps.e2;

import java.util.Random;

public class Board {

    private final int size;
    private final Pair<Integer,Integer> pawn;
    private Pair<Integer,Integer> knight;
    private final Random random = new Random();

    public Board(int size) {
        this.size = size;
        this.pawn = randomEmptyPosition();
        this.knight = randomEmptyPosition();
    }

    Board(int size, Pair<Integer, Integer> knight, Pair<Integer, Integer> pawn) {
        this.size = size;
        this.pawn = pawn;
        this.knight = knight;
    }

    private final Pair<Integer,Integer> randomEmptyPosition(){
        Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
        // the recursive call below prevents clash with an existing pawn
        return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }

    public int getSize() {
        return this.size;
    }

    public void moveKnight(int row, int col) {
        this.knight = new Pair<>(row, col);
    }

    public Pair<Integer,Integer> getKnightPosition() {
        return this.knight;
    }

    public boolean hasKnight(int row, int col) {
        return this.knight.equals(new Pair<>(row,col));
    }

    public boolean hasPawn(int row, int col) {
        return this.pawn.equals(new Pair<>(row,col));
    }
}
