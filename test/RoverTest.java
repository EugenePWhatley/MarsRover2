/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.internal.runners.statements.ExpectException;
import marsrover2.Direction;
import marsrover2.Rover;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eugene
 */
public class RoverTest {
    
    public RoverTest() {
        
        
        
    }

    @Test
    public void checkToAssureRoverYcoordIncreasesInbound() {
       Rover rover = new Rover(5, 5, 2, 3, 'N'); 
       
       rover.increaseY();
        
       assertEquals(4, rover.getYCoord()); 
    }
    
    @Test
    public void checkToAssureRoverYcoordDoesntIncreasesOutbounds() {
        Rover rover = new Rover(5,5,5,5,'N');
        
        rover.increaseY();
        
        assertEquals(5, rover.getYCoord());
    }
    
    @Test
    public void checkToAssureRoverRotatesFromEastToSouth() {
        Rover rover = new Rover(5,5,3,3,'E');
        
        rover.move('R');
        
        assertEquals('S',rover.getDirection());
    }
    
    @Test
    public void checkIfDirectionEnumProperlyRotatesNorthToEast(){
        Direction check = Direction.NORTH;
        
        check = check.rotateRight();
        
        assertEquals(Direction.EAST, check);
    }
    
    @Test
    public void checkIfDirectionEnumProperlyRotatesWestToSouth(){
        Direction check = Direction.WEST;
        
        check = check.rotateLeft();
        
        assertEquals(Direction.SOUTH, check);
    }
    
    @Test
    public void checkIfDirectionEnumProperlyRotatesWestToNorth(){
        Direction check = Direction.WEST;
        
        check = check.rotateRight();
        
        assertEquals(Direction.NORTH, check);
    }
    
    @Test
    public void checkToSeeIfNorthDirectionDisplaysNAsCode(){
        Direction check = Direction.NORTH;
        
        assertEquals('N',check.getCode());
    }

    @Test
    public void shouldNotCreatePlateauIfNoPositiveIntIsPassedToConstructor(){
        try {
            Plateau p = new Plateau(-2,3);
            assert(false);
        } catch(Exception e) {
            assertTrue("Invalid input".equals(e.getMessage()));
        }
    }
    
    @Test
    public void shouldNotCreatePlateauIfMaxYIsNegative(){
        try {
            Plateau p = new Plateau(2,-3);
            assert(false);
        } catch(Exception e) {
            assertTrue("Invalid input".equals(e.getMessage()));
        }
    }
    
    @Test
    public void intIsProperlyPassedToPlateau() throws Exception{
        Plateau p = new Plateau(2,3);
        
        
        assertEquals(2,p.getX());
    }
}
