package week_9_exercises;

import java.util.Scanner;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;
import pieces.config.ColourEnum;
import utility.Console;

public class Main 
{
	private final static String EMPTY_TILE="X  ";
	private static final int ROW_NUMBER=8;
	private static final int COL_NUMBER=8;
	private static Piece gameboard[][]=new Piece[ROW_NUMBER][COL_NUMBER];
	
	public static void render()
	{
		for(int row=0; row<ROW_NUMBER; row++)
		{
			for(int col=0; col<COL_NUMBER; col++)
			{
				Piece gameboardElement=gameboard[row][col];
				String sign=(gameboardElement==null) ? EMPTY_TILE : gameboardElement.getSign()+" ";
				System.out.print(sign);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) 
	{
		gameboard[0][0]=new Rook  (0, 0, ColourEnum.WHITE);
		gameboard[0][7]=new Rook  (0, 7, ColourEnum.WHITE);
		
		gameboard[0][1]=new Knight(0, 1, ColourEnum.WHITE);
		gameboard[0][6]=new Knight(0, 6, ColourEnum.WHITE);
		
		gameboard[0][2]=new Bishop(0, 2, ColourEnum.WHITE);
		gameboard[0][5]=new Bishop(0, 5, ColourEnum.WHITE);
		
		gameboard[0][3]=new Queen (0, 3, ColourEnum.WHITE);
		gameboard[0][4]=new King  (0, 4, ColourEnum.WHITE);
		
		gameboard[1][0]=new Pawn  (1, 0, ColourEnum.WHITE);
		gameboard[1][1]=new Pawn  (1, 1, ColourEnum.WHITE);
		gameboard[1][2]=new Pawn  (1, 2, ColourEnum.WHITE);
		gameboard[1][3]=new Pawn  (1, 3, ColourEnum.WHITE);
		gameboard[1][4]=new Pawn  (1, 4, ColourEnum.WHITE);
		gameboard[1][5]=new Pawn  (1, 5, ColourEnum.WHITE);
		gameboard[1][6]=new Pawn  (1, 6, ColourEnum.WHITE);
		gameboard[1][7]=new Pawn  (1, 7, ColourEnum.WHITE);
		
		gameboard[7][0]=new Rook  (7, 0, ColourEnum.BLACK);
		gameboard[7][7]=new Rook  (7, 7, ColourEnum.BLACK);
		
		gameboard[7][1]=new Knight(7, 1, ColourEnum.BLACK);
		gameboard[7][6]=new Knight(7, 6, ColourEnum.BLACK);
		
		gameboard[7][2]=new Bishop(7, 2, ColourEnum.BLACK);
		gameboard[7][5]=new Bishop(7, 5, ColourEnum.BLACK);
		
		gameboard[7][3]=new Queen (7, 3, ColourEnum.BLACK);
		gameboard[7][4]=new King  (7, 4, ColourEnum.BLACK);
		
		gameboard[6][0]=new Pawn  (6, 0, ColourEnum.BLACK);
		gameboard[6][1]=new Pawn  (6, 1, ColourEnum.BLACK);
		gameboard[6][2]=new Pawn  (6, 2, ColourEnum.BLACK);
		gameboard[6][3]=new Pawn  (6, 3, ColourEnum.BLACK);
		gameboard[6][4]=new Pawn  (6, 4, ColourEnum.BLACK);
		gameboard[6][5]=new Pawn  (6, 5, ColourEnum.BLACK);
		gameboard[6][6]=new Pawn  (6, 6, ColourEnum.BLACK);
		gameboard[6][7]=new Pawn  (6, 7, ColourEnum.BLACK);
		
		render();
		
		// избираме фигура, която ще местим
		int selectRow=Console.input("Въведете ROW: ");
		int selectCol=Console.input("Въведете COL: ");
		Piece selectedPiece=gameboard[selectRow][selectCol];
		
		// избираме дестинация на тази фигура
		int moveRow=Console.input("Въведете ROW за придвижване: ");
		int moveCol=Console.input("Въведете COL за придвижване: ");
		
		if(selectedPiece.isMovePossible(moveRow, moveCol))
		{
			// изтриваме текущата фигура от дъската
			gameboard[selectRow][selectCol]=null;
			
			//
			selectedPiece.move(moveRow, moveCol);
			
			// добавяме селектираната фигура към новите координати на дъската
			gameboard[moveRow][moveCol]=selectedPiece;
		}
		else
		{
			System.out.println("Невалидно придвижване!");
		}
		
		render();
	}
	
}
