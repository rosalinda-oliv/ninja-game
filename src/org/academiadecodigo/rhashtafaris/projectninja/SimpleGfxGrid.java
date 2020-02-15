package org.academiadecodigo.rhashtafaris.projectninja;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid {

    private static final int PADDING = 30;
    private Rectangle canvas;
    private int cols;
    private int rows;
    private int cellSize;
    private MouseController mouseController;

    public SimpleGfxGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.cellSize = 1;
        this.canvas = new Rectangle(0.0D, 0.0D, (double)(cols * this.cellSize), (double)(rows * this.cellSize));

    }

    public void init() {
        this.canvas.setColor(Color.ORANGE);
        this.canvas.fill();
    }

    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

    public int getWidth() {
        return this.canvas.getWidth();
    }

    public int getHeight() {
        return this.canvas.getHeight();
    }

    public int getX() {
        return this.canvas.getX();
    }

    public int getY() {
        return this.canvas.getY();
    }

    public int getPadding() {
        return 30;
    }

    public int getCellSize() {
        return this.cellSize;
    }

    public SimpleGfxPosition makenBallsGridPosition() {
        return new SimpleGfxPosition(this);
    }

    public SimpleGfxPosition makeNinjaGridPosition(int col, int row) {

        mouseController.setNinjaX(col);
        mouseController.setNinjaY(row);

        return new SimpleGfxPosition(col, row, this);
    }

    public SimpleGfxPosition makeKatanaGridPosition(int col, int row) {
        return new SimpleGfxPosition(col, row, this);
    }

    /*public void setNinjaPosition(double ninjaX, double ninjaY, Ninja ninja){


    }*/

    public int rowToY(int row) {
        return row * this.cellSize;
    }

    public int columnToX(int col) {
        return col * this.cellSize;
    }

    public void setMouseController(MouseController mouseController){

        this.mouseController = mouseController;
    }

}
