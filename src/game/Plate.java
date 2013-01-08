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
}
