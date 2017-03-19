package Pieces;

import java.awt.Point;

import BoardComponents.Board;

public class Knight extends Piece{

	public Knight(int x, int y, boolean isBlack) {
		super(x, y, isBlack, "knight.png");
	}
	
	@Override
	public boolean move(Point newPosition){
		if(Board.pieces[newPosition.x][newPosition.y] == null || Board.pieces[newPosition.x][newPosition.y].isBlack != isBlack){
			if( (newPosition.x + 2 == position.x || newPosition.x - 2 == position.x) &&
				(newPosition.y + 1 == position.y || newPosition.y - 1 == position.y) ){
				finalizeMove(newPosition);
				return true;
			}else if( (newPosition.y + 2 == position.y || newPosition.y - 2 == position.y) &&
					(newPosition.x + 1 == position.x || newPosition.x - 1 == position.x) ){
				finalizeMove(newPosition);
				return true;
			}
		}	
		return false;
	}
}
