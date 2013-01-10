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
			//Sud Est
			if (y < 7 && x < 7)
				for (int i = 1; i < 8-x; i++ )
				{
					if (x+i<8 && y+i<8)
					{
						if (plate.getPiece(x+i,y+i).getColor()==this.getColor())
							i = 10;
						else
						{
							accessibles.add(plate.getPiece(x+i,y+i));
							if (plate.getPiece(x+i,y+i).getColor()!="e")
								i = 10;
						}
					}
				}
			//Nord Est
			// ex : pos 5,4 == posiible -> 6,6 7,6
			if ( x> 0 && y < 7)
				for (int i = 1; i < 8-y; i++ )
				{
					if (x-i>=0 && y+i<8)
					{
						if (plate.getPiece(x-i,y+i).getColor()==this.getColor())
							i = 10;
						else
						{
							accessibles.add(plate.getPiece(x-i,y+i));
							if (plate.getPiece(x-i,y+i).getColor()!="e")
								i = 10;
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
							i = 10;
						else
						{
							accessibles.add(plate.getPiece(x-i,y-i));
							if (plate.getPiece(x-i,y-i).getColor()!="e")
								i = 10;
						}
					}
				}
			//Sud Ouest
			if (x < 7 && y > 0)
				for (int i = 1; i <= y; i++ )
				{
					if (x+i<8 && y-i>=0)
					{
						if (plate.getPiece(x+i,y-i).getColor()==this.getColor())
							i = 10;
						else
						{
							accessibles.add(plate.getPiece(x+i,y-i));
							if (plate.getPiece(x+i,y-i).getColor()!="e")
								i = 10;
						}
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
