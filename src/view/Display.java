package view;
import game.Game;
import game.Plate;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


import pieces.Empty;
import pieces.Piece;

/*--------------------------------------------------------------------------------------------------------------------------------------------
# Interface Graphique
# Affichage de l'ecran de jeux.
--------------------------------------------------------------------------------------------------------------------------------------------*/

public class Display extends JFrame{

	// container de la fenetre et barre de menu
	private JPanel container = new JPanel();
	private JPanel AdvanceInterface = new JPanel();
	private JMenuBar menuBar = new JMenuBar();

	//Item du menu
	JMenu game = new JMenu("Game");
	JMenuItem newGame = new JMenuItem("Classic Chess");
	JMenuItem leave = new JMenuItem("Leave");
	JMenuItem CapaBlanca = new JMenuItem("CapaBlanca Chess");

	// gestionnaire d'affichage
	GridBagLayout gl;
	GridBagConstraints gbc;

	// ecouteur d'evenement
	Selection Listener = new Selection();

	//affichage du nom du joueur
	private JLabel player = new JLabel("White Player");

	//Affichage console
	private JList affichageConsole = new JList();


	// compteur et variable de position
	private int compteurClics=0;
	private int posX = 0;
	private int posY = 0;
	private Color color;
	private JButton hover;
	private boolean GameRules = false;
	private int Nbx =0;
	private int Nby =0;

	// plateau et boutton
	private Piece[][] pieces;
	public Plate Plateau = new Plate();
	public JButton[][] cells = new JButton[0][0];


	/*--------------------------------------------------------------------------------------------------------------------------------------------
# Constructeur de class
--------------------------------------------------------------------------------------------------------------------------------------------*/
	public Display(){

		this.setSize(1000, 930);
		this.setTitle("Echiquier");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		//On initialise le conteneur avec tous les composants

		initMenu();

		this.setJMenuBar(menuBar);

		AdvanceInterface.setLayout(new BorderLayout());
		player.setFont(new Font("Dialog", 1, 25));
		player.setPreferredSize(new Dimension(1000, 30));
		JPanel header = new JPanel();
		header.setLayout(new BorderLayout());
		
		header.add(new JLabel(""), BorderLayout.NORTH);
		header.add(new JLabel(""), BorderLayout.SOUTH);
		header.add(player, BorderLayout.CENTER);
		JLabel EastBlock = new JLabel("");
		
		EastBlock.setPreferredSize(new Dimension(410,50));
		header.add(EastBlock, BorderLayout.WEST);
		
		AdvanceInterface.add(header, BorderLayout.PAGE_START);
		
	//	AdvanceInterface.add(player, BorderLayout.PAGE_START);
		container.setPreferredSize(new Dimension(1000,800));
		AdvanceInterface.add(container, BorderLayout.CENTER);	
		affichageConsole.setPreferredSize(new Dimension(900,100));
		AdvanceInterface.add(affichageConsole, BorderLayout.PAGE_END);

		this.setContentPane(AdvanceInterface);
		this.setVisible(true);
	}

