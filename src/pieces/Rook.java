package pieces;

public class Rook extends Piece{

    public Rook(int x, int y, boolean isBlack) {
        super(x, y, isBlack);
    }

    @Override
    public boolean isValidMove(int toX, int toY) {
        if(!super.isValidMove(toX, toY))
            return false;
        if(toX == getX() || toY == getY())
            return true;
        return false;
    }
}
