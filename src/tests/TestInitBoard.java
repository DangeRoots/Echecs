package tests;

import game.Plate;
import junit.framework.TestCase;


public class TestInitBoard extends TestCase {
	
	public void testInitBoardClassic() {
		
		Plate g_plateau = new Plate();		
		assertEquals(8, g_plateau.getBoardSize());
		assertEquals(8, g_plateau.getHeight());
	}

	public void testInitBoardCapablanca() {
		
		Plate g_plateau = new Plate("capablanca");		
		assertEquals(10, g_plateau.getBoardSize());
		assertEquals(8, g_plateau.getHeight());
	}
}
