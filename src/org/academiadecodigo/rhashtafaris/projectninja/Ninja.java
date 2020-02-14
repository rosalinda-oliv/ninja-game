package org.academiadecodigo.rhashtafaris.projectninja;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ninja implements MouseHandler {

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

    public Ninja(SimpleGfxPosition pos) {
        this.ninjaStanding = new Picture((double)pos.getCol(), (double)pos.getRow(), "Ninja/ninjaStanding_Scale_test1.png");
        this.ninjaStanding.draw();
        this.pos = pos;
        mouse = new Mouse(this);
    }

    public void setGrid(SimpleGfxGrid grid) {
        this.grid = grid;
    }

    public void initMouse() {
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    public void mouseMoved(MouseEvent var1) {

    }

    public void mouseClicked(MouseEvent var1) {
        pos.ninjaPosition(var1.getX(), var1.getY());
        ninjaStanding.translate(var1.getX() - ninjaStanding.getX(), var1.getY() - ninjaStanding.getY());
    }
}
