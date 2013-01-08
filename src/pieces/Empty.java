package pieces;

import game.Plate;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Empty extends Piece {

	@Override
	ArrayList<Piece> accessibleCells(Plate plate) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	boolean canMove(Piece piece) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean move(Piece piece) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void show() {
		System.out.println("Je suis un empty ! et ma position est : " + getRow() + " " + getColumn());
	}


	@Override
	public Icon getIcon() {
		Icon img = new ImageIcon("");
		return img;
	}

}
