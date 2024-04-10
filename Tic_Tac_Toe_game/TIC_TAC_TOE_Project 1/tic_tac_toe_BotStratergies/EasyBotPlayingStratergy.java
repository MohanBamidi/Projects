package tic_tac_toe_BotStratergies;

import tic_tac_toe_modules.Board;
import tic_tac_toe_modules.Cell;
import tic_tac_toe_modules.CellState;

import java.util.ArrayList;
import java.util.List;

public class EasyBotPlayingStratergy implements BotPlayingStratergy{
    @Override
    public Cell makeMove(Board board) {
        for(List<Cell> row : board.getBoard()){
            for(Cell cell : row){
                if(CellState.EMPTY.equals(cell.getCellState())){
                    return cell;
                }
            }
        }
        return null ;
    }
}
