package view;
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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import pieces.Empty;
import pieces.Piece;
public class Display extends JFrame{

	// container de la fenetre
	private JPanel container = new JPanel();
	//tableau de piece
	private Piece[][] pieces;
	//Menu
	private JMenuBar menuBar = new JMenuBar();
	
	//Item du menu
	JMenu game = new JMenu("Game");
	JMenuItem   newGame = new JMenuItem("New Game"),leave = new JMenuItem("Leave");
	
	// gestionnaire d'affichage
	GridBagLayout gl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	// ecouteur
	Selection Listener = new Selection();

	// plateau
	JButton[][] cells = new JButton[8][8];
	private int compteurClics=0;

	public Display(){

		this.setSize(800, 800);
		this.setTitle("Echiquier");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		//On initialise le conteneur avec tous les composants
		initDisplay();
		initMenu();
		
		this.setJMenuBar(menuBar);
		this.setContentPane(container);
		this.setVisible(true);
	}

	private void initMenu() {
		
	    leave.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent arg0) {
	          System.exit(0);
	        }      
	      });
	    
		game.add(newGame);
	    game.addSeparator();
	    game.add(leave);	      
	    menuBar.add(game);
	}
	
	private void initDisplay() {
		
		// TODO Auto-generated method stub
		GridBagLayout gl = new GridBagLayout();
		//L'objet servant à positionner les composants
		GridBagConstraints gbc = new GridBagConstraints();
		//On positionne la case de départ du composant
		gbc.gridx = 0;
		gbc.gridy = 0;
		//La taille en hauteur et en largeur
		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		container.setLayout(gl);
		for (JButton[] cellLine : cells) {
			for (JButton cell : cellLine) {
				cell = new JButton();
				cell.setActionCommand(String.valueOf(gbc.gridx)+String.valueOf(gbc.gridy));
				cell.setName(String.valueOf(gbc.gridx)+String.valueOf(gbc.gridy));
				cell.setPreferredSize(new Dimension(90,90));				
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
	
	public void refreshDisplay(Plate gamePlate) {
		
		pieces = gamePlate.getPlate();

		for(int i =0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				cells[j][i].setIcon(pieces[j][i].getIcon());
				cells[j][i].addActionListener(Listener);
				pieces[j][i].show();
		    }
		}
	}
	
	class Selection implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			
			int posX;
			int posY;
			
			if (compteurClics == 0)
			{			
			// position de la cellule
			String positionDebut = e.getActionCommand();
			int xd = Integer.parseInt(String.valueOf(positionDebut.charAt(0)));
			int yd = Integer.parseInt(String.valueOf(positionDebut.charAt(1)));
			
			posX = xd;
			posY = yd;
			
			compteurClics++;
			}

			if (compteurClics == 2)
			{			
			// position de la cellule
			String positionFin = e.getActionCommand();
			int xf = Integer.parseInt(String.valueOf(positionFin.charAt(0)));
			int yf = Integer.parseInt(String.valueOf(positionFin.charAt(1)));

			// pieces[posX][posY].accessibleCells;
			
			compteurClics=0;
				
			}
			
			

		}
		
	}
}
