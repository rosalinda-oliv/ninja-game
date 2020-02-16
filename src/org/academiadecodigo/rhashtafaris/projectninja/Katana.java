package org.academiadecodigo.rhashtafaris.projectninja;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Katana {

    private int x;
    private int y;
    private SimpleGfxGrid grid;
    private Picture katana;



    public Katana(SimpleGfxPosition pos) {
        this.katana = new Picture((double) pos.getCol(), (double) pos.getRow(), "Ninja/cursor Katana_scale_2.png");
        this.katana.draw();
    }

    public void setGrid(SimpleGfxGrid grid) {
        this.grid = grid;
    }

    public void setPosition(double katanaX, double katanaY){

        int mouseX = (int) katanaX;
        int mouseY = (int) katanaY;

        if(katanaX > 740) {
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

}
