package pieces;

import game.Plate;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Queen extends Piece {

	@Override
	ArrayList<Piece> accessibleCells(Plate plate) {
		ArrayList<Piece> accessibles = new ArrayList<Piece>();
		// Cas d'une piece morte
		if(!this.isOnScreen()){
			return null;
		}
		else{
			Rook rook = new Rook();
			ArrayList<Piece> accessRook = new ArrayList<Piece>();
			accessRook=rook.accessibleCells(plate);
			for (int i = 0; i < accessRook.size();i++)
				accessibles.add(accessRook.get(i));
			Bishop bishop = new Bishop();
			ArrayList<Piece> accessBishop = new ArrayList<Piece>();
			accessBishop=bishop.accessibleCells(plate);
			for (int i = 0; i < accessBishop.size();i++)
				accessibles.add(accessBishop.get(i));
			return accessibles;
		}
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
