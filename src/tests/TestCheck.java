package tests;

import pieces.*;
import game.*;
import junit.framework.TestCase;


public class TestCheck extends TestCase {
	
	public void testCheck() {
		
		Player active_player = new Player("Active","w");
		
	    Plate g_plateau = new Plate();
	    
		King k = new King();
		
		Pawn p = new Pawn();
		Knight kn = new Knight();
		Rook r = new Rook();
		Bishop b = new Bishop();
		
				
		k.setColor("b");
		
		//Remplacer "b" par "w" pour tester la pièce 
		p.setColor("b");
		kn.setColor("b");
		r.setColor("b");
		b.setColor("w"); // le pion est à retirer du plateau pour tester ce cas
		
		g_plateau.setPiece(k, 0, 0);
		//g_plateau.setPiece(p, 1, 1);
		g_plateau.setPiece(kn, 1, 2);
		g_plateau.setPiece(r, 2, 0);
		g_plateau.setPiece(b, 2, 2);
		
		Game.isG_Kcheck(g_plateau,active_player);
		
	}

}
