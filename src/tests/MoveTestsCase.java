package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import game.Plate;
import junit.framework.TestCase;

import org.junit.Test;

import pieces.*;

public class MoveTestsCase extends TestCase {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	public void testMoveKings() {
		
		Plate plateau = new Plate();
		King king = new King();
		king.setColor("w");
		plateau.setPiece(king, 0, 7);
		
		ArrayList<Piece> dispo = new ArrayList<Piece>();
		dispo = king.accessibleCells(plateau);
		for (int i=0;i<dispo.size();i++)
		{
			System.out.println("Row : " + dispo.get(i).getRow() +" Col : " + dispo.get(i).getColumn());
		}	
	}

	public void testMoveBishops() {
	
		/** Problemes d'indices */
		Plate plateau = new Plate();
		Bishop bishop = new Bishop();
		bishop.setColor("w");
		plateau.setPiece(bishop, 0, 7);
	
		ArrayList<Piece> dispo = new ArrayList<Piece>();
		dispo = bishop.accessibleCells(plateau);
		for (int i=0;i<dispo.size();i++)
		{
			System.out.println("Row : " + dispo.get(i).getRow() +" Col : " + dispo.get(i).getColumn());
		}
	}
	
//	public void testMoveKnights() {
//		
//	} 
//
//	public void testMovePawns() {
//		
//	}
//	
//	public void testMoveQueens() {
//		
//	}
//	
//	public void testMoveRooks() {
//		
//	}
}
