package pieces;

/**
 * Created by Jeff on 1/27/2017.
 */
public class Pawn extends Piece{

    private boolean firstMove = true;

    public Pawn(int x, int y, boolean isBlack) {
        super(x, y, isBlack);
    }

    @Override
    public boolean isValidMove(int toX, int toY) {
        if(!super.isValidMove(toX, toY))
            return false;
        if(firstMove && toX == getX() && Math.abs(toY - getY()) <= 2)
            return true;
        if(toX == getX() && Math.abs(toY - getY()) == 1)
            return true;
        return false;
    }
}
