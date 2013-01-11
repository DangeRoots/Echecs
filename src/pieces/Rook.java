package pieces;

import game.Plate;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Rook extends Piece {

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

			//Haut
			for (int i = x+1; i < plate.getHeight(); i++)
			{
				if (plate.getPiece(i, y).getColor()==this.getColor())
					i = plate.getHeight() +1;
				else
				{
					accessibles.add(plate.getPiece(i, y));
					if (plate.getPiece(i, y).getColor()!="e")
						i = plate.getHeight() +1;
				}
			}
			//Bas
			for (int i = x-1; i > -1;i--)
			{
				if (plate.getPiece(i, y).getColor()==this.getColor())
					i = -1;
				else
				{
					accessibles.add(plate.getPiece(i, y));
					if (plate.getPiece(i, y).getColor()!="e")
						i = -1;
				}
			}
			//Droite
			for (int i = y+1; i < plate.getBoardSize();i++)
			{
				if (plate.getPiece(x, i).getColor()==this.getColor())
					i = plate.getBoardSize()+1;
				else
				{
					accessibles.add(plate.getPiece(x, i));
					if (plate.getPiece(x, i).getColor()!="e")
						i = plate.getBoardSize() + 1;
				}
			}
			//Gauche
			for (int i = y-1; i > -1;i--)
			{
				if (plate.getPiece(x, i).getColor()==this.getColor())
					i = -1;
				else
				{
					accessibles.add(plate.getPiece(x, i));
					if (plate.getPiece(x, i).getColor()!="e")
						i = -1;
				}
			}
			return accessibles;
		}
	}

	@Override
	public Icon getIcon() {
		if (this.getColor()=="w")
		{
			Icon img = new ImageIcon(getClass().getClassLoader().getResource("wrook.png"));
			return img;
		}
		else {
			Icon img = new ImageIcon(getClass().getClassLoader().getResource("brook.png"));
			return img;
		}
	}

	@Override
	public void show() {
		System.out.println("Je suis une tour ! et ma position est : "+getRow() + " " + getColumn());
	}

}