	/*--------------------------------------------------------------------------------------------------------------------------------------------
# Initialisation de la barre de menu :
# Affichage du menu et impementation des données 
--------------------------------------------------------------------------------------------------------------------------------------------*/
	private void initMenu() {

		// leave the Game
		leave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}      
		});

		// launch a new classic game
		newGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {

				AdvanceInterface.remove(container);
				container = new JPanel();
				AdvanceInterface.add(container, BorderLayout.CENTER);
				initDisplay(false);

				Plateau = Game.initGame(); 
				refreshDisplay(Plateau);
			}      
		});

		// launch a special CapaBlanca Game
		CapaBlanca.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {


				AdvanceInterface.remove(container);
				container = new JPanel();
				AdvanceInterface.add(container, BorderLayout.CENTER);	
				initDisplay(true);

				Plateau = Game.initGame(); 
				refreshDisplay(Plateau);
			}      
		});

		game.add(newGame);
		game.add(CapaBlanca);
		game.addSeparator();
		game.add(leave);	      
		menuBar.add(game);
	}

	/*--------------------------------------------------------------------------------------------------------------------------------------------
# Initialisation du contenu de l'ecran :
# generation graphique du plateau de jeu
--------------------------------------------------------------------------------------------------------------------------------------------*/
	private void initDisplay(boolean typeGame) {

		// création de l'interface selon le type de jeu
		GameRules = typeGame;
		if (GameRules == false)
		{
			Nbx = 8;
			Nby = 8;
		}
		else {
			Nbx = 10;
			Nby = 8;
		}

		// TODO Auto-generated method stub
		GridBagLayout gl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		//On positionne la case de départ du composant
		gbc.gridx = 0;
		gbc.gridy = 0;

		//La taille en hauteur et en largeur
		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		container.setLayout(gl);

		cells = new JButton[Nbx][Nby];

		// affichage du plateau de jeux
		for (JButton[] cellLine : cells) {
			for (JButton cell : cellLine) {
				cell = new JButton();
				cell.setActionCommand(String.valueOf(gbc.gridx)+String.valueOf(gbc.gridy));
				cell.setName(String.valueOf(gbc.gridx)+String.valueOf(gbc.gridy));
				cell.setPreferredSize(new Dimension(90,90));
				cell.addActionListener(Listener);
				if (gbc.gridx % 2 == 0){
					if (gbc.gridy %2 == 0) {
						cell.setBackground(Color.white);
					}
					else cell.setBackground(Color.gray);
				}
				else {

					if (gbc.gridy %2 == 0) {
						cell.setBackground(Color.gray);
					}
					else cell.setBackground(Color.white);				
				}
				container.add(cell, gbc);
				cells[gbc.gridx][gbc.gridy] = cell;

				gbc.gridy ++;
			}
			gbc.gridx ++;
			gbc.gridy = 0;
		}
	}

	/*--------------------------------------------------------------------------------------------------------------------------------------------
# Rafraichissement de l'affichage : 
# mise a jour de l'interface graphique à chaque changement deplacement de piece
--------------------------------------------------------------------------------------------------------------------------------------------*/
	public void refreshDisplay(Plate gamePlate) {

		pieces = gamePlate.getPlate();
		Plateau = gamePlate;

		for(int i =0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				cells[j][i].setIcon(pieces[j][i].getIcon());			
			}
		}
	}

	/*--------------------------------------------------------------------------------------------------------------------------------------------
# Gestionnaire d'evenement : 
 gère le clic sur l'echiquier.
-------------------------------------------------------------------------------------------------------------------------------------------*/


	class Selection implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {

			Timer timer = new Timer();
			compteurClics++;

			if (compteurClics == 1)
			{		
				// position de la cellule
				String positionDebut = e.getActionCommand();
				int xd = Integer.parseInt(String.valueOf(positionDebut.charAt(0)));
				int yd = Integer.parseInt(String.valueOf(positionDebut.charAt(1)));		
				posX = xd;
				posY = yd;

				ArrayList<Piece> possibleMove = new ArrayList<Piece>();
				possibleMove = pieces[posX][posY].accessibleCells(Plateau);

				// Hover sur les chemins possibles
				if (possibleMove != null)
				{
					for (Piece pos : possibleMove)
					{
						int x=pos.getColumn();
						int y=pos.getRow();

						cells[x][y].setBackground(Color.ORANGE);			
					}

				}

				// Si le clique c'est pas autorisé
				if (!Game.isClickable( pieces[posX][posY]))
				{
					hover = (JButton) e.getSource();
					color = hover.getBackground();

					hover.setBackground(Color.red);
					timer.schedule(new TimerTask()
					{
						public void run()
						{					
							hover.setBackground(color);
							DisplayPlateColor(Nbx, Nby);
						}
					}, 500);

					System.out.println("Sélection impossible");
					compteurClics = 0;

				}
				else 
				{

					JButton cells = (JButton)e.getSource();
					color = cells.getBackground();
					((JComponent) e.getSource()).setBackground(Color.green);
				}		

			}

			if (compteurClics == 2)
			{			

				compteurClics=0;

				// position de la cellule
				String positionFin = e.getActionCommand();
				int xf = Integer.parseInt(String.valueOf(positionFin.charAt(0)));
				int yf = Integer.parseInt(String.valueOf(positionFin.charAt(1)));

				ArrayList<Piece> possibleMove = new ArrayList<Piece>();
				possibleMove = pieces[posX][posY].accessibleCells(Plateau);


				if (possibleMove == null)
				{
					//	System.out.print("Rien");
					//	cells[posX][posY].setBackground(color);

					DisplayPlateColor(Nbx, Nby);
				}
				else{
					cells[posX][posY].setBackground(color);
					for (Piece pos : possibleMove)
					{

						if (pos.getRow()==yf && pos.getColumn()==xf)
						{												
							// on crée 2 plateau en 1 ca double les case donc ca plante.
							Plateau.setPiece(pieces[posX][posY], yf, xf);				
							Piece empty = new Empty();			
							Plateau.setPiece(empty, posY, posX);					

							//cells[posX][posY].setBackground(color);

							refreshDisplay(Plateau);

							posX = 0;
							posY = 0;
							Game.endTurn();
							player.setText(Game.getActive_player().getM_name());
							DisplayPlateColor(Nbx, Nby);
						}
					}	

				}

			}
		}

		public void DisplayPlateColor(int NbX, int NbY)

		{
			// on reaffiche les couleur du plateau
			for(int i =0; i < NbX; i++)
			{
				for(int j = 0; j < NbY; j++)
				{
					cells[j][i].setIcon(pieces[j][i].getIcon());

					if (i % 2 == 0){
						if (j %2 == 0) {
							cells[i][j].setBackground(Color.white);
						}
						else cells[i][j].setBackground(Color.gray);
					}
					else {

						if (j %2 == 0) {
							cells[i][j].setBackground(Color.gray);
						}
						else cells[i][j].setBackground(Color.white);				
					}
				}
			}
		}
	}

}
