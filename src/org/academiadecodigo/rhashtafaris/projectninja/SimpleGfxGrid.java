package org.academiadecodigo.rhashtafaris.projectninja;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxGrid {

    private static final int PADDING = 30;
    private Rectangle canvas;
    private int cols;
    private int rows;
    private int cellSize;
    private Picture background;

    public SimpleGfxGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.cellSize = 1;
        this.canvas = new Rectangle(0.0D, 0.0D, (double)(cols * this.cellSize), (double)(rows * this.cellSize));
        this.background = new Picture(0.0D,-50D,"Ninja/fundo_scale_3.png");

    }

    public void init() {
        this.canvas.setColor(Color.ORANGE);
        this.canvas.fill();
        this.background.draw();
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


    public int getCellSize() {
        return this.cellSize;
    }

    public SimpleGfxPosition makenBallsGridPosition() {
        return new SimpleGfxPosition(this);
    }

    public SimpleGfxPosition makeNinjaGridPosition(int col, int row) {

        return new SimpleGfxPosition(col, row, this);
    }

    public SimpleGfxPosition makeKatanaGridPosition(int col, int row) {
        return new SimpleGfxPosition(col, row, this);
    }

    /*public void setNinjaPosition(double ninjaX, double ninjaY, Ninja ninja){


    }*/

}
