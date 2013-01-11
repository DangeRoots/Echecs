package game;

import java.util.ArrayList;

import pieces.Archbishop;
import pieces.Bishop;
import pieces.Chancellor;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;
import view.Display;


/**
 * 	Utilisation de la classe Game par l'interface graphique 
 * 		
 * 		Appel à isClickable (Piece piece_cliquée) renvoie un booléen, vrai si la pièce est de la couleur du joueur actif, faux sinon
 * 		Appel à endTurn() une fois un déplacement effectué -> pas de retour, permet le passage au tour suivant par le jeu
 * 
 */
public class Game {
	
	static Player active_player;
	static Player p_white;
	static Player p_black;
	static boolean g_ended;
	static Display g_window;
	static Plate g_plateau;
	static boolean g_Kcheck;
	public static Piece[][] pieces;
	
	static int width;
	static int heigth;
	
	
	public static boolean getG_Kcheck() {
		return g_Kcheck;
	}

	public static Player getActive_player() {
		return active_player;
	}

	public static Player getP_white() {
		return p_white;
	}

	public static Player getP_black() {
		return p_black;
	}

	
	//Methode qui retourne si le roi est en echec = true
	public static King isG_Kcheck(Plate plate,Player player) {
		
		//liste des mouvement disponible pour le joueur
		ArrayList<Piece> listeToutAccessibles = new ArrayList<Piece>();
		//liste des mouvement disponible pour le joueur adverse
		ArrayList<Piece> listeToutAccessiblesParAdverdaire = new ArrayList<Piece>();
		
		King target = new King();
		g_Kcheck = false;
		
		listeToutAccessibles = ArrayAllPieceAccessible(plate,player);
		listeToutAccessiblesParAdverdaire = ArrayAllPieceAccessibleByAdverse(plate, player);
		
		//System.out.println("3");
			if (listeToutAccessiblesParAdverdaire != null)
			{
				for (int i = 0;i < listeToutAccessiblesParAdverdaire.size();i++)
				{	
					//Si le roi du joueur apparait dans la liste des mouvements de l'adversaire on interdit le mouvement
					if (listeToutAccessiblesParAdverdaire.get(i).getClass() == target.getClass() )
					{
						g_Kcheck = true;
						target = (King)listeToutAccessiblesParAdverdaire.get(i);
						System.out.println("Déplacement interdit");
					}
				}	
			}
			if (listeToutAccessibles!= null)
			{
				for (int j = 0;j < listeToutAccessibles.size();j++)
				{	
					//Si le roi du joueur adverse apparait dans la liste de nos mouvements on le met en échec
					if (listeToutAccessibles.get(j).getClass() == target.getClass() )
					{
						g_Kcheck = true;
						target = (King)listeToutAccessibles.get(j);
					}
				}	
			}
				
			if (g_Kcheck)
			{
				if (target.getColor() == "b")
				{
					System.out.println("Le joueur noir est en échec");
				}
				else 
				{
					System.out.println("Le joueur blanc est en échec");
				}			
			}
		
		return target;
	}
	
	
	public static boolean isG_Kmate(Plate plate,Player player,Piece enemy) {
		
		boolean is_CheckMate = false;
		King kingInCheckMate = new King();
		//liste des mouvement disponible pour le joueur
		ArrayList<Piece> listeToutAccessibles = new ArrayList<Piece>();
		//liste des mouvement disponible pour le joueur adverse
		
		listeToutAccessibles = ArrayAllPieceAccessible(plate, player);
		
		kingInCheckMate = isG_Kcheck(plate, player);
		
		if (g_Kcheck)
		{
			if (listeToutAccessibles != null)
			{
				for (int i = 0;i < listeToutAccessibles.size();i++)
				{	
					if (!listeToutAccessibles.contains(enemy))
					{
						is_CheckMate = true;
					}
				}
			}
		}
		
		return is_CheckMate;
	}
	
	
	//Methode 
	public static ArrayList<Piece> ArrayAllPieceAccessible(Plate plate,Player player)
	{
		//Piece[][] Tableau = new Piece[heigth][width];
		
		System.out.println("a");
		pieces = plate.getPlate();
		
		ArrayList<Piece> listeToutAccessibles = new ArrayList<Piece>();
		ArrayList<Piece> listeAccessibles = new ArrayList<Piece>();
		System.out.println("b");
		for(int i =0; i < width; i++)
		{
			for(int j = 0; j < heigth; j++)
			{
				System.out.println(pieces[i][j]);
				listeAccessibles = pieces[i][j].accessibleCells(plate);
				System.out.println("c");

				if (listeAccessibles != null)
				{	
					for (int y=0; y < pieces[i][j].accessibleCells(plate).size();y++)
					{	
						if ((listeAccessibles.get(y).getColor() != player.getM_color()))
						{
							listeToutAccessibles.add(listeAccessibles.get(y));		
						}	
					}
				}
			}
		}
		
		return listeToutAccessibles;
	}
	
