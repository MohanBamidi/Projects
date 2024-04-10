package tic_tac_toe_BotStratergies;

import tic_tac_toe_modules.Board;
import tic_tac_toe_modules.Cell;

public interface BotPlayingStratergy {
    public Cell makeMove(Board board);
}
