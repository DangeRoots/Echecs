package tests;

import java.util.ArrayList;

import game.Plate;
import junit.framework.TestCase;

import org.junit.Test;

import pieces.*;

public class MoveTestsCase extends TestCase {

	public void testMoveKings() {
		
		Plate plateau = new Plate();
		King testedPiece = new King();
		testedPiece.setColor("b");
		plateau.setPiece(testedPiece, 0, 7);

		ArrayList<Piece> dispo = new ArrayList<Piece>();
		dispo = testedPiece.accessibleCells(plateau);
		for (int i=0;i<dispo.size();i++)
		{
			System.out.println("Row : " + dispo.get(i).getRow() +" Column : " + dispo.get(i).getColumn());
		}	
		// Placement en 0.7
		assertEquals(3, dispo.size());
	}

	public void testMoveBishops() {
	
		Plate plateau = new Plate();
		Bishop testedPiece = new Bishop();
		testedPiece.setColor("w");
		plateau.setPiece(testedPiece, 4, 4);
	
		ArrayList<Piece> dispo = new ArrayList<Piece>();
		dispo = testedPiece.accessibleCells(plateau);
		for (int i=0;i<dispo.size();i++)
		{
			System.out.println("Row : " + dispo.get(i).getRow() +" Column : " + dispo.get(i).getColumn());
		}
		// Placement en 4.4
		assertEquals(13, dispo.size());
	}
	
	public void testMoveKnights() {
		Plate plateau = new Plate();
		Knight testedPiece = new Knight();
		testedPiece.setColor("b");
		plateau.setPiece(testedPiece, 3, 5);
	
		ArrayList<Piece> dispo = new ArrayList<Piece>();
		dispo = testedPiece.accessibleCells(plateau);
		for (int i=0;i<dispo.size();i++)
		{
			System.out.println("Row : " + dispo.get(i).getRow() +" Column : " + dispo.get(i).getColumn());
		}	
		// Placement en 3.5
		assertEquals(8, dispo.size());
	} 

	public void testMovePawns() {
		Plate plateau = new Plate();
		Pawn testedPiece = new Pawn();
		testedPiece.setColor("w");
		plateau.setPiece(testedPiece, 5, 6);
	
		ArrayList<Piece> dispo = new ArrayList<Piece>();
		dispo = testedPiece.accessibleCells(plateau);
		for (int i=0;i<dispo.size();i++)
		{
			System.out.println("Row : " + dispo.get(i).getRow() +" Column : " + dispo.get(i).getColumn());
		}
		// Placement en 5.6
		assertEquals(1, dispo.size());
	}
	
	public void testMoveQueens() {
		Plate plateau = new Plate();
		Queen testedPiece = new Queen();
		testedPiece.setColor("w");
		plateau.setPiece(testedPiece, 1, 6);
	
		ArrayList<Piece> dispo = new ArrayList<Piece>();
		dispo = testedPiece.accessibleCells(plateau);
		for (int i=0;i<dispo.size();i++)
		{
			System.out.println("Row : " + dispo.get(i).getRow() +" Column : " + dispo.get(i).getColumn());
		}
		// Placement en 1.6
		assertEquals(23, dispo.size());
	}
	
	public void testMoveRooks() {
		Plate plateau = new Plate();
		Rook testedPiece = new Rook();
		testedPiece.setColor("w");
		plateau.setPiece(testedPiece, 5, 6);
	
		ArrayList<Piece> dispo = new ArrayList<Piece>();
		dispo = testedPiece.accessibleCells(plateau);
		for (int i=0;i<dispo.size();i++)
		{
			System.out.println("Row : " + dispo.get(i).getRow() +" Column : " + dispo.get(i).getColumn());
		}
		// Placement en 5.6
		System.out.println(dispo.size());
		assertEquals(14, dispo.size());
	}
}
