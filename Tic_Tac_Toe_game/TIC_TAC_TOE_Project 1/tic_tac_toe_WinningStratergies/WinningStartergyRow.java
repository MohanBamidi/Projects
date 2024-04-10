package tic_tac_toe_WinningStratergies;

import tic_tac_toe_modules.Board;
import tic_tac_toe_modules.Moves;

import java.util.HashMap;
import java.util.Map;

public class WinningStartergyRow implements WinningStratergy {
    private Map<Integer, Map<Character,Integer>> map = new HashMap<>();

    @Override
    public void undoMove(Moves move, Board board) {
        int row = move.getCell().getRow();
        char symbol = move.getPlayer().getSymbol();
        Map<Character, Integer>rowMap= map.get(row);
        if(rowMap.containsKey(symbol)){
            rowMap.put(symbol,rowMap.get(symbol)-1);
        }


    }

    @Override
    public boolean checkWinner(Board board, Moves move) {


        int row = move.getCell().getRow();
        if(!map.containsKey(row)){
            map.put(row,new HashMap<>());
        }
        Map<Character, Integer> rowMap = map.get(row);
        if(!rowMap.containsKey(move.getPlayer().getSymbol())){
            rowMap.put(move.getPlayer().getSymbol(),0);
        }
        rowMap.put(move.getPlayer().getSymbol(), rowMap.get(move.getPlayer().getSymbol())+1);

        if(rowMap.get(move.getPlayer().getSymbol())== board.getDimension()){
            return true;
        }
        return false;
    }

}
