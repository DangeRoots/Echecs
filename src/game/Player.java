package game;

import pieces.Piece;

public class Player {
	
	private String m_name;
	private String m_color;
	// Stockage des pièces prises par le joueur
	private Piece[] m_pieces_taken;
	
	public Player(String mName, String mColor) {
		super();
		m_name = mName;
		m_color = mColor;
		m_pieces_taken = new Piece[16];
	}

	public Piece[] getM_lost_pieces() {
		return m_pieces_taken;
	}


	public void setM_lost_pieces(Piece[] mLostPieces) {
		m_pieces_taken = mLostPieces;
	}


	public String getM_name() {
		return m_name;
	}

	public void setM_name(String mName) {
		m_name = mName;
	}

	public String getM_color() {
		return m_color;
	}

	public void setM_color(String mColor) {
		m_color = mColor;
	}
	
	
}
