package tests;

import game.Player;
import junit.framework.TestCase;


public class TestPlayers extends TestCase{
	
	public void testWhitePlayer() {
		
		Player player = new Player("Player1", "w");
		// test sur la couleur
		assertNotSame("w", "b", player.getM_color());
		// test sur le tableau des pieces mangées == 16
		assertEquals(16 ,player.getM_lost_pieces().length);
		
		for (int i = 0; i < player.getM_lost_pieces().length; i++)
		{
			assertNull(player.getM_lost_pieces()[i]);
		}
	}
	
	public void testBlackPlayer() {
		
		Player player = new Player("Player1", "b");
		// test sur la couleur
		assertNotSame("b", "w", player.getM_color());
		// test sur le tableau des pieces mangées == 16
		assertEquals(16 ,player.getM_lost_pieces().length);
		
		for (int i = 0; i < player.getM_lost_pieces().length; i++)
		{
			assertNull(player.getM_lost_pieces()[i]);
		}
	}

}
