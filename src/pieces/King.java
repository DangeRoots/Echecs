package pieces;

import game.Cell;
import game.Plate;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class King extends Piece{

	@Override
	ArrayList<Piece> accessibleCells(Plate plate) {

		ArrayList<Piece> accessibles = new ArrayList();
		// Cas d'une piece morte
		if(!this.isOnScreen()){
			return null;
		}
		return null;
	}

	@Override
	boolean canMove(Piece piece) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Icon getIcon() {
		if (this.getColor()=="w")
		{
			Icon img = new ImageIcon("./img/wking.png");
			return img;
		}
		else {
			Icon img = new ImageIcon("./img/bking.png");
			return img;
		}
	}

	@Override
	boolean move(Piece piece) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

}
