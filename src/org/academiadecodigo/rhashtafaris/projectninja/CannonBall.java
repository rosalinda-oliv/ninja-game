package org.academiadecodigo.rhashtafaris.projectninja;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CannonBall extends Balls{

    private Picture picture;

    public CannonBall(SimpleGfxPosition pos) {
        super(pos);
        this.setSpeed(BallType.CANNONBALL);
    }

}
