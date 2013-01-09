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
		if(!this.isOnScreen()){
			return null;
		}
		else{
			int x = this.getRow();
			int y = this.getColumn();
			//Nord Est
			for (int i = x+1; i < 8;i++)
				for (int j = y+1; j < 8; j++)
				{
					if (plate.getPiece(i, j).getColor()==this.getColor())
						i = j = 8;
					else
					{
						accessibles.add(plate.getPiece(i, y));
						if (plate.getPiece(i, j).getColor()!="e")
							i = j = 8;
					}
				}
			//Nord Ouest
			for (int i = x+1; i < 8;i++)
				for (int j = y-1; j > 0; j--)
				{
					if (plate.getPiece(i, j).getColor()==this.getColor())
					{
						i = 8;
						j = -1;
					}
					else
					{
						accessibles.add(plate.getPiece(i, y));
						if (plate.getPiece(i, j).getColor()!="e")
							i = 8;
							j = -1;
					}
				}
			//Sud Ouest
			for (int i = x-1; i > 0; i--)
				for (int j = y-1 ;j > 0; j--)
				{
					if (plate.getPiece(i, j).getColor()==this.getColor())
					{
						i = j = -1;
					}
					else
					{
						accessibles.add(plate.getPiece(i, y));
						if (plate.getPiece(i, j).getColor()!="e")
							i = j = -1;
					}
				}
			//Sud Est
			for (int i = x-1; i > 0;i--)
				for (int j = y+1; j < 8; j++)
				{
					if (plate.getPiece(i, j).getColor()==this.getColor())
					{
						j = 8;
						i = -1;
					}
					else
					{
						accessibles.add(plate.getPiece(i, y));
						if (plate.getPiece(i, j).getColor()!="e")
							j = 8;
							i =-1;
					}
				}
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
			Icon img = new ImageIcon("./img/wbishop.png");
			return img;
		}
		else {
			Icon img = new ImageIcon("./img/bbishop.png");
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
