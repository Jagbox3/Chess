package pieces;

/**
 * Created by Jeff on 1/27/2017.
 */
public abstract class Piece {

    private boolean taken = false, isBlack;
    private int x, y;

    public Piece(int x, int y, boolean isBlack){
        this.x = x;
        this.y = y;
        this.isBlack = isBlack;
    }

    public boolean isTaken(){
        return taken;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isValidMove(int toX, int toY){
        if(toX == x && toY == y){
            //can't move to the same place
            return false;
        }
        if(toX > 7 || toX < 0 || toY > 7 || toY < 0){
            //can't move off the game
            return false;
        }
        return true;
    }
}
