package org.academiadecodigo.rhashtafaris.projectninja;

public class LogicPosition {

    private int col;
    private int row;
    private SimpleGfxGrid grid;

    public LogicPosition(int col, int row, SimpleGfxGrid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    public SimpleGfxGrid getGrid() {
        return this.grid;
    }

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public boolean equals(SimpleGfxPosition pos) {
        return this.col == pos.getCol() && this.row == pos.getRow();
    }

    public void implementGravity(int speed) {
        this.setPos(this.getCol(), this.getRow() + speed);
    }

}
