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
	
<<<<<<< HEAD
=======
	public void setPiece(Piece piece, int x, int y){
		piece.setRow(x);
		piece.setColumn(y);
	}
>>>>>>> 37d10e502f83b9fba32a9a7fe0657a8d711fa7fb
}
