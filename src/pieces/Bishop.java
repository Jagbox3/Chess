package Pieces;

import java.awt.Point;

import BoardComponents.Board;

public class Bishop extends Piece{

	public Bishop(int x, int y, boolean isBlack){
		super(x, y, isBlack, "bishop.png");
	}

	@Override
	public boolean move(Point newPosition) {
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
