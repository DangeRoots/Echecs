package game;

import pieces.Piece;

public class Player {
	
	private String m_name;
	private String m_color;
	// Stockage des pièces prises par le joueur
	private Piece[] m_pieces_taken;
	
	/**
	 * Constructeur de la classe
	 * @param mName, String, le nom du joueur
	 * @param mColor, String, la couleur du joueur
	 */
	public Player(String mName, String mColor) {
		super();
		m_name = mName;
		m_color = mColor;
		m_pieces_taken = new Piece[16];
	}
	
	/**
	 * Retourne les pieces prises par le joueur
	 * @return Piece[], un tableau contenant les pieces prises
	 */
	public Piece[] getM_lost_pieces() {
		return m_pieces_taken;
	}

	/**
	 * Range une piece dans la liste des pieces prises
	 * @param mLostPieces, la piece à ranger dans la liste
	 */
	public void setM_lost_pieces(Piece[] mLostPieces) {
		m_pieces_taken = mLostPieces;
	}

	/**
	 * Retourne le nom du joueur
	 * @return m_name, le nom du joueur
	 */
	public String getM_name() {
		return m_name;
	}

	/**
	 * Definit le nom du joueur
	 * @param mName, le nom souhaité
	 */
	public void setM_name(String mName) {
		m_name = mName;
	}

	/**
	 * Retourne la couleur du joueur
	 * @return m_color, String, la couleur du joueur 
	 */
	public String getM_color() {
		return m_color;
	}

	/**
	 * Definit la couleur du joueur
	 * @param mColor, String, la couleur souhaitée
	 */
	public void setM_color(String mColor) {
		m_color = mColor;
	}
}
