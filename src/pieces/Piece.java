package Pieces;

import java.awt.Point;
import BoardComponents.*;

public abstract class Piece {

	public Point position;
	public String pieceName;
	public boolean isBlack;
	public Piece(int x, int y,boolean isBlack, String name){
		position = new Point(x,y);
		this.isBlack = isBlack;
		
		if(isBlack)
			pieceName = "black" + name;
		else
			pieceName = "white" + name;
	}
	
	public abstract boolean move(Point newPosition);
	
	//returns true if it can make the move	
	void finalizeMove(Point newPosition){		
		if(Board.pieces[newPosition.x][newPosition.y] != null && Board.pieces[newPosition.x][newPosition.y].pieceName.equals("blackking.png"))
			Board.gameOver = "black"; 
		else if(Board.pieces[newPosition.x][newPosition.y] != null && Board.pieces[newPosition.x][newPosition.y].pieceName.equals("whiteking.png"))
			Board.gameOver = "white";
		
		Board.pieces[position.x][position.y] = null;
		Board.squares[position.x][position.y].occupyingPiece = null;
		Board.pieces[newPosition.x][newPosition.y] = this;
		Board.squares[newPosition.x][newPosition.y].occupyingPiece = this;

		position = newPosition;
	}
	
	
}
