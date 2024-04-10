package tic_tac_toe_modules;

public class Cell {
    private int row;

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    private int col;
    private Player player;
    private CellState cellState;

    public Cell(int col, int row) {
        this.col = col;
        this.row = row;
        this.cellState = CellState.EMPTY;
    }

    public void isDisplay() {
        if(CellState.FILLED== cellState){
            System.out.print("| "+player.getSymbol()+" |");
        }
        if(CellState.EMPTY==cellState){
            System.out.print("| - |");
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
}
