package com.bridgelabz.tictactoe;

public class TicTacToeGame {

	public static void main(String[] args) {
		System.out.println("*** Welcome to Tic Tac Toe Game ***");
		
		char[] board = startGame();
	}

	private static char[] startGame() {
		char[] ticTacBoard = new char[10];
		for(int index = 0; index < ticTacBoard.length; index++) {
			ticTacBoard[index] = ' ';
		}
		return ticTacBoard;
	}

}
