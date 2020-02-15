package org.academiadecodigo.rhashtafaris.projectninja;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MouseController implements MouseHandler {


    private int ninjaX;
    private int ninjaY;
    private int katanaX;
    private int katanaY;

    private SimpleGfxGrid grid;
    private Mouse mouse;


    public MouseController(){
        initMouse();
    }

    public void initMouse() {

        mouse = new Mouse(this);

        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        this.ninjaX = (int) mouseEvent.getX();
        this.ninjaY = (int) mouseEvent.getY();
        System.out.println(mouseEvent);

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

        katanaX = (int) mouseEvent.getX();
        katanaY = (int) mouseEvent.getY();

    }

    public int getNinjaX(){
        return ninjaX;
    }

    public int getNinjaY(){
        return ninjaY;
    }

    public int getKatanaX(){
        return katanaX;
    }

    public int getKatanaY(){
        return katanaY;
    }

    public void setNinjaX(int ninjaX) {
        this.ninjaX = ninjaX;
    }

    public void setNinjaY(int ninjaY){
        this.ninjaY = ninjaY;
    }
}
