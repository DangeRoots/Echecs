package game;

import pieces.Piece;

public class Plate {
	
	Piece[][] plate;
	
	public Plate() {
		plate = new Piece[8][8];
	}
	
	public Piece [][] getPlate() {
		return plate;
	}
	
	public Piece getPiece(int x,int y)
	{
		return plate[x][y];
	}
	
	public void setPiece(Piece piece, int x, int y){
		piece.setRow(x);
		piece.setColumn(y);
	}
}
