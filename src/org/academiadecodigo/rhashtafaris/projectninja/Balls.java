package org.academiadecodigo.rhashtafaris.projectninja;

public class Balls {

    private int speed;
    private SimpleGfxGrid grid;
    private SimpleGfxPosition pos;

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

    public void slashed() {
        this.pos.ellipseHide();
    }

    public void gravity() {
        for(int i = 0; i < this.speed; ++i) {
            this.pos.implementGravity(this.speed);
        }

    }

    public void reUse(){
        this.pos.ballsRePos();
    }

}
