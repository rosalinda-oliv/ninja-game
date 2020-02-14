package org.academiadecodigo.rhashtafaris.projectninja;

public enum BallType {

    TRAPBALL(2, 2),
    CANNONBALL(2, 8);

    private int speed;
    private int spawnProbability;

    private BallType(int speed, int spawningProbability) {
        this.speed = speed;
        this.spawnProbability = spawningProbability;
    }

    public static BallType ballTypeCreator() {
        BallType[] ballTypes = values();
        int number = (int)(Math.random() * (double)ballTypes.length);
        return (double)ballTypes[number].spawnProbability < Math.random() / 10.0D ? ballTypeCreator() : ballTypes[number];
    }

    public int getSpeed() {
        return this.speed;
    }

}
