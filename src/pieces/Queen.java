package Pieces;

import java.awt.Point;

import BoardComponents.Board;

public class Queen extends Piece{
	
	public Queen(int x, int y, boolean isBlack)
	{
		super(x, y, isBlack, "queen.png");
	}

	@Override
	public boolean move(Point newPosition) {
		// TODO Auto-generated method stub
		if(moveLikeRook(newPosition) || moveLikeBishop(newPosition))
			return true;
		return false;
	}
	
	//literally copy pasted from rook class :)
	private boolean moveLikeRook(Point newPosition){
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
	
	//literally copy pasted from the bishop class :)
	private boolean moveLikeBishop(Point newPosition){
		if(Math.abs(newPosition.x - position.x) == Math.abs(newPosition.y - position.y)){
			int xSign = 1, ySign = 1;
			if(newPosition.x < position.x)
				xSign = -1;
			if(newPosition.y < position.y)
				ySign = -1;
			for(int i = 1; i < Math.abs(position.x - newPosition.x); i++){
				if(Board.pieces[position.x + i * xSign][position.y + i * ySign] != null)
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
