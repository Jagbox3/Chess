package Pieces;

import java.awt.Point;

import BoardComponents.Board;

public class King extends Piece{
	public King(int x, int y, boolean isBlack){
		super(x,y,isBlack, "king.png");
	}

	@Override
	public boolean move(Point newPosition) {
		if(Math.abs(newPosition.x - position.x) <= 1 && Math.abs(newPosition.y - position.y) <= 1){
			if(Board.pieces[newPosition.x][newPosition.y] == null || Board.pieces[newPosition.x][newPosition.y].isBlack != isBlack){
				finalizeMove(newPosition);
				return true;
			}
		}
		return false;
	}
}
