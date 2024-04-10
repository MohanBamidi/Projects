package tic_tac_toe_AppLoader;

import tic_tac_toe_Exception.BotCOuntMoreThenOne;
import tic_tac_toe_Exception.DuplicteSymbolExists;
import tic_tac_toe_Exception.PlayerCountMisMatchException;
import tic_tac_toe_WinningStratergies.WinnerStratergyDiagonal;
import tic_tac_toe_WinningStratergies.WinningStartergyColumn;
import tic_tac_toe_WinningStratergies.WinningStartergyRow;
import tic_tac_toe_WinningStratergies.WinningStratergy;
import tic_tac_toe_modules.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tic_tac_toe_modules.DifficultyLevel.EASY;
import static tic_tac_toe_modules.PlayerType.BOT;
import static tic_tac_toe_modules.PlayerType.HUMAN;

public class PlayGame {
    public static void main(String[] args) throws DuplicteSymbolExists, BotCOuntMoreThenOne, PlayerCountMisMatchException {
        Scanner sc = new Scanner(System.in);
        Player p1 = new Player('X',"Mohan",21,HUMAN);
        Player p2 = new Player('0',"xxxxx",000,HUMAN);
        List<Player>players= new ArrayList<>();
        players.add(p1);
        players.add(p2);
        List<WinningStratergy>winningStratergies = new ArrayList<>();
        WinningStartergyRow row = new WinningStartergyRow();
        WinningStartergyColumn column = new WinningStartergyColumn();
        WinnerStratergyDiagonal diagonal = new WinnerStratergyDiagonal();
        winningStratergies.add(row);
        winningStratergies.add(column);
        winningStratergies.add(diagonal);
        int dimension=3;
        GameController gameController = new GameController();
        Game game=gameController.startGame(players,winningStratergies,dimension);

        while (GameState.IN_PROGRESS.equals(game.getGameState())) {
            gameController.displayBoard(game);
            System.out.println("Do you Want to undo? Please enter Y/N");
            String Y = sc.next();
            if (Y.equalsIgnoreCase("Y")) {
                gameController.undoMove(game);
                continue;
            }
            gameController.makeMove(game);

        }
        if(GameState.WINNER.equals(game.getGameState())){
            System.out.println(game.getWinner().getName()+", won the game");
        }if(GameState.DRAW.equals(game.getGameState())){
            System.out.println("oops..... Game tied");
        }
        
    }
}
