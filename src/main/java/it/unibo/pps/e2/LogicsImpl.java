package it.unibo.pps.e2;

public class LogicsImpl implements Logics {

    private Board board;
    private MovementStrategy moveValidator;
	 
    public LogicsImpl(int size) {
        this.board = new Board(size);
        this.moveValidator = new KnightMovementStrategy();
    }

    LogicsImpl(Board board) {
        this.board = board;
        this.moveValidator = new KnightMovementStrategy();;
    }

	@Override
	public boolean hit(int row, int col) {
		checkBounds(row, col);
        Pair<Integer, Integer> newPosition = new Pair<>(row, col);
		if (moveValidator.isValid(board.getKnightPosition(), newPosition)) {
            board.moveKnight(row, col);
			return board.hasPawn(row, col);
		}
		return false;
	}

    private void checkBounds(int row, int col) {
        if (row < 0 || col < 0 || row >= board.getSize() || col >= board.getSize()) {
            throw new IndexOutOfBoundsException();
        }
    }

	@Override
	public boolean hasKnight(int row, int col) {
		return board.hasKnight(row, col);
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return board.hasPawn(row,col);
	}
}
