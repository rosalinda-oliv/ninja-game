package org.academiadecodigo.rhashtafaris.projectninja;

public class Balls {

    private int speed;
    private SimpleGfxGrid grid;
    private SimpleGfxPosition pos;
    private MouseController mouseController;

    public Balls(SimpleGfxPosition pos) {
        this.pos = pos;
    }

    public void setGrid(SimpleGfxGrid grid) {
        this.grid = grid;
    }

    public SimpleGfxPosition getPos() {
        return this.pos;
    }

    public void setSpeed(BallType ballType) {
        this.speed = ballType.getSpeed();
    }

    /*public boolean isClicked(){

        if(pos.getCol() + 45 == mouseController. && pos.getRow() + 45 == mouseController.getNinjaY()) {
            return true;
        }
        return false;
    }*/

    public void gravity() {

        for(int i = 0; i < this.speed; ++i) {
            this.pos.implementGravity(this.speed);
        }

    }

    public void reUse(){
        this.pos.ballsResetPos();
    }

    public void setMouseController(MouseController mouseController){
        this.mouseController = mouseController;
    }

}
