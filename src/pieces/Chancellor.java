package pieces;

import game.Plate;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;


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
	public Icon getIcon() {
		if (this.getColor()=="w")
		{
			Icon img = new ImageIcon(getClass().getClassLoader().getResource("wchancellor.png"));
			return img;
		}
		else {
			Icon img = new ImageIcon(getClass().getClassLoader().getResource("bchancellor.png"));
			return img;
		}
	}

	@Override
	public void show() {
		System.out.println("Je suis une impératrice ! et ma position est : " + getRow() + " " + getColumn());	
	}

}
