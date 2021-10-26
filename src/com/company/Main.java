package com.company;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){startGame();}


    private static Scanner sc = new Scanner(System.in);
    private static char[] board = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static int[] playerBoard = new int[9];
    private static byte round = 0;
    private static int[][] combinations = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {1, 5, 9},
            {3, 5, 7},
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
    };
    private static void printBoard() {


        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);

    }
    private static byte boardCount = 0;



    private static void gameTurn() {
        printBoard();
        int vyber;
        int clear = 0;

        do {
            System.out.print("Please write number 1-9: ");



            vyber = sc.nextInt();


            int arrayIdChoose = vyber;


            if (Arrays.stream(playerBoard).anyMatch(i -> i == arrayIdChoose)) {
                System.out.println("Wrong number... Try next");
            }
            else {
                clear++;
            }
        }



        while (clear == 0);
        if (round % 2 == 0) { board[vyber] = 'X';
        }
        else {board[vyber] = 'O';}
        playerBoard[boardCount] = vyber;
        boardCount++;
        round++;
        gameCheck();
    }



    private static String[] zprava = {"player: X is playing", "player: O is playing"};

    private static void startGame() {
        System.out.println("\n" + zprava[round % 2]);   gameTurn(); }


    private static void gameCheck() {

        if (round < 10) {
            for (int i = 0; i < 2; i++) {char pChecks;
                if (i == 0) {pChecks = 'X';
                }
                else {pChecks = 'O';
                }for (int j = 0; j < combinations.length; j++) {
                    if (board[ combinations[j][1]]  == pChecks &&  board[combinations[j][2]] ==  pChecks &&  board[combinations[j][0]] == pChecks ) {printBoard();
                        konec();
                        return;}}
            }startGame();
        }

        else { printBoard();System.out.println("Roll!");}}

    private static void konec() {

        if (round % 2 == 0) { System.out.println("O is winner");
        }
        else {System.out.println("X is winner");}
    }
}