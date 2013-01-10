package pieces;

import game.Plate;

import java.util.ArrayList;

import javax.swing.Icon;


// rook and a knight
public class Chancellor extends Piece {

	@Override
	public ArrayList<Piece> accessibleCells(Plate plate) {
		ArrayList<Piece> accessibles = new ArrayList<Piece>();
		// Cas d'une piece morte
		if(!this.isOnScreen(plate)){
			return null;
		}
		else{

			Rook rook = new Rook();
			rook.setColor(this.getColor());
			rook.setPosition(this.getColumn(),this.getRow());
			ArrayList<Piece> accessRook = new ArrayList<Piece>();
			accessRook = rook.accessibleCells(plate);
			for (int i=0;i<accessRook.size();i++)
				accessibles.add(accessRook.get(i));
			Knight knight = new Knight();
			ArrayList<Piece> accessBishop = new ArrayList<Piece>();
			knight.setColor(this.getColor());
			knight.setPosition(this.getColumn(), this.getRow());
			accessBishop=knight.accessibleCells(plate);
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
		// TODO Auto-generated method stub
		return null;
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
