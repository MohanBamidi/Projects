package tic_tac_toe_modules;

import java.util.Scanner;

public class Player {
    private char symbol;
    private String name;
    private int id;
    private PlayerType playerType;
    private Scanner sc ;
    public Player(char symbol, String name, int id, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.id = id;
        this.playerType = playerType;
        this.sc = new Scanner(System.in);
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Cell makeMove(Board board) {
         // make player movement in a board
        System.out.println(getName()+", make move by entering row and col position");
        int row = sc.nextInt();
        int col = sc.nextInt();

        while(validateInvalidMove(row,col,board)==false){
            System.out.println(getName()+", have entered invalid position please enter correct position");
            row = sc.nextInt();
            col = sc.nextInt();
        }
        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);

        return cell;
    }

    private boolean validateInvalidMove(int row, int col, Board board) {
        if(row>= board.getDimension() || row<0){
            return false;
        }
        if(col>= board.getDimension() || col<0){
            return false;
        }
        if(CellState.FILLED.equals(board.getBoard().get(row).get(col).getCellState())){
            return false;
        }
        return  true;

    }
}
