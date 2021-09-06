package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

	private static char[] startGame() {
		char[] ticTacBoard = new char[10];
		for (int index = 0; index < ticTacBoard.length; index++) {
			ticTacBoard[index] = ' ';
		}
		return ticTacBoard;
	}

	private static char getInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter charecter 'X' or 'O'");
		char playerSymbol = scanner.next().toUpperCase().charAt(0);
		scanner.close();
		return playerSymbol;
	}

	public static void main(String[] args) {
		System.out.println("*** Welcome to Tic Tac Toe Game ***");

		char[] board = startGame();
		char playerSymbol = getInput();
		char computerSymbol = (playerSymbol == 'X') ? 'O' : 'X';
	}

}
