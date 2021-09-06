package com.bridgelabz.tictactoe;

public class TicTacToeGame {

	public static void main(String[] args) {
		System.out.println("*** Welcome to Tic Tac Toe Game ***");
		
		startGame();
	}

	private static void startGame() {
		char[] ticTacBoard = new char[10];
		for(int index = 0; index < ticTacBoard.length; index++) {
			ticTacBoard[index] = ' ';
		}
	}

}
