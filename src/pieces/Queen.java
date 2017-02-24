package pieces;

/**
 * Created by Jeff on 1/27/2017.
 */
public class Queen extends Piece {

    public Queen(int x, int y, boolean isBlack) {
        super(x, y, isBlack);
    }

    @Override
    public boolean isValidMove(int toX, int toY) {
        if(!super.isValidMove(toX, toY))
            return false;
        //diagonal
        if(toX - getX() == toY - getY())
            return true;
        //horizontal and vertical
        if(toX == getX() || toY == getY())
            return true;
        return false;
    }
}
