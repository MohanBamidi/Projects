package tic_tac_toe_modules;

import java.util.ArrayList;
import java.util.List;

import static tic_tac_toe_modules.CellState.EMPTY;

public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public Board(int dimension) {
        this.dimension = dimension;

        board = new ArrayList<>();
        for(int i=0;i<dimension;i++){
            board.add(new ArrayList<>());
            for(int j=0;j<dimension;j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public int getDimension() {

        return dimension;
    }

    public void setDimension(int dimension) {

        this.dimension = dimension;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {

        this.board = board;
    }

    public void printingBoard() {
        for(List<Cell> row: board){
            for(Cell cell:row){
                cell.isDisplay();
            }
            System.out.println();
        }
    }
}
