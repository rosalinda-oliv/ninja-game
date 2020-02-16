package org.academiadecodigo.rhashtafaris.projectninja;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MouseController implements MouseHandler {


    private int katanaX;
    private int katanaY;
    private Mouse mouse;
    private Ninja ninja;
    private Katana katana;

    public MouseController(Ninja ninja, Katana katana){
        this.katana = katana;
        this.ninja = ninja;
        initMouse();
    }

    public void initMouse() {

        mouse = new Mouse(this);

        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        ninja.setPosition(mouseEvent.getX(), mouseEvent.getY());

        ninja.slash();

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

        katana.setPosition(mouseEvent.getX(), mouseEvent.getY());

    }


    public int getKatanaX(){
        return katanaX;
    }

    public int getKatanaY(){
        return katanaY;
    }

}
