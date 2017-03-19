package Pieces;

import java.awt.Point;

import BoardComponents.Board;

public class Rook extends Piece{
	
	public Rook(int x, int y, boolean isBlack){
		super(x, y, isBlack, "rook.png");
	}

	@Override
	public boolean move(Point newPosition) {
		if(newPosition.y == position.y){
			int smallerX, biggerX;
			if(newPosition.x > position.x){
				smallerX = position.x;
				biggerX = newPosition.x;
			}else{
				smallerX = newPosition.x;
				biggerX = position.x;
			}
			
			//checks nothing is blocking the move
			while(++smallerX < biggerX){
				if(Board.pieces[smallerX][position.y] != null)
					return false;
			}
			if(Board.pieces[newPosition.x][newPosition.y] == null || Board.pieces[newPosition.x][newPosition.y].isBlack != isBlack){
				finalizeMove(newPosition);
				return true;
			}
		}else if(newPosition.x == position.x){
			int smallerY, biggerY;
			if(newPosition.y > position.y){
				smallerY = position.y;
				biggerY = newPosition.y;
			}else{
				smallerY = newPosition.y;
				biggerY = position.y;
			}
			
			//checks nothing is blocking the move
			while(++smallerY < biggerY){
				if(Board.pieces[position.x][smallerY] != null)
					return false;
			}
			if(Board.pieces[newPosition.x][newPosition.y] == null || Board.pieces[newPosition.x][newPosition.y].isBlack != isBlack){
				finalizeMove(newPosition);
				return true;
			}
		}
		return false;
	}

}
