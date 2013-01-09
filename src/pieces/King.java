package pieces;

import game.Cell;
import game.Plate;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class King extends Piece{

	@Override
	public ArrayList<Piece> accessibleCells(Plate plate) {
		ArrayList<Piece> accessibles = new ArrayList<Piece>();
		// Cas d'une piece morte
		if(!this.isOnScreen()){
			return null;
		}
		else{
			int x = this.getRow();
			int y = this.getColumn();
			System.out.println(" x : " + x + " y : "+y);
			//Sud
			if (x < 7 && plate.getPiece(y, x+1).getColor()!=this.getColor())
			{
				System.out.println(plate.getPiece(y, x+1).getRow());
				accessibles.add(plate.getPiece(y, x+1));
			}
//			//Nord
//			if (x > 0 && plate.getPiece(y, x-1).getColor()!= this.getColor())
//				accessibles.add(plate.getPiece(y, x-1));
//			//Droite
//			if (y < 7 && plate.getPiece(x, y+1).getColor()!=this.getColor())
//				accessibles.add(plate.getPiece(x, y+1));
//			//Gauche
//			if (y > 0 && plate.getPiece(x, y-1).getColor()!=this.getColor())
//				accessibles.add(plate.getPiece(x, y-1));
//			//Haut-Droite
//			if (x < 7 && y < 7 && plate.getPiece(x+1, y+1).getColor()!=this.getColor())
//				accessibles.add(plate.getPiece(x+1, y+1));
//			//Haut-Gauche
//			if (x < 7 && y > 0 && plate.getPiece(x+1, y-1).getColor()!=this.getColor())
//				accessibles.add(plate.getPiece(x+1, y-1));
//			//Bas-Droite
//			if (x > 0 && y < 7 && plate.getPiece(x-1, y+1).getColor()!=this.getColor())
//				accessibles.add(plate.getPiece(x-1, y+1));
//			//Bas-Gauche
//			if (x > 0 && y > 0 && plate.getPiece(x-1, y-1).getColor()!=this.getColor())
//				accessibles.add(plate.getPiece(x-1, y-1));			
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
		//System.out.println("Je suis un roi ! et ma position est : " + getRow() + " " + getColumn());		
	}

}
