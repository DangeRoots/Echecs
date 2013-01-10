package tests;

import java.util.ArrayList;

import pieces.*;
import game.Plate;
import junit.framework.TestCase;


public class MoveTestsCaseCapablanca extends TestCase {

	public void testMoveKings() {
		
		Plate plateau = new Plate("capablanca");
		//Plate plateau = new Plate();
		System.out.println("Taille du plateau : " + plateau.getBoardSize());
		King testedPiece = new King();
		testedPiece.setColor("b");
		plateau.setPiece(testedPiece, 0, 8);

		ArrayList<Piece> dispo = new ArrayList<Piece>();
		dispo = testedPiece.accessibleCells(plateau);
		for (int i=0;i<dispo.size();i++)
		{
			System.out.println("Row : " + dispo.get(i).getRow() +" Column : " + dispo.get(i).getColumn());
		}	
	}
	
	public void testMoveBishop() {
		
		Plate plateau = new Plate("capablanca");
		//Plate plateau = new Plate();
		System.out.println("Taille du plateau : " + plateau.getBoardSize());
		Bishop testedPiece = new Bishop();
		testedPiece.setColor("b");
		plateau.setPiece(testedPiece, 0, 7);

		ArrayList<Piece> dispo = new ArrayList<Piece>();
		dispo = testedPiece.accessibleCells(plateau);
		for (int i=0;i<dispo.size();i++)
		{
			System.out.println("Row : " + dispo.get(i).getRow() +" Column : " + dispo.get(i).getColumn());
		}	
	}
	
	public void testMoveQueen() {
		
		Plate plateau = new Plate("capablanca");
		//Plate plateau = new Plate();
		System.out.println("Taille du plateau : " + plateau.getBoardSize());
		Queen testedPiece = new Queen();
		testedPiece.setColor("b");
		plateau.setPiece(testedPiece, 0, 5);

		ArrayList<Piece> dispo = new ArrayList<Piece>();
		dispo = testedPiece.accessibleCells(plateau);
		for (int i=0;i<dispo.size();i++)
		{
			System.out.println("Row : " + dispo.get(i).getRow() +" Column : " + dispo.get(i).getColumn());
		}	
	}
	
	public void testMovePawn() {
		
		Plate plateau = new Plate("capablanca");
		//Plate plateau = new Plate();
		System.out.println("Taille du plateau : " + plateau.getBoardSize());
		Pawn testedPiece = new Pawn();
		testedPiece.setColor("b");
		plateau.setPiece(testedPiece, 1, 9);

		ArrayList<Piece> dispo = new ArrayList<Piece>();
		dispo = testedPiece.accessibleCells(plateau);
		for (int i=0;i<dispo.size();i++)
		{
			System.out.println("Row : " + dispo.get(i).getRow() +" Column : " + dispo.get(i).getColumn());
		}	
	}
	
	public void testMoveKnight() {
		
		Plate plateau = new Plate("capablanca");
		//Plate plateau = new Plate();
		System.out.println("Taille du plateau : " + plateau.getBoardSize());
		Knight testedPiece = new Knight();
		testedPiece.setColor("b");
		plateau.setPiece(testedPiece, 4, 8);

		ArrayList<Piece> dispo = new ArrayList<Piece>();
		dispo = testedPiece.accessibleCells(plateau);
		for (int i=0;i<dispo.size();i++)
		{
			System.out.println("Row : " + dispo.get(i).getRow() +" Column : " + dispo.get(i).getColumn());
		}	
	}
}
