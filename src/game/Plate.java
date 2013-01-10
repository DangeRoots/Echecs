package game;

import pieces.Empty;
import pieces.Piece;

public class Plate {
	
	Piece[][] plate;
	private int boardSize;
	
	public Plate() {
		boardSize = 8;
		plate = new Piece[8][8];
		for (int i=0;i<8;i++)
		{
			for (int j=0;j<8;j++)
			{
				Empty pic = new Empty();
				pic.setPosition(i,j);
				plate[i][j] = pic;
			}
		}
	}
	
	public Plate(String variante) {
		if (variante == "capablanca")
		{
			boardSize = 10;
			plate = new Piece[10][8];
			for (int i=0;i<10;i++)
			{
				for (int j=0;j<8;j++)
				{
					Empty pic = new Empty();
					pic.setPosition(i,j);
					plate[i][j] = pic;
				}
			}
			
		}
	}

	public int getBoardSize() {
		 return boardSize;
	}
	
	public Piece [][] getPlate() {
		return plate;
	}
	
	public Piece getPiece(int x,int y)
	{
		return plate[y][x];
	}
	
	public void setPiece(Piece piece, int x, int y){
		/*piece.setRow(y);
		piece.setColumn(x);*/
		piece.setPosition(y, x);
		plate[y][x]= piece;
	}
}
