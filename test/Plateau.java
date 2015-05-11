/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eugene
 */
class Plateau {
    
    private int maxX, maxY;
    
    Plateau(int maxX, int maxY) throws Exception
    {
        if(checkIfXandYArePositive(maxX, maxY))
            this.maxX = maxX;
        else
            throw new Exception("Invalid input");    
        
    }

    private boolean checkIfXandYArePositive(int maxX, int maxY) {
        return maxX > 0 && maxY > 0;
    }
    
    public int getX(){
        return maxX;
    }
}
