/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package marsrover2;

/**
 *
 * @author Eugene
 */

public class Rover {
    
    private int maxX;
    private int maxY;
    private int xCoord;
    private int yCoord;
 //   private char direction;
    private Direction dir;

    Rover(){}
    
    public Rover(int maxX, int maxY, int xCoord, int yCoord, char direction) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    //    this.direction = direction;
        switch(direction){
            case 'N': dir = dir.NORTH; break;
            case 'E': dir = dir.EAST; break;
            case 'S': dir = dir.SOUTH; break;
            case 'W': dir = dir.WEST; break;
            default: System.out.println("Invalid direction"); break;
        }
    }
    
    
    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public char getDirection() {
        return dir.getCode();
    }
    /*
     * Reads instruction from NASA and updates the position/direction of the
     * rover according while still in the bounds of the plateau
     */

    public void move(char instruction) {
        switch (instruction){
            case 'L': dir = dir.rotateLeft(); break;
            case 'R': dir = dir.rotateRight(); break;
            case 'M': move(); break;
            default: System.out.println("Not a valid instruction"); break;
        }
//        if (instruction == 'L') {
//            rotateLeft(); //rotates 90 degress counterclockwise
//        } else if (instruction == 'R') {
//            rotateRight(); //rotates 90 degress clockwise
//        } else if (instruction == 'M') {
//            move(); //moves rover forward one grid point
//        } else {
//            System.out.println("Not a valid instruction");
//        }
    }
    /*
     * Checks to see what direction the rover is currently facing, and rotates
     * to left 90 degrees. Updates new direction accordingly
     */

//    private void rotateLeft() {
//        if (direction == 'N') {
//            direction = 'W';
//        } else if (direction == 'E') {
//            direction = 'N';
//        } else if (direction == 'S') {
//            direction = 'E';
//        } else if (direction == 'W') {
//            direction = 'S';
//        }
//    }
    /*
     * Checks to see what direction the rover is currently facing, and rotates
     * to right 90 degrees. Updates new direction accordingly
     */

//    public void rotateRight() {
//        if (direction == 'N') {
//            direction = 'E';
//        } else if (direction == 'E') {
//            direction = 'S';
//        } else if (direction == 'S') {
//            direction = 'W';
//        } else if (direction == 'W') {
//            direction = 'N';
//        }
//    }
    /*
     * Checks to see what direction the rover is currently facing, and moves
     * forward one grid point. Updates new position
     */

    private void move() {
        switch(dir){
            case NORTH: increaseY(); break;
            case EAST: increaseX(); break;
            case SOUTH: decreaseY(); break;
            case WEST: decreaseX(); break;
        }
//        if (direction == 'N') {
//            increaseY();
//        } else if (direction == 'E') {
//            increaseX();
//        } else if (direction == 'S') {
//            decreaseY();
//        } else if (direction == 'W') {
//            decreaseX();
//        }
    }
    /*
     * Checks if rover is in the bounds of the plateau, and moves to the North
     * if still in bounds
     */

    public void increaseY() {
        if (yCoord < maxY) {
            yCoord++;
        } else {
            System.out.println("Cannot move North");
        }
    }
    /*
     * Checks if rover is in the bounds of the plateau, and moves to the East
     * if still in bounds
     */

    private void increaseX() {
        if (xCoord < maxX) {
            xCoord++;
        } else {
            System.out.println("Cannot move East");
        }
    }
    /*
     * Checks if rover is in the bounds of the plateau, and moves to the South
     * if still in bounds
     */

    private void decreaseY() {
        if (yCoord > 0) {
            yCoord--;
        } else {
            System.out.println("Cannot move South");
        }
    }
    /*
     * Checks if rover is in the bounds of the plateau, and moves to the West
     * if still in bounds
     */

    private void decreaseX() {
        if (xCoord > 0) {
            xCoord--;
        } else {
            System.out.println("Cannot move West");
        }
    }
    public String toString(){
        return xCoord + " " + yCoord + " " + dir.getCode();
    }
}
