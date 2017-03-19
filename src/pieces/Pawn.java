package Pieces;

import java.awt.Point;
import BoardComponents.*;

public class Pawn extends Piece{

	public Pawn(int x, int y, boolean isBlack) {
		super(x, y, isBlack, "Pawn.png");
	}
	
	@Override
	public boolean move(Point newPosition){
	
		if(isBlack && position.y == 1 && newPosition.y - 2 == position.y){
			if(newPosition.x == position.x && Board.pieces[newPosition.x][newPosition.y] == null){
				finalizeMove(newPosition);
				return true;
			}
		}else if(!isBlack && position.y == 6 && newPosition.y + 2 == position.y){
			if(newPosition.x == position.x && Board.pieces[newPosition.x][newPosition.y] == null){
				finalizeMove(newPosition);
				return true;
			}
		}
		
		if(isBlack && newPosition.y - 1 == position.y){
			if(newPosition.x == position.x && Board.pieces[newPosition.x][newPosition.y] == null){
				finalizeMove(newPosition);
				return true;
			}else if( (newPosition.x + 1 == position.x || newPosition.x - 1 == position.x) &&
					Board.pieces[newPosition.x][newPosition.y] != null && !Board.pieces[newPosition.x][newPosition.y].isBlack ){
				finalizeMove(newPosition);
				return true;
			}
		}else if(!isBlack && newPosition.y + 1 == position.y){
			if(newPosition.x == position.x && Board.pieces[newPosition.x][newPosition.y] == null){
				finalizeMove(newPosition);
				return true;
			}else if( (newPosition.x + 1 == position.x || newPosition.x - 1 == position.x) &&
					   Board.pieces[newPosition.x][newPosition.y] != null && Board.pieces[newPosition.x][newPosition.y].isBlack ){
				finalizeMove(newPosition);
				return true;
			}
		}
		
		return false;
	}
}
