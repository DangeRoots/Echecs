package pieces;

import game.Plate;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Empty extends Piece {

	@Override
	public ArrayList<Piece> accessibleCells(Plate plate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Icon getIcon() {
		Icon img = new ImageIcon("");
		return img;
	}

	@Override
	public void show() {
		System.out.println("Je suis vide ! et ma position est : " + getRow() + " " + getColumn());
	}

}
