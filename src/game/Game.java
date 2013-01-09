package game;

import java.util.ArrayList;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;
import view.Display;

public class Game {

	public static void main (String args[])
	{
		Display window = new Display();

		Plate plateau = new Plate();
		
// pion blanc
		
		Pawn p1 = new Pawn();
		Pawn p2= new Pawn();
		Pawn p3= new Pawn();
		Pawn p4= new Pawn();
		Pawn p5= new Pawn();
		Pawn p6= new Pawn();
		Pawn p7= new Pawn();
		Pawn p8 = new Pawn();
		
		p1.setColor("w");
		p2.setColor("w");
		p3.setColor("w");
		p4.setColor("w");
		p5.setColor("w");
		p6.setColor("w");
		p7.setColor("w");
		p8.setColor("w");
		

		plateau.setPiece(p1,0,6);
		plateau.setPiece(p2,1,6);
		plateau.setPiece(p3,2,6);
		plateau.setPiece(p4,3,6);
		plateau.setPiece(p5,4,6);
		plateau.setPiece(p6,5,6);
		plateau.setPiece(p7,6,6);
		plateau.setPiece(p8,7,6);
	
// pion noir
		
		Pawn p1b = new Pawn();
		Pawn p2b= new Pawn();
		Pawn p3b= new Pawn();
		Pawn p4b= new Pawn();
		Pawn p5b= new Pawn();
		Pawn p6b= new Pawn();
		Pawn p7b= new Pawn();
		Pawn p8b = new Pawn();
		
		p1b.setColor("b");
		p2b.setColor("b");
		p3b.setColor("b");
		p4b.setColor("b");
		p5b.setColor("b");
		p6b.setColor("b");
		p7b.setColor("b");
		p8b.setColor("b");
		

		plateau.setPiece(p1b,0,1);
		plateau.setPiece(p2b,1,1);
		plateau.setPiece(p3b,2,1);
		plateau.setPiece(p4b,3,1);
		plateau.setPiece(p5b,4,1);
		plateau.setPiece(p6b,5,1);
		plateau.setPiece(p7b,6,1);
		plateau.setPiece(p8b,7,1);
		

// fou blanc
		Bishop b1 = new Bishop();
		Bishop b2 = new Bishop();
		
		b1.setColor("w");
		b2.setColor("w");
		
		plateau.setPiece(b1, 2, 7);
		plateau.setPiece(b2, 5, 7);
		
// fou noir
		Bishop b1b = new Bishop();
		Bishop b2b = new Bishop();
		
		b1b.setColor("b");
		b2b.setColor("b");
		
		plateau.setPiece(b1b, 2, 0);
		plateau.setPiece(b2b, 5, 0);

// cavalier blanc
		Knight k1 = new Knight();
		Knight k2 = new Knight();
		k1.setColor("w");
		k2.setColor("w");
		plateau.setPiece(k1, 1, 7);
		plateau.setPiece(k2, 6, 7);

		// cavalier noir
		Knight k1b = new Knight();
		Knight k2b = new Knight();
		k1b.setColor("b");
		k2b.setColor("b");
		plateau.setPiece(k1b, 1, 0);
		plateau.setPiece(k2b, 6, 0);
		
		// tour blanche
		Rook r1 = new Rook(); 
		Rook r2 = new Rook();
		r1.setColor("w");
		r2.setColor("w");
		plateau.setPiece(r1, 0, 7);
		plateau.setPiece(r2, 7, 7);

		// tour noire
		Rook r1b = new Rook(); 
		Rook r2b = new Rook();
		r1b.setColor("b");
		r2b.setColor("b");
		plateau.setPiece(r1b, 0, 0);
		plateau.setPiece(r2b, 7, 0);
		
		// queen blanche
		Queen q1 = new Queen();
		q1.setColor("w");
		plateau.setPiece(q1, 3, 7);

		// queen noire
		Queen q1b = new Queen();
		q1b.setColor("b");
		plateau.setPiece(q1b, 3, 0);
		
		// roi blanc
		King kg1 = new King();
		kg1.setColor("w");
		plateau.setPiece(kg1, 4, 7);

		// roi noir
		King kg1b = new King();
		kg1b.setColor("b");
		plateau.setPiece(kg1b, 4, 0);
		
		window.refreshDisplay(plateau);
		
	}
}
