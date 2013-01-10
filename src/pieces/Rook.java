package pieces;

import game.Plate;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Rook extends Piece {

	@Override
	public ArrayList<Piece> accessibleCells(Plate plate) {
		ArrayList<Piece> accessibles = new ArrayList<Piece>();
		System.out.println("entree fonction");
		// Cas d'une piece morte
		if(!this.isOnScreen(plate)){
			return null;
		}
		else{
			int x = this.getRow();
			int y = this.getColumn();
		
			//Haut
			for (int i = x+1; i < 8;i++)
			{
				//System.out.println("haut");
				if (plate.getPiece(i, y).getColor()==this.getColor())
					i = 8;
				else
				{
					accessibles.add(plate.getPiece(i, y));
					if (plate.getPiece(i, y).getColor()!="e")
						i = 8;
				}
			}
			//Bas
			for (int i = x-1; i > -1;i--)
			{
				//System.out.println("bas");
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
			System.out.println("boardSize : " + plate.getBoardSize());
			for (int i = y+1; i < plate.getBoardSize();i++)
			{
				System.out.println(i);
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
				//System.out.println("g");
				if (plate.getPiece(x, i).getColor()==this.getColor())
					i = -1;
				else
				{
					accessibles.add(plate.getPiece(x, i));
					if (plate.getPiece(x, i).getColor()!="e")
						i = -1;
				}
			}
			System.out.println(accessibles.size());
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
			Icon img = new ImageIcon("./img/wrook.png");
			return img;
		}
		else {
			Icon img = new ImageIcon("./img/brook.png");
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
