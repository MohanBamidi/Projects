package tic_tac_toe_modules;

public class Moves {
    private Player player;
    private Cell cell;

    public Moves(Cell cell, Player player) {
        this.cell = cell;
        this.player= player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
