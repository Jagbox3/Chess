package BoardComponents;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Pieces.Piece;

public class BoardSquare extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4431097581546330866L;
	//TODO Add Image Support
	boolean isInside = false;
	boolean isClicked = false; 
	public Color background;
	public Piece occupyingPiece = null;
	static Piece selectedPiece = null;
	Point location;
	
	public BoardSquare(int x, int y, int width, int height){
		this.setSize(new Dimension(width, height));
		this.addMouseListener(this);
		location = new Point(x, y);
	}
	
	@Override
	public void paint(Graphics g){
		BufferedImage image = getImage();
		if(selectedPiece != null && occupyingPiece != null && selectedPiece == occupyingPiece)
			g.setColor(Color.YELLOW);
		else
			g.setColor(background);
		g.fillRect(0,0, this.getWidth(), this.getHeight());
		g.drawImage(image,0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	public BufferedImage getImage(){
		String path = System.getProperty("user.dir");
		if(occupyingPiece == null)
			path += "\\res\\blank.png";
		else
			path += "\\res\\" + occupyingPiece.pieceName;
		try {
			BufferedImage toReturn = ImageIO.read(new File(path));
			return toReturn;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new BufferedImage(5,5, BufferedImage.TYPE_INT_ARGB);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		isInside = true;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		isInside = false;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Clicked Board Square " + location.x + "," + location.y);
		if(isInside && occupyingPiece != null){
			if(selectedPiece == null && Board.whitesTurn != occupyingPiece.isBlack){
				selectedPiece = occupyingPiece;
			}else if(selectedPiece != null){
				if(selectedPiece.move(location))
					Board.whitesTurn = !Board.whitesTurn;
				selectedPiece = null;
			}
		}else if(isInside){
			if(selectedPiece != null){
				if(selectedPiece.move(location))
					Board.whitesTurn = !Board.whitesTurn;
				selectedPiece = null;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

}
