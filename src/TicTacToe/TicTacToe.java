import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        char currentPlayer = 'X';
        boolean gameEnded = false;
        while (!gameEnded) {
            printGameBoard(board);
            makeMove(board, scanner, currentPlayer);
            gameEnded = isGameFinished(board, currentPlayer);
            if (!gameEnded) {
                currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
            }
        }
        printGameBoard(board);
    }
    private static void printGameBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    private static void makeMove(char[][] board, Scanner scanner, char player) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            try {
                int row = Integer.parseInt(parts[0]) - 1;
                int col = Integer.parseInt(parts[1]) - 1;

                if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (board[row][col] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    board[row][col] = player;
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
    private static boolean isGameFinished(char[][] board, char currentPlayer) {
        if (isWinner(board, currentPlayer)) {
            System.out.println(currentPlayer + " wins");
            return true;
        } else if (isBoardFull(board)) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }
    private static boolean isWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
