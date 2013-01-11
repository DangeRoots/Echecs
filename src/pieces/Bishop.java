package pieces;

import game.Plate;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Bishop extends Piece {

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
			//Sud Est
			if (y < plate.getBoardSize()-1 && x < plate.getHeight()-1)
				for (int i = 1; i < plate.getHeight()-x; i++ )
				{
					if (x+i < plate.getHeight() && y+ i < plate.getBoardSize())
					{
						if (plate.getPiece(x+i,y+i).getColor()==this.getColor())
							i = plate.getBoardSize() + 1;
						else
						{
							accessibles.add(plate.getPiece(x+i,y+i));
							if (plate.getPiece(x+i,y+i).getColor()!="e")
								i = plate.getBoardSize() + 1;
						}
					}
				}
			//Nord Est
			if ( x > 0 && y < plate.getBoardSize()-1)
				for (int i = 1; i < plate.getBoardSize()-y; i++ )
				{
					if (x-i >= 0 && y+i<plate.getBoardSize())
					{
						if (plate.getPiece(x-i,y+i).getColor()==this.getColor())
							i = plate.getBoardSize() + 1;
						else
						{
							accessibles.add(plate.getPiece(x-i,y+i));
							if (plate.getPiece(x-i,y+i).getColor()!="e")
								i = plate.getBoardSize() + 1;
						}
					}
				}
			//Nord Ouest
			if ( x > 0 && y > 0)
				for (int i = 1; i <= x; i++ )
				{
					if (x-i>=0 && y-i>=0)
					{
						if (plate.getPiece(x-i,y-i).getColor()==this.getColor())
							i = plate.getBoardSize() + 1;
						else
						{
							accessibles.add(plate.getPiece(x-i,y-i));
							if (plate.getPiece(x-i,y-i).getColor()!="e")
								i = plate.getBoardSize() + 1;
						}
					}
				}
			//Sud Ouest
			if (x < plate.getHeight()-1 && y > 0)
				for (int i = 1; i <= y; i++ )
				{
					if (x+i < plate.getHeight() && y-i >= 0)
					{
						if (plate.getPiece(x+i,y-i).getColor()==this.getColor())
							i = plate.getBoardSize() + 1;
						else
						{
							accessibles.add(plate.getPiece(x+i,y-i));
							if (plate.getPiece(x+i,y-i).getColor()!="e")
								i = plate.getBoardSize() + 1;
						}
					}
				}

			return accessibles;
		}
	}

	@Override
	public Icon getIcon() {
		if (this.getColor()=="w")
		{
			Icon img = new ImageIcon(getClass().getClassLoader().getResource("wbishop.png"));
			return img;
		}
		else {
			Icon img = new ImageIcon(getClass().getClassLoader().getResource("bbishop.png"));
			return img;
		}
	}

	@Override
	public void show() {
		System.out.println("Je suis un fou ! et ma position est : " + getRow() + " " + getColumn());			
	}


}
