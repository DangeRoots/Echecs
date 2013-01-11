package game;


/****
    * Classe DTimer : 
             gere un compteur de temps ainsi que l'affichage, utilisation du composant javax.swing.Timer 
    *        qui genere un evenement tout les x temps d'intervalle ;
    *        solution qui est plus pratique qu'une classe qui herite de Thread ou implemente l'interface 
    *        Runnable car ces deux dernieres solutions imposent un traitement graphique hors du processus 
    *        d'evenement "the event-dispatching thread" ce qui est normalement deconseille pour ne par dire interdi
    *
    ****/

import javax.swing.*;
import javax.swing.border.*;

import view.Display;

import java.awt.*;
import java.awt.event.*;

public class DTimer extends JButton implements ActionListener
{
	/****
	    * Attributs :
	    *
	    ****/
	//protected JLabel viewTime;  // composant permettant l'affichage du temps ecoule
	protected int timeCount;	// variable permettant de memoriser le temps ecoule
	protected Timer timer;		// objet javax.swing.Timer
	protected int minCount;
	protected String m_name; 
	protected boolean m_timeout;
	protected JFrame game_end;

	/****
	    * Constructeur :
	    *
	    ****/
	// (par defaut) initialise le compteur a 0 et le delay a 1 seconde
	public DTimer (String name)
	{	
		this (60, 14,1000,name);
	}
	
	// construit un timer avec le temps initiale donnee et le delay a 1 seconde
	/*public DTimer (int initialTime)
	{	this (initialTime, 9, 1000);
	}*/
	
	// construit un timer avec le temps et le delay donne
	public DTimer (int initialTime, int initialMin, int delay,String name)
	{	super (name);
		this.m_name=name;
		this.timeCount = initialTime;
		this.minCount = initialMin;
		this.timer = new Timer (delay, this);
		this.initGraphic ();
		this.m_timeout = false;
	}
	
	/****
	    * Methodes :
	    *
	    ****/
	// initialise la partie graphique de la demo
	protected void initGraphic ()
	{	
		this.setText(""+(this.minCount+1)+":00");
		this.addActionListener (this);
		this.setPreferredSize(new Dimension(100,100));
		this.setVisible (true);
	}
	
	protected void initGameOver()
	{
		this.game_end = new JFrame("Partie terminée");
		JPanel container = new JPanel();
		this.game_end.setContentPane(container);
		JLabel game_over_text = new JLabel();
		game_over_text.setText("La partie est terminée, " + this.m_name +" a perdu !");
		
	}
	
	// lance le compteur de temps 
	public void startDTimer ()
	{	this.timer.start ();
	}
	
	// stop le compteur de temps 
	public void stopDTimer ()
	{	this.timer.stop ();
	}
	
	// permet de recuperer le temps deja ecoule
	public int getTime ()
	{	return ( this.timeCount );
	}
	
	// permet de connaitre l'etat d'activite du timer (lance ou non)
	public boolean isRunning ()
	{	return ( this.timer.isRunning () );
	}
	
	public boolean isFinish()
	{
		return this.m_timeout;
	}
	
	/****
	    * Methode de l'interface ActionListener : 
	    *        necessaire pour l'object javax.swing.Timer
	    *        methode appelle a intervalle de temps regulier par le timer
	    *        (utilise egalement par le bouton pour stopper et lancer le timer
	    *         la difference ce fait via l'instruction getActionCommand)
	    *
	    ****/
	public void actionPerformed (ActionEvent e)
	{	// Cas d'un evenement genere par le bouton
		/*if ( "Bouton".equals (e.getActionCommand ()) )
		{	// le timer est en court d'execution donc on l'arrete
			if ( this.isRunning () )
			{	this.stopDTimer ();
			}
			else // le timer est arrete donc on le lance ou relance
			{	this.startDTimer ();
			}
		}*/
		// Cas d'un evenement genere par le composant javax.swing.Timer
			this.timeCount--;
			if (timeCount == -1)
			{
				this.minCount--;
				this.timeCount = 59;
				if (minCount == -1)
					this.m_timeout = true;
					this.stopDTimer();
			}
			if (timeCount < 10)
				this.setText (""+this.minCount+":0"+this.timeCount);
			else
				this.setText (""+this.minCount+":"+this.timeCount);
		
	}

	/*public static void main (String argv [])
	{	new DTimer ();
	}*/
}