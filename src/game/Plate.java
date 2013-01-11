package game;

import pieces.Empty;
import pieces.Piece;

public class Plate {
	
	Piece[][] plate;
	private int m_boardSize;
	private int m_height = 8;
	
	public Plate() {
		m_boardSize = 8;
		plate = new Piece[m_boardSize][m_height];
		for (int i = 0; i < m_boardSize; i++)
		{
			for (int j = 0; j < m_height; j++)
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
			m_boardSize = 10;
			plate = new Piece[m_boardSize][m_height];
			for (int i = 0; i < m_boardSize; i++)
			{
				for (int j = 0; j < m_height; j++)
				{
					Empty pic = new Empty();
					pic.setPosition(i,j);
					plate[i][j] = pic;
				}
			}
			
		}
	}

	public int getBoardSize() {
		 return m_boardSize;
	}
	
	public int getHeight() {
		return m_height;
	}
	
	public Piece [][] getPlate() {
		return plate;
	}
	
	public Piece getPiece(int x,int y)
	{
		return plate[y][x];
	}
	
	public void setPiece(Piece piece, int x, int y) {
		piece.setPosition(y, x);
		plate[y][x]= piece;
	}
}
