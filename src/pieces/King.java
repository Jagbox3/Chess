package pieces;

/**
 * Created by Jeff on 1/27/2017.
 */
public class King extends Piece{

    private boolean inCheck = false;

    public King(int x, int y, boolean isBlack) {
        super(x, y, isBlack);
    }

    @Override
    public boolean isValidMove(int toX, int toY) {
        if(!super.isValidMove(toX, toY))
            return false;
        if(Math.sqrt(Math.pow(toX - getX(), 2) + Math.pow(toY - getY(), 2)) <= Math.sqrt(2))
            return true;
        return false;
    }
}
