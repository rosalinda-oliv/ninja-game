package org.academiadecodigo.rhashtafaris.projectninja;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class Game {

    private int time = 0;
    private int delay;
    private Ninja ninja;
    private Level level;
    private SimpleGfxGrid grid;
    private Katana katana;
    private Balls[] balls;
    private MouseController mouseController;
    private Text points;
    private int score;

    public Game(int cols, int rows, int delay) {
        this.delay = delay;
        this.grid = new SimpleGfxGrid(cols, rows);
        balls = new Balls[20];
        points= new Text(400,  150, "0" );
        score = 0;
    }

    public void init() {

        this.grid.init();

        for (int i = 0; i < balls.length; i++) {

            balls[i] = BallFactory.createBall(grid);
            balls[i].setMouseController(mouseController);
            balls[i].setGrid(grid);

        }


        this.ninja = new Ninja(this.grid.makeNinjaGridPosition(325, 700));
        this.ninja.setGrid(this.grid);
        this.ninja.setmouseController(this.mouseController);


        this.katana = new Katana(this.grid.makeKatanaGridPosition(200, 200));
        this.katana.setGrid(this.grid);
        mouseController = new MouseController(ninja, katana);

        points.draw();
        points.grow(40, 40);


    }

    public void start() throws InterruptedException {
        boolean gameEnd = false;

        while (!gameEnd) {

            Thread.sleep(delay);

            checkPosition();

            //ninjaGravity();

            ballGravity();
            this.points.setText(""+ score);
        }
    }

    public void ballGravity() {


        for (Balls ball : balls) {

            //if(ball.isClicked()){
            //  ball.reUse();
            // continue;
            //}

            ball.gravity();

            if (ball.getPos().getRow() >= 800) {

                ball.reUse();

            }

        }
    }

    public void checkPosition() {
        for (int i = 0; i < balls.length; i++) {


            if ((ninja.getPos().getRow() + 40 >= balls[i].getPos().getRow()
                    && ninja.getPos().getRow() + 40 <= (balls[i].getPos().getRow()+45)
                    && (ninja.getPos().getCol() + 40 >= balls[i].getPos().getCol()
                    && ninja.getPos().getCol() + 40 <= (balls[i].getPos().getCol()+45)))){
                balls[i].reUse();

                System.out.println("ha pois é");

                score++;



            }
        }
    }


    /*public void ninjaGravity(){

        if(ninja.getPos().getRow() >= 750){
            ninja.ninjaStand();
        }

        ninja.startGravity();
    }*/
}
