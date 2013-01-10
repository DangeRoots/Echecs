package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import game.Plate;
import junit.framework.TestCase;

import org.junit.Test;

import pieces.*;

public class MoveTestsCase extends TestCase {

	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

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
	}
}
