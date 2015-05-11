/*
 * Author: Eugene Whatley
 * Problem 3: Mars Rover
 * A better approach to original Mars Rover Project so that instead of
 * just printing the position of the Rover, it saves the rover in a list
 * where the coordinates can still be printed at another time without just
 * printing the rover without saving object
 */
package marsrover2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class MarsRover2 {

    public static void main(String[] args) throws IOException {
        //prompt user for name of file
        Scanner input = new Scanner(System.in);
        System.out.print("Please input the name of the file: ");
        File fileName = new File(input.nextLine());
        Scanner reader = new Scanner(fileName);
        readFile(fileName, reader);     
    }

    public static void readFile(File fileName, Scanner reader) throws IOException {
        //Gets the maximum (x,y) coordinates from file
        int maxX = reader.nextInt();
        int maxY = reader.nextInt();
        int j = 0; //counter for list
        ArrayList<Rover> rover = new ArrayList<Rover>(); //creates a list of Rovers
        //Loops through until all rovers are accounted for
        while (reader.hasNext()) {
            int x = reader.nextInt();
            int y = reader.nextInt();
            char direction = reader.next().charAt(0);
            rover.add(j,new Rover(maxX, maxY, x, y, direction)); //adds new rover to list
            //Gets instructions from NASA and sends to Rover char by char
            String instructions = reader.next();
            for (int i = 0; i < instructions.length(); i++) {
                rover.get(j).move(instructions.charAt(i));
            }
            j++;
        }
        //Loops through list and prints position of each Rover
        for(int i = 0; i < rover.size();i++)
            System.out.println(rover.get(i).toString());
    }
}
