package pieces;

import game.Plate;

import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class King extends Piece{

	@Override
	public ArrayList<Piece> accessibleCells(Plate plate) {
		ArrayList<Piece> accessibles = new ArrayList<Piece>();
		// Cas d'une piece morte
		if(!this.isOnScreen(plate)){
			return null;
		}
		else{
			int x = this.getRow();
			int y = this.getColumn();
			//Sud
			if (x < plate.getHeight()-1 && plate.getPiece(x+1, y).getColor()!=this.getColor())
				accessibles.add(plate.getPiece(x+1, y));
			//Nord
			if (x > 0 && plate.getPiece(x-1, y).getColor()!= this.getColor())
				accessibles.add(plate.getPiece(x-1, y));
			//Est
			if (y < plate.getBoardSize()-1 && plate.getPiece(x, y+1).getColor()!=this.getColor())
				accessibles.add(plate.getPiece(x, y+1));
			//			//Ouest
			if (y > 0 && plate.getPiece(x, y-1).getColor()!=this.getColor())
				accessibles.add(plate.getPiece(x, y-1));
			//			//Sud Est
			if (x < plate.getHeight()-1 && y < plate.getBoardSize()-1 && plate.getPiece(x+1, y+1).getColor()!=this.getColor())
				accessibles.add(plate.getPiece(x+1, y+1));
			//			//Sud Ouest
			if (x < plate.getHeight()-1 && y > 0 && plate.getPiece(x+1, y-1).getColor()!=this.getColor())
				accessibles.add(plate.getPiece(x+1, y-1));
			//			//Nord Est
			if (x > 0 && y < plate.getBoardSize()-1 && plate.getPiece(x-1, y+1).getColor()!=this.getColor())
				accessibles.add(plate.getPiece(x-1, y+1));
			//			//Nord Ouest
			if (x > 0 && y > 0 && plate.getPiece(x-1, y-1).getColor()!=this.getColor())
				accessibles.add(plate.getPiece(x-1, y-1));			
			return accessibles;
		}
	}

	@Override
	public Icon getIcon() {
		if (this.getColor()=="w")
		{
			Icon img = new ImageIcon(getClass().getClassLoader().getResource("wking.png"));
			return img;
		}
		else {
			Icon img = new ImageIcon(getClass().getClassLoader().getResource("bking.png"));
			return img;
		}
	}

	@Override
	public void show() {
		System.out.println("Je suis un roi ! et ma position est : " + getRow() + " " + getColumn());		
	}

}
