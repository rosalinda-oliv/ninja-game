package org.academiadecodigo.rhashtafaris.projectninja;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ninja {

    private int health = 3;
    private int fallingSpeed = 5;
    private double mouseXCordinates;
    private double mouseYCordinates;
    private Picture ninjaStanding;
    private Picture ninjaFalling;
    private Picture ninjaBeforeSlash;
    private Picture ninjaAfterSlash;
    private SimpleGfxPosition pos;
    private SimpleGfxGrid grid;
    private Mouse mouse;
    private MouseController mouseController;
    private double currentX;
    private double currentY;

    public Ninja(SimpleGfxPosition pos) {
        this.ninjaStanding = new Picture((double)pos.getCol(), (double)pos.getRow(), "Ninja/ninjaStanding_Scale_test1.png");
        this.ninjaBeforeSlash = new Picture((double)pos.getCol(),(double)pos.getRow(),"Ninja/ninjaStartSlash_scale_2.png");
        this.ninjaAfterSlash = new Picture((double)pos.getCol(),(double)pos.getRow(),"Ninja/ninjaFinalSlash_scale_2.png");
        this.ninjaStanding.draw();
        this.pos = pos;

        this.currentY = pos.getRow();
        this.currentX = pos.getCol();
    }

    public int getX() {
        return this.pos.getCol();
    }

    public int getY(){
        return this.pos.getRow();
    }

    public void setGrid(SimpleGfxGrid grid) {
        this.grid = grid;
    }

    public void position(){

        int beforeCol = pos.getCol();
        int beforeRow = pos.getRow();

        int currentX = (int) this.currentX;
        int currentY = (int) this.currentY;


        pos.ninjaPosition(currentX, currentY);

        int afterCol = pos.getCol();
        int  afterRow = pos.getRow();

        ninjaStanding.translate(afterCol - beforeCol, afterRow - beforeRow);

    }

    public void setmouseController(MouseController mouseController){
        this.mouseController = mouseController;
    }

    public void setPos(double x, double y) {
        this.currentX = x;
        this.currentY = y;
    }
}
