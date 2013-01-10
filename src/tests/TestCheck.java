package tests;

import pieces.*;
import game.*;
import junit.framework.TestCase;


public class TestCheck extends TestCase {
	
	public void testCheck() {
		
		Player active_player = new Player("Active","w");
		boolean bool = false;
		
	    Plate g_plateau = new Plate();
	    
		King k = new King();
		Pawn p = new Pawn();
		Knight kn = new Knight();
		Rook r = new Rook();
		
				
		k.setColor("b");
		p.setColor("b");
		kn.setColor("b");
		r.setColor("w");
		
		g_plateau.setPiece(k, 0, 0);
		//g_plateau.setPiece(p, 1, 1);
		g_plateau.setPiece(kn, 1, 2);
		g_plateau.setPiece(r, 2, 2);
		
		Game.isG_Kcheck(g_plateau,active_player);
		
	}

}
