package org.academiadecodigo.rhashtafaris.projectninja;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(800, 1600, 20);

        game.init();

        try {
            game.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