	//Methode
	public static ArrayList<Piece> ArrayAllPieceAccessibleByAdverse(Plate plate,Player player)
	{
pieces = plate.getPlate();
		
		ArrayList<Piece> listeToutAccessibles = new ArrayList<Piece>();
		ArrayList<Piece> listeAccessibles = new ArrayList<Piece>();
		
		for(int i =0; i < width; i++)
		{
			for(int j = 0; j < heigth; j++)
			{
				listeAccessibles = pieces[i][j].accessibleCells(plate);
				if (listeAccessibles != null)
				{	
					for (int y=0; y < pieces[i][j].accessibleCells(plate).size();y++)
					{	
						if ((listeAccessibles.get(y).getColor() == player.getM_color()))
						{
							listeToutAccessibles.add(listeAccessibles.get(y));		
						}	
					}
				}
			}
		}
		
		return listeToutAccessibles;
	}


	// Méthode instanciant les 16 pièces du joueur et les plaçant sur le plateau de jeu
	public static void givePiecesToPlayer(Player play, Plate plateau, String variante)
	{
		String t_color = play.getM_color();
		// Create Pieces
		// pions
		Pawn[] m_pawn;
		if (variante == "capablanca")
		{
			m_pawn = new Pawn[10];
			for (int i = 0; i < 10; i ++)
			{
				m_pawn[i] = new Pawn();
				m_pawn[i].setColor(t_color);
			}
		}
		else 
		{
			m_pawn = new Pawn[8];
			for (int i = 0; i < 8; i ++)
			{
				m_pawn[i] = new Pawn();
				m_pawn[i].setColor(t_color);
			}
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

		Archbishop m_arch = new Archbishop();
		m_arch.setColor(t_color);

		Chancellor m_chan = new Chancellor();
		m_chan.setColor(t_color);


		if (variante == "capablanca")
		{
			// Place the pieces on the plate
			if (t_color == "w")
			{
				for (int i=0; i < 10; i ++)
				{
					plateau.setPiece(m_pawn[i], 6, i);
				}

				plateau.setPiece(m_rook, 7, 0);
				plateau.setPiece(m_rook2, 7, 9);

				plateau.setPiece(m_knight, 7, 1);
				plateau.setPiece(m_knight2, 7, 8);
				
				plateau.setPiece(m_arch, 7, 2);
				plateau.setPiece(m_chan, 7, 7);

				plateau.setPiece(m_bish, 7, 3);
				plateau.setPiece(m_bish2, 7, 6);

				plateau.setPiece(m_queen, 7, 4);
				plateau.setPiece(m_king, 7, 5);

			}
			else
			{
				for (int i=0; i < 10; i ++)
				{
					plateau.setPiece(m_pawn[i], 1, i);
				}

				plateau.setPiece(m_rook, 0, 0);
				plateau.setPiece(m_rook2, 0, 9);

				plateau.setPiece(m_knight, 0, 1);
				plateau.setPiece(m_knight2, 0, 8);
				
				plateau.setPiece(m_arch, 0, 2);
				plateau.setPiece(m_chan, 0, 7);

				plateau.setPiece(m_bish, 0, 3);
				plateau.setPiece(m_bish2, 0, 6);

				plateau.setPiece(m_queen, 0, 4);
				plateau.setPiece(m_king, 0, 5);
			}
			
		}
		else 
		{
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
		

	}

	// Méthode initialisant le jeu : joueurs + pièces, joueur actif
	public static Plate initGame()
	{
		
		/** @TODO
		 * Remettre les cases à leur couleur de base
		 */
		width = 8;
		heigth = 8;
		g_plateau = new Plate();
		g_Kcheck = false;
		p_white = new Player("White Player", "w");
		p_black = new Player("Black Player", "b");
		
		givePiecesToPlayer(p_white, g_plateau, "");
		givePiecesToPlayer(p_black, g_plateau, "");
		
		active_player = p_white;
		g_ended = false;
		return g_plateau;
	}
	
	// Méthode initialisant le jeu : joueurs + pièces, joueur actif variante capablanca
	public static Plate initGame(String variante)
	{
		
		/** @TODO
		 * Remettre les cases à leur couleur de base
		 */
		if (variante == "capablanca")
		{

			width = 10;
			heigth = 8;
			g_plateau = new Plate("capablanca");
			g_Kcheck = false;
			p_white = new Player("White Player", "w");
			p_black = new Player("Black Player", "b");
			
			givePiecesToPlayer(p_white, g_plateau, "capablanca");
			givePiecesToPlayer(p_black, g_plateau, "capablanca");
			
			active_player = p_white;
			g_ended = false;
			return g_plateau;	
		}
		else { return null; }
		
	}
	
	/* Méthode appelée à la fin d'un tour de jeu :
	 * 		Passage d'active_player au joueur suivant
	 * 		A implémenter plus tard dans cette méthode :
	 * 			Vérification des échecs
	 * 			Promotion
	 * 			Pat
	 * 			Gestion du compteur Blitz
	 * 
	 */
	public static void endTurn()
	{	
		/*
		 * 	Ensemble des vérifications de fin de tour à implémenter : 
		 * 	échecs, promotions, etc...
		 */
		if (!g_ended) 
		{
			beginNewTurn();
		}
		else 
		{
			endGame();
		}
	}
	
	//Méthode appelée lorsque la partie est terminée
	public static void endGame()
	{
		
	}
	
	/*
	 * Corps de méthode pour la gestion de :
	 * 		Compteur Blitz
	 * 		Autres événements de début de tour
	 */
	public static void beginNewTurn()
	{
		if (active_player == p_white)
		{
			active_player = p_black;
		}
		else 
		{
			active_player = p_white;
		}
		System.out.println("Nouveau joueur : " + active_player.getM_name());

	}
	
	public static boolean isClickable(Piece clicked_piece)
	{
		if (clicked_piece.getColor() == active_player.getM_color())
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
		
	public static void main (String args[])
	{
		g_window = new Display();
		
		initGame();
		
		/*	Déroulement d'un tour de jeu
		 * 	Initialisation du nouveau tour 			-> beginNewTurn()
		 * 	Passage de la main à la partie graphique
		 * 		-> Vérification du "bon joueur" 	-> appel à isClickable (Piece piece_cliquée)
		 * 	Appel par la partie graphique de endTurn() une fois le déplacement validé et effectué
		 * 	Appel après les opérations d'endTurn() de : 
		 * 			-> beginNewTurn() et passage au tour suivant.
		 * 			-> ou endGame() dans le cas où la partie s'est terminée au cours du dernier tour.
		 */
		
	}
}
