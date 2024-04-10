package tic_tac_toe_AppLoader;

import tic_tac_toe_Exception.BotCOuntMoreThenOne;
import tic_tac_toe_Exception.DuplicteSymbolExists;
import tic_tac_toe_Exception.PlayerCountMisMatchException;
import tic_tac_toe_WinningStratergies.WinningStratergy;
import tic_tac_toe_modules.Game;
import tic_tac_toe_modules.Moves;
import tic_tac_toe_modules.Player;

import java.util.List;

public class GameController {

    public Game startGame(List<Player>players, List<WinningStratergy> winningStratergies,int dimension ) throws DuplicteSymbolExists, BotCOuntMoreThenOne, PlayerCountMisMatchException {
        return Game.getBuilder()
                .setPlayerList(players)
                .setWinningStratergy(winningStratergies)
                .setDimension(dimension)
                .build();
    }

    public void displayBoard(Game game){
        game.printBoard();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void undoMove(Game game) {
        game.undoMove();
    }
}
