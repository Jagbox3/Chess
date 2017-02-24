package pieces;

/**
 * Created by Jeff on 1/27/2017.
 */
public class Bishop extends Piece{

    public Bishop(int x, int y, boolean isBlack) {
        super(x, y, isBlack);
    }

    @Override
    public boolean isValidMove(int toX, int toY) {
        if(!super.isValidMove(toX, toY))
            return false;
        if(toX - getX() == toY - getY())
            return true;
        return false;
    }
}
