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

    public Ninja(SimpleGfxPosition pos) {
        this.ninjaStanding = new Picture((double)pos.getCol(), (double)pos.getRow(), "Ninja/ninjaStanding_Scale_test1.png");
        this.ninjaBeforeSlash = new Picture((double)pos.getCol(),(double)pos.getRow(),"Ninja/ninjaStartSlash_scale_2.png");
        this.ninjaAfterSlash = new Picture((double)pos.getCol(),(double)pos.getRow(),"Ninja/ninjaFinalSlash_scale_2.png");
        this.ninjaStanding.draw();
        this.pos = pos;
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

        pos.ninjaPosition(mouseController.getNinjaX(), mouseController.getNinjaY());

        int afterCol = pos.getCol();
        int  afterRow = pos.getRow();

        ninjaStanding.translate(afterCol - beforeCol, afterRow - beforeRow);

    }

    public void setmouseController(MouseController mouseController){
        this.mouseController = mouseController;
    }

    /*public void initMouse() {
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }*7

    /*public void mouseMoved(MouseEvent var1) {

    }*/

    /*public void setNinjaAfterSlash() {



    }*/

    /*public void mouseClicked(MouseEvent var1) {

        double mouseX = var1.getX();
        double mouseY = var1.getY();

        if (mouseX > 650) {
            mouseX = 650;
        }

        pos.ninjaPosition(mouseX, mouseY);
        ninjaStanding.translate(mouseX - ninjaStanding.getX(), mouseY - ninjaStanding.getY());
        ninjaStanding.delete();

        try {
            ninjaBeforeSlash.translate(mouseX - ninjaBeforeSlash.getX(), mouseY - ninjaBeforeSlash.getY());
            ninjaBeforeSlash.draw();
            Thread.sleep(5);
            ninjaBeforeSlash.delete();
            ninjaAfterSlash.translate(mouseX - ninjaAfterSlash.getX(), mouseY - ninjaAfterSlash.getY());
            ninjaAfterSlash.draw();

            ninjaAfterSlash.delete();
            ninjaBeforeSlash.translate(mouseX - ninjaBeforeSlash.getX(), mouseY - ninjaBeforeSlash.getY());
            ninjaBeforeSlash.draw();
        } catch (InterruptedException ex) {
            System.out.println("Vai-te foder!");
        }


    }*/

}
