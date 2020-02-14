package org.academiadecodigo.rhashtafaris.projectninja;

public class BallFactory {

    public BallFactory() {
    }

    public static Balls createBall(SimpleGfxGrid grid) {
        BallType ballType = BallType.ballTypeCreator();
        switch(ballType) {
            case TRAPBALL:
                return new TrapBall(grid.makenBallsGridPosition());
            default:
                return new CannonBall(grid.makenBallsGridPosition());
        }
    }

}
