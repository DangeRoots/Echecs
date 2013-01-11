package pieces;

import game.Plate;

import java.util.ArrayList;

import javax.swing.Icon;

public abstract class Piece {

	private String m_color;
	private int m_row;
	private int m_column;

	/**
	 * Retourne la liste des cases accessibles 
	 * @param plate, le plateau 
	 * @return ArrayList<Piece>, la liste de cases accessibles
	 */
	abstract public ArrayList<Piece> accessibleCells(Plate plate);

	/**
	 * Necessaire pour le debuggage console
	 */
	abstract public void show();

	/**
	 * Retourne l'icone de la piece
	 * @return Icon, l'icone de la piece
	 */
	abstract public Icon getIcon();

	/**
	 * Retourne un booleen afin de savoir si la piece est sur le plateau
	 * @param plate, le plateau
	 * @return booleen, true si la piece est sur le plateau, false sinon
	 */
	public boolean isOnScreen(Plate plate) {
		return (m_row >= 0 && m_row <= plate.getBoardSize()-1 && m_column >= 0 && m_column <= plate.getBoardSize()-1);
	}

	/**
	 * Constructeur par défaut
	 * Créer une piece vide (empty)
	 */
	public Piece() {
		m_color = "e";
		m_row = m_column = -1;
	}

	/**
	 * Constructeur avec parametres
	 * @param color , String, la couleur souhaité
	 * @param row   , int   , la coordonnée ligne
	 * @param column, int   , la coordonnée colonne
	 * @brief color : w = white, b = black, e=empty 
	 */
	public Piece(String color, int row, int column){
		this.m_color = color;
		this.m_row = row;
		this.m_column = column;
	}

	/**
	 * Retourne la couleur de la piece
	 * @return m_color, String
	 */
	public String getColor() {
		return m_color;
	}

	/**
	 * Definit la couleur de la piece
	 * @param color, String, la couleur souhaité
	 */
	public void setColor(String color) {
		this.m_color = color;
	}

	/**
	 * Retourne la coordonnée ligne 
	 * @return m_row, int, la coordonnée ligne
	 */
	public int getRow() {
		return m_row;
	}

	/**
	 * Definit la coordonnée ligne de la piece
	 * @param row, la coordonnée ligne souhaitée
	 */
	public void setRow(int row) {
		this.m_row = row;
	}

	/**
	 * Retourne la coordonnée colonne
	 * @return m_column, int, la coordonnée colonne
	 */
	public int getColumn() {
		return m_column;
	}

	/**
	 * Definit la coordonnée colonne de la piece
	 * @param column, la coordonnée ligne souhaitée
	 */
	public void setColumn(int column) {
		this.m_column = column;
	}

	/**
	 * Retourne la position de la piece
	 * @return int[], un tableau de coordonnée
	 */
	public int[] getPosition(){
		int[] position = new int[2];
		position[0]=this.m_row;
		position[1]=this.m_column;
		return position;
	}
	
	/**
	 * Definit la position de la piece
	 * @param col, int, la colonne souhaitée
	 * @param row, int, la ligne souhaitée
	 */
	public void setPosition(int col, int row) {
		m_row=row;
		m_column=col;
	}
}
