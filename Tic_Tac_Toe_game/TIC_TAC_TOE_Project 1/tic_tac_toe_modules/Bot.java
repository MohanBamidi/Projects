package tic_tac_toe_modules;

import tic_tac_toe_BotStratergies.BotPlayingStratergy;
import tic_tac_toe_BotStratergies.BotPlayingStratergyFactory;

public class Bot extends Player{
    private DifficultyLevel difficultyLevel;
    private BotPlayingStratergy botPlayingStratergy;
    public Bot(char symbol, String name, int id, PlayerType playerType, DifficultyLevel difficultyLevel) {
        super(symbol, name, id, playerType);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStratergy = BotPlayingStratergyFactory.getBotPlayingStratergy(difficultyLevel);
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;

    }

    @Override
    public Cell makeMove(Board board) {
        System.out.println("Bot its your turn");
        Cell cell = botPlayingStratergy.makeMove(board);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return cell;
    }


}
