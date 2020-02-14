package org.academiadecodigo.rhashtafaris.projectninja;

import static org.academiadecodigo.rhashtafaris.projectninja.BallFactory.createBall;

public class Game {

    private int time = 0;
    private int points = 0;
    private int delay;
    private Ninja ninja;
    private Level level;
    private SimpleGfxGrid grid;
    private Katana katana;
    private Balls[] balls;

    public Game(int cols, int rows, int delay) {
        this.delay = delay;
        this.grid = new SimpleGfxGrid(cols, rows);
        balls = new Balls[100];
    }

    public void init() {
        this.grid.init();
        this.ninja = new Ninja(this.grid.makeNinjaGridPosition(325, 700));
        this.ninja.setGrid(this.grid);
        ninja.initMouse();
        this.katana = new Katana(this.grid.makeKatanaGridPosition(200, 200));
        this.katana.setGrid(this.grid);

        for (int i = 0; i < balls.length ; i++) {

            balls[i] = BallFactory.createBall(grid);

        }
    }

    public void start() throws InterruptedException {
        boolean gameEnd = false;

        while (!gameEnd) {

            Thread.sleep(delay);


            ballGravity();
        }
    }

    public void ballGravity() {

        for (Balls ball : balls) {

            if(katana.getPos().equals(ball.getPos())){

                ball.slashed();

            }
            ball.gravity();
        }
    }
}
