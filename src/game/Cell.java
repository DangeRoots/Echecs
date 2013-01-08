package game;

import pieces.Piece;

public class Cell {

	private Piece pieceInCell;
	
	public Cell(Piece inPiece) {
		pieceInCell = inPiece;
	}
	
	public Piece getPiece() throws NullPointerException { 
		// La NullPointerException permet de détecter une cellule vide
		return pieceInCell;
	}
}
