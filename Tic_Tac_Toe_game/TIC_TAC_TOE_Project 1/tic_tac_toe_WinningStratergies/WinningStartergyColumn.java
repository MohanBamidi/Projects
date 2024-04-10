package tic_tac_toe_WinningStratergies;

import tic_tac_toe_modules.Board;
import tic_tac_toe_modules.Moves;

import java.util.HashMap;
import java.util.Map;

public class WinningStartergyColumn implements WinningStratergy {
    private Map<Integer, Map<Character,Integer>> map = new HashMap<>();

    public void undoMove(Moves move, Board board) {
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();
        Map<Character, Integer>rowMap= map.get(col);
        if(rowMap.containsKey(symbol)){
            rowMap.put(symbol,rowMap.get(symbol)-1);
        }

    }

    @Override
    public boolean checkWinner(Board board, Moves move) {
        int column = move.getCell().getCol();
        if(!map.containsKey(column)){
            map.put(column,new HashMap<>());
        }
        Map<Character, Integer> columnMap = map.get(column);
        if(!columnMap.containsKey(move.getPlayer().getSymbol())){
            columnMap.put(move.getPlayer().getSymbol(),0);
        }
        columnMap.put(move.getPlayer().getSymbol(), columnMap.get(move.getPlayer().getSymbol())+1);

        if(columnMap.get(move.getPlayer().getSymbol())== board.getDimension()){
            return true;
        }
        return false;
    }
}
