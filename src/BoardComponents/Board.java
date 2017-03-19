package BoardComponents;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import Pieces.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Board extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2578856952078531329L;
	public static BoardSquare[][] squares;
	public static Piece[][] pieces;
	public static boolean whitesTurn = true;
	public static String gameOver = "";
	int n;
	
	public Board(int n){
		squares = new BoardSquare[n][n];
		pieces = new Piece[n][n];
		this.n = n;
		this.setTitle("Chess");
		this.setPreferredSize(new Dimension(800,800));
		this.setLayout(new GridLayout(n,n));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createBoard();
		this.pack();
		this.setVisible(true);
		
		
		while(gameOver == ""){
			BufferedImage buffer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
			this.update(buffer.getGraphics());
			this.getGraphics().drawImage(buffer,0,0, this);
		}
		//final draw call so you can see that the King has been taken
		BufferedImage buffer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		this.update(buffer.getGraphics());
		this.getGraphics().drawImage(buffer,0,0, this);
		
		if(gameOver == "white")
			JOptionPane.showMessageDialog(this, "Congratulations, Black Wins!");
		else
			JOptionPane.showMessageDialog(this, "Congratulations, White Wins!");
	}
	
	void createBoard(){
		boolean counter = false;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				//creates the board and makes the squares black and white
				squares[j][i] = new BoardSquare(j, i, 50,50);
				if(counter)
					squares[j][i].background = Color.DARK_GRAY;
				else
					squares[j][i].background = Color.LIGHT_GRAY;
				this.add(squares[j][i]);
				counter = !counter;
			}
			counter = !counter;
		}
		
		//setup pieces
		boolean isBlack = true;
		for(int y = 0; y < 2; y++){
			//pawns
			for(int x = 0; x < n; x++){
				pieces[x][y * 5 + 1] = new Pawn(x, y * 5 + 1, isBlack);
				squares[x][y * 5 + 1].occupyingPiece = pieces[x][y * 5 + 1];				
			}
			for(int x = 0; x < 2; x++){
				//Rooks
				pieces[x*7][y*7] = new Rook(x*7, y*7, isBlack);
				squares[x*7][y*7].occupyingPiece = pieces[x*7][y*7];
				
				//Knights
				pieces[1 + 5*x][y*7] = new Knight(1 + 5*x, y*7, isBlack);
				squares[1 + 5*x][y*7].occupyingPiece = pieces[1 + 5*x][y*7];
			
				//Bishops
				pieces[2 + 3*x][y*7] = new Bishop(2 + 3*x, y*7, isBlack);
				squares[2 + 3*x][y*7].occupyingPiece = pieces[2 + 3*x][y*7];
				
				//Queens
				pieces[3][y*7] = new Queen(3, y*7, isBlack);
				squares[3][y*7].occupyingPiece = pieces[3][y*7];
				
				//Kings
				pieces[4][y*7] = new King(4, y*7, isBlack);
				squares[4][y*7].occupyingPiece = pieces[4][y*7];
			}
			
			isBlack = !isBlack;
		}
		
	}	
}
