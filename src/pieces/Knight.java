package pieces;

import game.Plate;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Knight extends Piece {

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
			// 1 Sud 2 Est
			if (x < plate.getHeight()-1 && y < plate.getBoardSize()-2 && plate.getPiece(x+1, y+2).getColor()!=this.getColor())
				accessibles.add(plate.getPiece(x+1, y+2));
			// 2 Sud 1 Est
			if (x < plate.getHeight()-2 && y < plate.getBoardSize()-1 && plate.getPiece(x+2, y+1).getColor()!=this.getColor())
				accessibles.add(plate.getPiece(x+2, y+1));
			// 1 Sud 2 Ouest
			if (x < plate.getHeight()-1 && y > 1 && plate.getPiece(x+1, y-2).getColor()!=this.getColor())
				accessibles.add(plate.getPiece(x+1, y-2));
			// 2 Sud 1 Ouest
			if (x < plate.getHeight()-2 && y > 0 && plate.getPiece(x+2, y-1).getColor()!=this.getColor())
				accessibles.add(plate.getPiece(x+2, y-1));
			// 1 Nord 2 Est
			if (x > 0 && y < plate.getBoardSize()-2 && plate.getPiece(x-1, y+2).getColor()!=this.getColor())
				accessibles.add(plate.getPiece(x-1, y+2));
			// 2 Nord 1 Est
			if (x > 1 && y < plate.getBoardSize()-1 && plate.getPiece(x-2, y+1).getColor()!=this.getColor())
				accessibles.add(plate.getPiece(x-2, y+1));
			// 1 Nord 2 Ouest
			if (x > 0 && y > 1 && plate.getPiece(x-1, y-2).getColor()!=this.getColor())
				accessibles.add(plate.getPiece(x-1, y-2));
			// 2 Nord 1 Ouest
			if (x > 1 && y > 0 && plate.getPiece(x-2, y-1).getColor()!=this.getColor())
				accessibles.add(plate.getPiece(x-2, y-1));	
			return accessibles;
		}
	}

	@Override
	public Icon getIcon() {
		if (this.getColor()=="w")
		{
			Icon img = new ImageIcon(getClass().getClassLoader().getResource("wknight.png"));
			return img;
		}
		else {
			Icon img = new ImageIcon(getClass().getClassLoader().getResource("bknight.png"));
			return img;
		}
	}

	@Override
	public void show() {
		System.out.println("Je suis cavalier ! et ma position est : " + getRow() + " " + getColumn());
	}

}
