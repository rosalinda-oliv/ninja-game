package org.academiadecodigo.rhashtafaris.projectninja;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(800, 1600, 20);
        game.init();
        game.start();
    }
}
