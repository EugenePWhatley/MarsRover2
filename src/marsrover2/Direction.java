/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package marsrover2;

/**
 *
 * @author Eugene
 */
public enum Direction {

    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');
    
    private char code;
    
    Direction(char code){
        this.code = code;
    }
    
    public char getCode(){
        return code;
    }

    public Direction rotateRight() {
        return values()[(ordinal()+1)%4];
    }
    public Direction rotateLeft(){
        return values()[(ordinal()+3)%4];
    }
}
