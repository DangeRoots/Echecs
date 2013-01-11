package pieces;

import game.Plate;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

// bishop and a knight.
public class Archbishop extends Piece {

	@Override
	public ArrayList<Piece> accessibleCells(Plate plate) {
		ArrayList<Piece> accessibles = new ArrayList<Piece>();
		// Cas d'une piece morte
		if(!this.isOnScreen(plate)){
			return null;
		}
		else{

			Knight knight = new Knight();
			knight.setColor(this.getColor());
			knight.setPosition(this.getColumn(),this.getRow());
			ArrayList<Piece> accessRook = new ArrayList<Piece>();
			accessRook = knight.accessibleCells(plate);
			for (int i=0;i<accessRook.size();i++)
				accessibles.add(accessRook.get(i));
			Bishop bishop = new Bishop();
			ArrayList<Piece> accessBishop = new ArrayList<Piece>();
			bishop.setColor(this.getColor());
			bishop.setPosition(this.getColumn(), this.getRow());
			accessBishop=bishop.accessibleCells(plate);
			for (int i = 0; i < accessBishop.size();i++)
				accessibles.add(accessBishop.get(i));
			return accessibles;
		}
	}

	@Override
	public Icon getIcon() {
		if (this.getColor()=="w")
		{
			Icon img = new ImageIcon(getClass().getClassLoader().getResource("warchbishop.png"));
			return img;
		}
		else {
			Icon img = new ImageIcon(getClass().getClassLoader().getResource("barchbishop.png"));
			return img;
		}
	}

	@Override
	public void show() {
		System.out.println("Je suis une princesse ! et ma position est : " + getRow() + " " + getColumn());	
	}

}
