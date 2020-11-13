package oop;

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

public class Robot {

    private int x = 0;
    private int y = 0;
    private Direction dir = Direction.UP;

    public static void moveRobot(Robot robot, int toX, int toY) {
        if(robot.getX() < toX){
            while(robot.getDirection() != Direction.RIGHT){
                robot.turnLeft();
            }
        } else if(robot.getX() > toX){
            while(robot.getDirection() != Direction.LEFT){
                robot.turnLeft();
            }
        }
        while(robot.getX() != toX){
            robot.stepForward();
        }

        if(robot.getY() < toY){
            while(robot.getDirection() != Direction.UP){
                robot.turnLeft();
            }
        } else if(robot.getY() > toY){
            while(robot.getDirection() != Direction.DOWN){
                robot.turnLeft();
            }
        }
        while(robot.getY() != toY){
            robot.stepForward();
        }
    }

    public void Robot(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Direction getDirection() {
        // текущее направление взгляда
        return this.dir;
    }

    public int getX() {
        // текущая координата X
        return this.x;
    }

    public int getY() {
        // текущая координата Y
        return this.y;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
        if(this.dir == Direction.UP) {
            this.dir = Direction.LEFT;
            return;
        }
        if(this.dir == Direction.LEFT) {
            this.dir = Direction.DOWN;
            return;
        }
        if(this.dir == Direction.DOWN) {
            this.dir = Direction.RIGHT;
            return;
        }
        if(this.dir == Direction.RIGHT) {
            this.dir = Direction.UP;
            return;
        }

    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        if(this.dir == Direction.UP) {
            this.dir = Direction.RIGHT;
            return;
        }
        if(this.dir == Direction.RIGHT) {
            this.dir = Direction.DOWN;
            return;
        }
        if(this.dir == Direction.DOWN) {
            this.dir = Direction.LEFT;
            return;
        }
        if(this.dir == Direction.LEFT) {
            this.dir = Direction.UP;
            return;
        }
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
        if(this.dir == Direction.UP) {
            this.y += 1;
            return;
        }
        if(this.dir == Direction.LEFT) {
            this.x -= 1;
            return;
        }
        if(this.dir == Direction.DOWN) {
            this.y -= 1;
            return;
        }
        if(this.dir == Direction.RIGHT) {
            this.x += 1;
            return;
        }


    }
}
