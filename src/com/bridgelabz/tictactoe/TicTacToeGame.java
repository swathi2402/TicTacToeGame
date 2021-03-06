package com.bridgelabz.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

	static Scanner scanner = new Scanner(System.in);
	static char[] board;
	static char playerSymbol;
	static char computerSymbol;
	static int winningStates[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 },
			{ 1, 5, 9 }, { 3, 5, 7 } };

	private static char[] startGame() {
		char[] ticTacBoard = new char[10];
		for (int index = 0; index < ticTacBoard.length; index++) {
			ticTacBoard[index] = ' ';
		}
		return ticTacBoard;
	}

	private static char getInput() {
		System.out.println("Enter charecter 'X' or 'O'");
		return scanner.next().toUpperCase().charAt(0);
	}

	private static void move() {
		System.out.println("Enter the position 1 to 9 to move");
		int playerPosition = scanner.nextInt();
		if (playerPosition > 0 && playerPosition < 10) {
			if (board[playerPosition] == ' ') {
				board[playerPosition] = playerSymbol;
			} else {
				System.out.println("Position already occupied");
				move();
			}

		} else {
			System.out.println("Invalid Position");
		}
		showBoard(board);

		if (findWinner(playerSymbol)) {
			System.out.println("You won the game");
			System.out.println("\nNew game starts...\n");
			board = startGame();
			randomStart();
		}

		if (!isTie()) {
			System.out.println("There is no more move");
			System.out.println("\nNew game starts...\n");
			board = startGame();
			randomStart();
		}
	}

	private static void computerMove() {
		if (isTie()) {
			int turnOfCorner = 0;

			int combinationOfThreeItems[][] = { { 0, 1, 2 }, { 1, 0, 2 }, { 1, 2, 0 } };
			if (turnOfCorner == 0) {
				for (int state = 0; state < winningStates.length; state++) {
					for (int nthCombination = 0; nthCombination < combinationOfThreeItems.length; nthCombination++) {

						if (board[winningStates[state][combinationOfThreeItems[nthCombination][0]]] == computerSymbol
								&& board[winningStates[state][combinationOfThreeItems[nthCombination][1]]] == computerSymbol
								&& board[winningStates[state][combinationOfThreeItems[nthCombination][2]]] == ' ') {

							board[winningStates[state][combinationOfThreeItems[nthCombination][2]]] = computerSymbol;
							break;
						} else
							turnOfCorner = 1;
					}
				}
			}

			if (turnOfCorner == 1) {
				for (int state = 0; state < winningStates.length; state++) {
					for (int nthCombination = 0; nthCombination < combinationOfThreeItems.length; nthCombination++) {

						if (board[winningStates[state][combinationOfThreeItems[nthCombination][0]]] == playerSymbol
								&& board[winningStates[state][combinationOfThreeItems[nthCombination][1]]] == playerSymbol
								&& board[winningStates[state][combinationOfThreeItems[nthCombination][2]]] == ' ') {

							board[winningStates[state][combinationOfThreeItems[nthCombination][2]]] = computerSymbol;
							break;
						} else
							turnOfCorner = 2;
					}
				}
			}

			if (turnOfCorner == 2) {
				if (board[1] == ' ') {
					board[1] = computerSymbol;
				} else if (board[3] == ' ') {
					board[3] = computerSymbol;
				} else if (board[7] == ' ') {
					board[7] = computerSymbol;
				} else if (board[9] == ' ') {
					board[9] = computerSymbol;
				} else
					turnOfCorner = 3;
			}

			if (turnOfCorner == 3) {
				if (board[5] == ' ') {
					board[5] = computerSymbol;
				} else
					turnOfCorner = 4;
			}

			if (turnOfCorner == 4) {

				int computerPosition = new Random().nextInt(9) + 1;
				if (board[computerPosition] == ' ') {
					board[computerPosition] = computerSymbol;
				} else {
					computerMove();
				}
			}

			showBoard(board);

			if (findWinner(computerSymbol)) {
				System.out.println("Computer won the game");
				System.out.println("\nNew game starts...\n");
				board = startGame();
				randomStart();
			}

			if (!isTie()) {
				System.out.println("There is no more move");
				System.out.println("\nNew game starts...\n");
				board = startGame();
				randomStart();
			}

		}
	}

	private static boolean findWinner(char symbol) {
		if (board[1] == symbol && board[5] == symbol && board[9] == symbol) {
			return true;
		}

		if (board[3] == symbol && board[5] == symbol && board[7] == symbol) {
			return true;
		}

		for (int index = 1; index < 4; index++) {
			if (board[index] == symbol && board[index + 3] == symbol && board[index + 6] == symbol)
				return true;
		}

		for (int index = 1; index < 10;) {
			if (board[index] != symbol) {
				index += 3;
				break;
			}
			if (index % 3 == 0)
				return true;

			index += 1;
		}

		return false;
	}

	private static boolean isTie() {
		for (int index = 1; index < board.length; index++) {
			if (board[index] == ' ') {
				return true;
			}
		}
		return false;
	}

	private static void showBoard(char[] board) {
		System.out.println("Current state of board: ");
		for (int index = 1; index < 10; index++) {
			System.out.print(board[index] + " | ");
			if (index % 3 == 0) {
				System.out.println();
			}
		}
	}

	private static void randomStart() {
		if (Math.random() > 0.5) {
			playerSymbol = getInput();
			computerSymbol = (playerSymbol == 'X') ? 'O' : 'X';

			while (!findWinner(playerSymbol) && isTie()) {
				if (!findWinner(computerSymbol) && isTie()) {
					move();
					computerMove();
				}
			}

		} else {
			if (Math.random() > 0.5) {
				computerSymbol = 'X';
				playerSymbol = 'O';
			} else {
				computerSymbol = 'O';
				playerSymbol = 'X';
			}

			System.out.println("Computer chooses to play first with symbol " + computerSymbol);
			while (!findWinner(playerSymbol) && isTie()) {
				if (!findWinner(computerSymbol) && isTie()) {
					computerMove();
					move();
				}
			}

		}

	}

	public static void main(String[] args) {
		System.out.println("*** Welcome to Tic Tac Toe Game ***");

		board = startGame();
		randomStart();
	}
}