package game;

import pieces.*;

import java.util.List;


public class Board {
    private List<Piece> activePieces;
    boolean isBlackMove, gameOver;

    public boolean hasPromotablePiece(){
        //todo
        return false;
    }

    public void promotePiece(){
        //todo
    }

    public void startGame(){
        //Black pieces
        for(int i = 0; i < 8; i++){
            activePieces.add(new Pawn(i, 1, true));
        }
        activePieces.add(new Rook(0, 0, true));
        activePieces.add(new Rook(7, 0, true));
        activePieces.add(new Knight(1, 0, true));
        activePieces.add(new Knight(6, 0, true));
        activePieces.add(new Bishop(2, 0, true));
        activePieces.add(new Bishop(5, 0, true));
        activePieces.add(new Queen(3, 0, true));
        activePieces.add(new King(4, 0, true));

        //White pieces
        for(int i = 0; i < 8; i++){
            activePieces.add(new Pawn(i, 6, false));
        }
        activePieces.add(new Rook(0, 7, false));
        activePieces.add(new Rook(7, 7, false));
        activePieces.add(new Knight(1, 7, false));
        activePieces.add(new Knight(6, 7, false));
        activePieces.add(new Bishop(2, 7, false));
        activePieces.add(new Bishop(5, 7, false));
        activePieces.add(new Queen(4, 7, false));
        activePieces.add(new King(3, 7, false));

    }

}
