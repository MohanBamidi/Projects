package tic_tac_toe_modules;


import tic_tac_toe_Exception.BotCOuntMoreThenOne;
import tic_tac_toe_Exception.DuplicteSymbolExists;
import tic_tac_toe_Exception.PlayerCountMisMatchException;
import tic_tac_toe_WinningStratergies.WinningStratergy;

import javax.swing.*;
import java.util.*;

import static tic_tac_toe_modules.PlayerType.BOT;

public class Game {
    private List<Player> playerList;
    private List<Moves>moves;
    private Board board;
    private GameState gameState;
    private List<WinningStratergy> winningStratergy;
    private Player winner ;
    private int dimension;
    private  int nextIndexOfPlayer;
    private Scanner sc;
    public Game(List<Player> playerList, List<WinningStratergy> winningStratergy, int dimension) {
        this.board= new Board(dimension);
        this.playerList = playerList;
        this.winningStratergy = winningStratergy;
        this.nextIndexOfPlayer = 0;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.sc = new Scanner(System.in);
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }


    public List<WinningStratergy> getWinningStratergy() {
        return winningStratergy;
    }

    public void setWinningStratergy(List<WinningStratergy> winningStratergy) {
        this.winningStratergy = winningStratergy;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }
    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public void printBoard() {
        board.printingBoard();
    }

    public Player getWinner() {
        return winner;
    }

    public void makeMove() {
     Player player = playerList.get(nextIndexOfPlayer);
     Cell cell = player.makeMove(board);
     Moves move = new Moves(cell,player);
     moves.add(move);

      if(checkWinner(move,board)){
          gameState = GameState.WINNER;
          winner = player;
            return;
      }
      if(moves.size() == board.getDimension()*board.getDimension()){
              gameState = GameState.DRAW;
              return;
      }
      nextIndexOfPlayer++;
      nextIndexOfPlayer = nextIndexOfPlayer%playerList.size();

    }

    private boolean checkWinner(Moves move, Board board) {
        for(WinningStratergy winningStratergy : winningStratergy ){
                if(winningStratergy.checkWinner(board, move)){
                    return true;
                }
        }
        return  false;
    }
    public void undoMove(){
        if(moves.size()<=0){
            System.out.println("NO moves to undo");
            return;
        }
        Moves move = moves.get(moves.size()-1);
        moves.remove(moves.getLast());
        Cell cell = move.getCell();
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);
        if(moves.size()>1 &&PlayerType.BOT.equals(moves.getLast().getPlayer().getPlayerType())){
            System.out.println("No undo for BOT ");
            return;
        }
        for (WinningStratergy winningStratergy: winningStratergy){
            winningStratergy.undoMove(move,board);
        }
        if (nextIndexOfPlayer!=0 ) {
            nextIndexOfPlayer--;

        } else {
            nextIndexOfPlayer = getPlayerList().size()-1;
        }
    }
    // Builder Class
    public static class GameBuilder {
        private int dimension;
        private List<Player> playerList;
        private Board board;
        private GameState gameState;
        private List<WinningStratergy> winningStratergy;


        public Game build() throws BotCOuntMoreThenOne, DuplicteSymbolExists, PlayerCountMisMatchException {
           //Validation
            validateOneBotOnly();
            validateUniqueSymbol();
            validateDimensionAndPlayerCount();
            return new Game(playerList,winningStratergy,dimension);
        }

        private void validateDimensionAndPlayerCount() throws PlayerCountMisMatchException {
             if(playerList.size()!= dimension-1){
                 throw new PlayerCountMisMatchException();
             }

        }
        private void validateOneBotOnly() throws BotCOuntMoreThenOne {
           int botCount=0;
           for(Player player: playerList){
               if(PlayerType.BOT==player.getPlayerType()) {
                   botCount++;
               }
               if(botCount>1){
                   throw new BotCOuntMoreThenOne();
               }
           }
        }

        private void validateUniqueSymbol() throws DuplicteSymbolExists {
            Set<Character> storeUniqueSymbol = new HashSet<>();
            for(Player player : playerList){
                if(storeUniqueSymbol.contains(player.getSymbol())){
                    throw new DuplicteSymbolExists();
                }
                if(!storeUniqueSymbol.contains(player.getSymbol())){
                    storeUniqueSymbol.add(player.getSymbol());
                }
            }
        }
        private GameBuilder() {
            this.playerList = new ArrayList<>();
            this.winningStratergy = new ArrayList<>();
            this.dimension= 0;
        }

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public GameBuilder setPlayerList(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }

        public GameBuilder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public GameBuilder setGameState(GameState gameState) {
            this.gameState = gameState;
            return this;
        }

        public GameBuilder setWinningStratergy(List<WinningStratergy> winningStratergy) {
            this.winningStratergy = winningStratergy;
            return this;
        }




    }
}
