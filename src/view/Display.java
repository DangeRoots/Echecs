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
	private JPanel header = new JPanel();
	private JPanel AdvanceInterface = new JPanel();
	private JMenuBar menuBar = new JMenuBar();
	
	//Item du menu
	JMenu game = new JMenu("Game");
	JMenuItem newGame = new JMenuItem("New Game");
	JMenuItem leave = new JMenuItem("Leave");

	// gestionnaire d'affichage
	GridBagLayout gl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	// ecouteur d'evenement
	Selection Listener = new Selection();

	// plateau et boutton
	private Piece[][] pieces;
	public Plate Plateau = new Plate();
	public JButton[][] cells = new JButton[8][8];
	
	//affichage du nom du joueur
	private JLabel player = new JLabel("White Player");
	
	//Affichage console
	private JList affichageConsole = new JList();

	
	// compteur et variable de position
	private int compteurClics=0;
	private int posX = 0;
	private int posY = 0;
	private boolean initialized = false;
	private Color color;
	private JButton hover;


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
		
		AdvanceInterface.add(player, BorderLayout.PAGE_START);
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
		
	    leave.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent arg0) {
	          System.exit(0);
	        }      
	      });
	    
	    newGame.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent arg0) {
	          	
	        	if (initialized == false)
	        	{
	        		initDisplay();
	        		initialized = true;
	        	}
	        	Plateau = Game.initGame(); 
	        	refreshDisplay(Plateau);
	        }      
	      });
	    
		game.add(newGame);
	    game.addSeparator();
	    game.add(leave);	      
	    menuBar.add(game);
	}
	
/*--------------------------------------------------------------------------------------------------------------------------------------------
# Initialisation du contenu de l'ecran :
# generation graphique du plateau de jeu
--------------------------------------------------------------------------------------------------------------------------------------------*/
	private void initDisplay() {
		
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
			if (!Game.isClickable( pieces[posX][posY]))
			{
				hover = (JButton) e.getSource();
				color = hover.getBackground();
				//System.out.println("Passage à red");
				hover.setBackground(Color.red);
				timer.schedule(new TimerTask()
				{
					public void run()
					{
						
						//System.out.println("Passage à bg");
						hover.setBackground(color);
					}
				}			
				, 500);
				
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
				System.out.print("Rien");
				cells[posX][posY].setBackground(color);
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
									
						cells[posX][posY].setBackground(color);
						
						refreshDisplay(Plateau);
						
						posX = 0;
						posY = 0;
						Game.endTurn();
						player.setText(Game.getActive_player().getM_name());
					}
				}	
				
			}
			
			}
		}
		
	}
	
}
