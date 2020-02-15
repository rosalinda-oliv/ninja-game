package org.academiadecodigo.rhashtafaris.projectninja;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Katana {

    private int x;
    private int y;
    private Balls ball;
    private SimpleGfxGrid grid;
    private SimpleGfxPosition pos;
    private Picture katana;
    private MouseController controller;

    public Katana(SimpleGfxPosition pos) {
        this.katana = new Picture((double) pos.getCol(), (double) pos.getRow(), "Ninja/cursor Katana_scale_2.png");
        this.katana.draw();
        this.pos = pos;
        new KatanaController();
    }

    public SimpleGfxPosition getPos() {
        return this.pos;
    }

    public void slash() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setGrid(SimpleGfxGrid grid) {
        this.grid = grid;
    }

    public void position(){

        int mouseX = controller.getKatanaX();
        int mouseY = controller.getKatanaY();

        if(controller.getKatanaX() > 740) {
            mouseX = 740;
        }


        if ((katana.getX() >= 0 && katana.getX() < grid.getWidth() ) &&
                katana.getY() >= 0 && katana.getY() < grid.getHeight() ) {
            katana.translate(mouseX - katana.getX(), mouseY - katana.getY());
        }
        if (katana.getX() > grid.getWidth()) {
            x = grid.getWidth() >> 2;
        }
        if (katana.getY()> grid.getHeight()){
            y = grid.getHeight() >> 2;
        }
    }

    public void setMouseController(MouseController mouseController){

        this.controller = mouseController;
    }

    public class KatanaController {

        private Mouse mouse;

        KatanaController() {
            //this.mouse = new Mouse(this);
            //initMouse();
        }

        /*void initMouse() {
            this.mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
            this.mouse.addEventListener(MouseEventType.MOUSE_MOVED);
        }


        @Override
        public void mouseClicked(MouseEvent var1) {
            //pos.katanaPosition(var1.getX(), var1.getY());
            //katana.translate(var1.getX() - katana.getX(), var1.getY() - katana.getY());
        }

        @Override
        public void mouseMoved(MouseEvent var1) {
            //  pos.katanaPosition(var1.getX(), var1.getY());

            double mouseX = var1.getX();
            double mouseY = var1.getY();

            if(var1.getX() > 740) {
                mouseX = 740;
            }


            if ((katana.getX() > 0 && katana.getX() < grid.getWidth() - 100) &&
                    katana.getY() > 0 && katana.getY() < grid.getHeight() - 100) {
                katana.translate(mouseX - katana.getX(), mouseY - katana.getY());
            }
            if (katana.getX() > grid.getWidth() - 100) {
                x = grid.getWidth() >> 2;
            }
            if (katana.getY()> grid.getHeight() - 100){
                y = grid.getHeight() >> 2;
            }




            /*if ((katana.getX() > 0 && katana.getX() < grid.getWidth() - 100) &&
                    katana.getY() > 0 && katana.getY() < grid.getHeight() - 100) {
                katana.translate(var1.getX() - katana.getX(), var1.getY() - katana.getY());
            }
            if (katana.getX() > grid.getWidth() - 100) {
                x = grid.getWidth() >> 2;
            }
            if (katana.getY()> grid.getHeight() - 100){
                y = grid.getHeight() >> 2;
            }*/
        }
}
