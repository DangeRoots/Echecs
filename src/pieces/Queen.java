package pieces;

import game.Plate;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Queen extends Piece {

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
			Icon img = new ImageIcon("./img/wqueen.png");
			return img;
		}
		else {
			Icon img = new ImageIcon("./img/bqueen.png");
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
