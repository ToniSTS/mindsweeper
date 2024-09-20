import java.util.Random;

public class Minesweeper {

    // Data members
    private char[][] board;   // The game board where cells will be displayed
    private boolean[][] mines; // Array to track the locations of mines
    private boolean[][] revealed; // Array to track which cells have been revealed
    private int rows; // Number of rows in the board
    private int cols; // Number of columns in the board
    private int numMines; // Number of mines in the game
    private boolean gameOver; // Boolean to check if the game is over

    // Constructor to initialize the board with the specified dimensions and number of mines
    public Minesweeper(int rows, int cols, int numMines) {
        this.rows = rows;
        this.cols = cols;
        this.numMines = numMines;
        this.board = new char[rows][cols];
        this.mines = new boolean[rows][cols];
        this.revealed = new boolean[rows][cols];
        this.gameOver = false;

        // Call methods to initialize the board and place mines
    }
    public boolean getGameOver(){
        return this.gameOver;
    }
    public void setGameOver(boolean status)
    {
        this.gameOver = status;

    }
    // Method to initialize the game board with empty values
    private void initializeBoard() {
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                this.board[x][y] = ' ';
                revealed[x][y] = false;
            }
        }
    }

    // Method to randomly place mines on the board
    private void placeMines() {
        Random rand = new Random();
        int placeMines = 0;
        // randomly places a number of mines on the game board

        while (placeMines < numMines){
            int row = rand.nextInt(rows);
            int col = rand.nextInt(cols);

            //places a mine if one isnt in that spot already
            if(!mines[row][col]){
                mines[row][col] = true;
                placeMines++;
            }
        }
    }

    // Method to calculate numbers on the board for non-mine cells
    private void calculateNumbers() {
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {

            }
        }

    }

    // Method to display the current state of the board
    public void displayBoard() {
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                if(revealed[x][y]){
                    System.out.print(board[x][y]  + " ");
                } else
                    System.out.println("-");
            }
        }
    }

    // Method to handle a player's move (reveal a cell or place a flag)
    public void playerMove(int row, int col, String action) {
        if(action.equals("reveal")){
            revealCell(row, col);
        } else if(action.equals("mine")){
            flagCell(row, col);
        } else if(action.equals("unflag")){}
        unflagCell(row, col);
    }

    // Method to check if the player has won the game
    public boolean checkWin() {
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                if(mines[x][y] && revealed[x][y]){
                    return true;
                }  // will check if player hit a mine or not and let them know if they win or lose based on that decision
            }
        }
        return false;
    }

    // Method to check if the player has lost the game
    public boolean checkLoss(int row, int col) {
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                if(!mines[x][y] && !revealed[x][y]){
                    return true;
                } // will check if player hit a mine or not and let them know if they win or lose based on that decision
            }
        }
        return false;
    }

    // Method to reveal a cell (and adjacent cells if necessary)
    private void revealCell(int row, int col) {
        if(row < 0 || row >= rows || col < 0 || col >= cols){
            return;
            // checks if the spot is out of bounds or if it has been already revealed
        }
    }

    // Method to flag a cell as containing a mine
    private void flagCell(int row, int col) {
        if(!revealed[row][col]){
            board[row][col] = 'f';
            // allows the player to call a flag on a cell, marking it as a potential mine
        }
    }

    // Method to unflag a cell
    private void unflagCell(int row, int col) {
        if(board[row][col] == 'f'){
            board[row][col] = '*';
            // removes the flag as if a flag was never called
        }

    }
}

