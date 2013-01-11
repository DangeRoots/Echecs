package game;

import pieces.Empty;
import pieces.Piece;

public class Plate {
	
	Piece[][] plate;
	private int m_boardSize;
	private int m_height = 8;
	
	/**
	 * Constructeur par défaut. Instancie un plateau de 8*8 (jeu classique)
	 */
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

	/**
	 * Constructeur avec paramètre. Instancie un plateau de 10*8 (jeu variante capablanca)
	 * @param String variante, la variante souhaitée
	 */
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

	/**
	 * Retourne la largeur du plateau
	 * @return int, la largeur du plateau
	 */
	public int getBoardSize() {
		 return m_boardSize;
	}

	/**
	 * Retourne la hauteur du plateau
	 * @return int, la hauteur du plateau
	 */
	public int getHeight() {
		return m_height;
	}
	
	/**
	 * Retourne toutes les pieces contenues dans plateau
	 * @return Piece[][], tableau à deux dimensions
	 */
	public Piece [][] getPlate() {
		return plate;
	}
	
	/**
	 * Retourne la piece du plateau aux coordonnées données
	 * @param int x, la coordonnée x
	 * @param int y, la coordonnée y
	 * @return Piece, la piece du plateau à l'endroit x, y
	 */
	public Piece getPiece(int x,int y)
	{
		return plate[y][x];
	}
	
	/**
	 * Place une pièce aux coordonnées données
	 * @param Piece, la piece que l'on veut placer
	 * @param int x, la coordonnée x
	 * @param int y, la coordonnée y
	 */
	public void setPiece(Piece piece, int x, int y) {
		piece.setPosition(y, x);
		plate[y][x]= piece;
	}
}
