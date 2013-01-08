package pieces;

import game.Plate;

import java.util.ArrayList;

public abstract class Piece {

	private String m_color;
	private int m_row;
	private int m_column;
	
	abstract ArrayList<Piece> accessibleCells(Plate plate);

	
	public boolean isOnScreen() {
		if(m_row > 0 && m_row <= 7 && m_column > 0 && m_column <= 7){
			return true;
		}
		else {
			return false;
		}
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


	
}
