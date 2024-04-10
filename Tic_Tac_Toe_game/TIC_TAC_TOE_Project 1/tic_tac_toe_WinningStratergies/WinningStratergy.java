package tic_tac_toe_WinningStratergies;

import tic_tac_toe_modules.Board;
import tic_tac_toe_modules.Moves;

public interface WinningStratergy {

    void undoMove(Moves move, Board board);

    boolean checkWinner(Board board, Moves move);
}
