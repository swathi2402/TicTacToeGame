package com.bridgelabz.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

	static Scanner scanner = new Scanner(System.in);
	static char[] board;
	static char playerSymbol;
	static char computerSymbol;

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
			showBoard(board);
		} else {
			System.out.println("Invalid Position");
		}
	}

	private static void computerMove() {
		int computerPosition = new Random().nextInt(9) + 1;
		if (board[computerPosition] == ' ') {
			board[computerPosition] = computerSymbol;
		} else {
			computerPosition = new Random().nextInt(9) + 1;
		}
		showBoard(board);
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

	public static void main(String[] args) {
		System.out.println("*** Welcome to Tic Tac Toe Game ***");

		board = startGame();
		if (Math.random() > 0.5) {
			playerSymbol = getInput();
			computerSymbol = (playerSymbol == 'X') ? 'O' : 'X';
			move();
			computerMove();
		} else {
			if (Math.random() > 0.5) {
				computerSymbol = 'X';
				playerSymbol = 'O';
			} else {
				computerSymbol = 'O';
				playerSymbol = 'X';
			}
			System.out.println("Computer chooses to play first with symbol " + computerSymbol);
			computerMove();
			move();
		}
	}
}
