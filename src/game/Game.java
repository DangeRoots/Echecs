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
<<<<<<< HEAD

	public Display my_window;
	public Plate my_plate;
	
	public Game(Display window,Plate plate)
	{
		my_window = window;
		my_plate = plate;	
	}
	
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
=======
>>>>>>> 5699eb58e40dc34337e26559fb9e8d0fbe48c44d
	
	// Méthode instanciant les 16 pièces du joueur et les plaçant sur le plateau de jeu
	public static void givePiecesToPlayer(Player play, Plate plateau)
	{
		String t_color = play.getM_color();
		// Create Pieces
		// pions
		Pawn[] m_pawn = new Pawn[8];
		for (int i = 0; i < 8; i ++)
		{
			m_pawn[i] = new Pawn();
			m_pawn[i].setColor(t_color);
		}
		// tour
		Rook m_rook;
		Rook m_rook2;
		
		m_rook = new Rook();
		m_rook.setColor(t_color);
		m_rook2 = new Rook();
		m_rook2.setColor(t_color);
		// cavalier
		Knight m_knight;
		Knight m_knight2;
		m_knight = new Knight();
		m_knight.setColor(t_color);
		m_knight2 = new Knight();
		m_knight2.setColor(t_color);
		// fou
		
		Bishop m_bish;
		Bishop m_bish2;
		m_bish = new Bishop();
		m_bish.setColor(t_color);
		m_bish2 = new Bishop();
		m_bish2.setColor(t_color);
		
		// Reine
		Queen m_queen;
		m_queen = new Queen();
		m_queen.setColor(t_color);
		
		// Roi
		King m_king;
		m_king = new King();
		m_king.setColor(t_color);
		
		
		// Place the pieces on the plate
		if (t_color == "w")
		{
			for (int i=0; i < 8; i ++)
			{
				plateau.setPiece(m_pawn[i], 6, i);
			}

			plateau.setPiece(m_rook, 7, 0);
			plateau.setPiece(m_rook2, 7, 7);

			plateau.setPiece(m_knight, 7, 1);
			plateau.setPiece(m_knight2, 7, 6);
			
			plateau.setPiece(m_bish, 7, 2);
			plateau.setPiece(m_bish2, 7, 5);
			
			plateau.setPiece(m_queen, 7, 3);
			plateau.setPiece(m_king, 7, 4);
			
		}
		else
		{
			for (int i=0; i < 8; i ++)
			{
				plateau.setPiece(m_pawn[i], 1, i);
			}

			plateau.setPiece(m_rook, 0, 0);
			plateau.setPiece(m_rook2, 0, 7);

			plateau.setPiece(m_knight, 0, 1);
			plateau.setPiece(m_knight2, 0, 6);
			
			plateau.setPiece(m_bish, 0, 2);
			plateau.setPiece(m_bish2, 0, 5);
			
			plateau.setPiece(m_queen, 0, 3);
			plateau.setPiece(m_king, 0, 4);
		}
		
	}

	// Méthode initialisant le jeu : joueurs + pièces
	public static void initGame(Plate plateau)
	{
		Player p_white = new Player("White Player", "w");
		Player p_black = new Player("Black Player", "b");
		
		givePiecesToPlayer(p_white, plateau);
		givePiecesToPlayer(p_black, plateau);
	}
	public static void main (String args[])
	{
		Display window = new Display();

		Plate plateau = new Plate();
		
		initGame(plateau);
		
		window.refreshDisplay(plateau);
		
	}
}
