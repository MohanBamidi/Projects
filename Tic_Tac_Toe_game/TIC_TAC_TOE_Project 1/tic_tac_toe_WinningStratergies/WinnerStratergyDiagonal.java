package tic_tac_toe_WinningStratergies;

import tic_tac_toe_modules.Board;
import tic_tac_toe_modules.Cell;
import tic_tac_toe_modules.Moves;

import java.util.HashMap;
import java.util.Map;

public class WinnerStratergyDiagonal implements WinningStratergy {
    Map<Character,Integer> leftDiagonal = new HashMap<>();
    Map<Character,Integer> rightDiagonal = new HashMap<>();


    public void undoMove(Moves move, Board board) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();
        if(row==col){
            if(leftDiagonal.containsKey(symbol)){
                leftDiagonal.put(symbol,leftDiagonal.get(symbol)-1);
            }
        }
        if(row+col == board.getDimension() -1) {
            if (rightDiagonal.containsKey(symbol)) {
                rightDiagonal.put(symbol, rightDiagonal.get(symbol) - 1);
            }
        }
    }

    @Override
    public boolean checkWinner(Board board, Moves move) {

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        //left diagonal
        if(row==col) {
            if (!leftDiagonal.containsKey(move.getPlayer().getSymbol())) {
                leftDiagonal.put(move.getPlayer().getSymbol(), 0);
            }
            leftDiagonal.put(move.getPlayer().getSymbol(), leftDiagonal.get(move.getPlayer().getSymbol()) + 1);

            if (leftDiagonal.get(move.getPlayer().getSymbol()) == board.getDimension()) {
                return true;
            }
        }
        // right diagonal
        if((row+col)==board.getDimension()-1) {
            if (!rightDiagonal.containsKey(move.getPlayer().getSymbol())) {
                rightDiagonal.put(move.getPlayer().getSymbol(), 0);
            }
            rightDiagonal.put(move.getPlayer().getSymbol(), rightDiagonal.get(move.getPlayer().getSymbol()) + 1);

            if (rightDiagonal.get(move.getPlayer().getSymbol()) == board.getDimension()) {
                return true;
            }
        }
        return false;
    }
}
