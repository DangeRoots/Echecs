package pieces;

import game.Plate;

import java.util.ArrayList;

import javax.swing.Icon;

public abstract class Piece {

	private String m_color;
	private int m_row;
	private int m_column;
	
	abstract public ArrayList<Piece> accessibleCells(Plate plate);
	
	abstract public void show();
	
	abstract public Icon getIcon();


	public boolean isOnScreen(Plate plate) {
		return (m_row >= 0 && m_row <= plate.getBoardSize()-1 && m_column >= 0 && m_column <= plate.getBoardSize()-1);
	}
	
	abstract boolean move(Piece piece);
	
	abstract boolean canMove(Piece piece);
	
	public Piece() {
		m_color = "e";
		m_row = m_column = -1;
	}
	
	//color : w = white, b = black, e=empty
	public Piece(String color, int row, int column){
		this.m_color = color;
		this.m_row = row;
		this.m_column = column;
	}
	
	public String getColor() {
		return m_color;
	}

	public void setColor(String color) {
		this.m_color = color;
	}

	public int getRow() {
		return m_row;
	}

	public void setRow(int row) {
		this.m_row = row;
	}

	public int getColumn() {
		return m_column;
	}
	
	public void setColumn(int column) {
		this.m_column = column;
	}
	
	// Test 
	public int[] getPosition(){
		int[] position = new int[2];
		position[0]=this.m_row;
		position[1]=this.m_column;
		return position;
	}

	public void setPosition(int col, int row) {
		m_row=row;
		m_column=col;
	}
	
}
