package org.academiadecodigo.rhashtafaris.projectninja;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ConcurrentModificationException;

public class SimpleGfxPosition extends LogicPosition{

    private SimpleGfxGrid grid;
    private Picture cannonBall;

    public SimpleGfxPosition(SimpleGfxGrid grid) {
        super((int)(Math.random() * (double)(grid.getCols() - 150)), (int) (Math.random() * (-2000 - 9000)), grid);
        this.grid = grid;
        this.cannonBall = new Picture((double)this.getCol(), (double)this.getRow(),"Ninja/bola.png");
        this.cannonBall.draw();
        this.cannonBall.grow(-50,-50);
    }

    public SimpleGfxPosition(int col, int row, SimpleGfxGrid grid) {
        super(col, row, grid);
        this.grid = grid;
    }

    public void ballImplementGravity(int speed) {
        int beforeRow = this.getRow();
        int beforeCol = this.getCol();
        super.implementGravity(speed);
        int afterRow = this.getRow();
        int afterCol = this.getCol();
        try {

            this.cannonBall.translate((double)(afterCol - beforeCol * this.grid.getCellSize()), (double)(afterRow - beforeRow * this.grid.getCellSize()));

        }catch (ConcurrentModificationException e){
            System.out.println("Still untaught on thread synchronization");
        }catch (NullPointerException e){
            System.out.println("Dont know what is wrong here, it works 80% of the time");
        }
    }

    public void ninjaImplementGravity(int speed){
        super.implementGravity(speed);
    }

    public void ninjaPosition(int ninjaX, int ninjaY) {

        super.setPos(ninjaX, ninjaY);

    }

    public void slash(){
        try{

            this.cannonBall.delete();
        }catch (ConcurrentModificationException e){
            System.out.println("Still untaught on thread synchronization");
        }
    }



    public void ballsResetPos(){

        int randomX = (int)(Math.random() * (double)(grid.getCols() - 150));
        int randomY = (int) (Math.random() * (-2000 - 9000));

        int beforeRow = getRow();
        int beforeCol = getCol();

        super.setPos(randomX, randomY);

        cannonBall.translate(randomX - beforeCol, randomY - beforeRow );

    }

    public boolean equals(SimpleGfxPosition pos){
        return (pos.getRow() == super.getRow() && pos.getCol() == super.getCol());
    }

    public String toString(){
        return getRow()+"-----"+getCol();
    }

}
