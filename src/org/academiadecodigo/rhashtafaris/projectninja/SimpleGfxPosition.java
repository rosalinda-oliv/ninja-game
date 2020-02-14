package org.academiadecodigo.rhashtafaris.projectninja;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxPosition extends LogicPosition{

    private Ellipse ellipse;
    //private Rectangle rectangle;
    private SimpleGfxGrid grid;
    //private Picture pictureKatana;

    public SimpleGfxPosition(SimpleGfxGrid grid) {
        super((int)(Math.random() * (double)(grid.getCols() - 40)), (int) (Math.random() * (-2000 - 18000)), grid);
        this.grid = grid;
        this.ellipse = new Ellipse((double)this.getCol(), (double)this.getRow(), (double)(30 * grid.getCellSize()), (double)(30 * grid.getCellSize()));
        this.ellipseShow();
        //this.pictureKatana = new Picture((double) this.getCol(), (double) this.getRow(), "Ninja/katana.png");
    }

    public SimpleGfxPosition(int col, int row, SimpleGfxGrid grid) {
        super(col, row, grid);
        this.grid = grid;
        //this.rectangle = new Rectangle((double)this.getCol(), (double)this.getRow(), (double)(25 * grid.getCellSize()), (double)(25 * grid.getCellSize()));
        this.rectangleShow();
    }

    public void rectangleShow() {
        //this.rectangle.setColor(Color.WHITE);
       // this.rectangle.draw();
    }

    public void ellipseShow() {
        this.ellipse.setColor(Color.RED);
        this.ellipse.fill();
    }

    public void rectangleHide() {
        //this.rectangle.delete();
    }

    public void ellipseHide() {
        this.ellipse.delete();
    }

    public void implementGravity(int speed) {
        int beforeRow = this.getRow();
        int beforeCol = this.getCol();
        super.implementGravity(speed);
        int afterRow = this.getRow();
        int afterCol = this.getCol();
        this.ellipse.translate((double)(afterCol - beforeCol * this.grid.getCellSize()), (double)(afterRow - beforeRow * this.grid.getCellSize()));
    }

    public void ninjaPosition(double var1, double var2) {
        //this.rectangle.translate(var1 - this.rectangle.getX(), var2 - this.rectangle.getY());
    }

    public void katanaPosition(double var1, double var2) {
      // this.rectangle.translate(var1 - this.rectangle.getY(), var2 - this.rectangle.getY());

    }
}
