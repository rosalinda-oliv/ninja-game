package org.academiadecodigo.rhashtafaris.projectninja;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class Ninja {

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
    private Timer animationTimer;
    private Timer gravityTimer;

    public Ninja(SimpleGfxPosition pos) {

        this.ninjaStanding = new Picture((double)pos.getCol(), (double)pos.getRow(), "Ninja/ninjaStanding_Scale_test1.png");
        this.ninjaBeforeSlash = new Picture((double)pos.getCol(),(double)pos.getRow(),"Ninja/ninjaStartSlash_scale_2.png");
        this.ninjaAfterSlash = new Picture((double)pos.getCol(),(double)pos.getRow(),"Ninja/ninjaFinalSlash_scale_2.png");
        this.ninjaFalling = new Picture((double)pos.getCol(),(double)pos.getRow(), "Ninja/ninjaFalling_Scale.png");
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

    public SimpleGfxPosition getPos(){
        return this.pos;
    }

    public void setPosition(double ninjaX, double ninjaY){

        int beforeCol = pos.getCol();
        int beforeRow = pos.getRow();

        int currentX = (int) ninjaX;
        int currentY = (int) ninjaY;

        if(currentX > 650) {
            currentX = 650;
        }


        pos.ninjaPosition(currentX - 50, currentY - 50);

        int afterCol = pos.getCol();
        int  afterRow = pos.getRow();

        ninjaBeforeSlash.translate(afterCol - beforeCol, afterRow - beforeRow);
        ninjaAfterSlash.translate(afterCol - beforeCol, afterRow - beforeRow);

    }

    public void slash(){

        ninjaStanding.delete();


        TimerTask timerTaskToDeleteBeforeSlash = new TimerTask() {
            @Override
            public void run() {
                ninjaBeforeSlash.delete();
            }
        };


        TimerTask timerTaskToDrawAfterSlash = new TimerTask() {
            @Override
            public void run() {
                ninjaAfterSlash.draw();
            }
        };

        TimerTask timerTaskToDeleteAfterSlash = new TimerTask() {
            @Override
            public void run() {

                ninjaAfterSlash.delete();
            }
        };

        TimerTask timerTaskToDrawBeforeSlash = new TimerTask() {
            @Override
            public void run() {
                ninjaBeforeSlash.draw();
            }
        };

        this.animationTimer  = new Timer();

        animationTimer.schedule(timerTaskToDeleteBeforeSlash, 0);

        animationTimer.schedule(timerTaskToDrawAfterSlash, 0);

        animationTimer.schedule(timerTaskToDeleteAfterSlash, 350);

        animationTimer.schedule(timerTaskToDrawBeforeSlash, 350);



    }

    public void ninjaStand(){

        ninjaBeforeSlash.delete();
        ninjaStanding.draw();
    }

    public void setmouseController(MouseController mouseController){
        this.mouseController = mouseController;
    }



}
