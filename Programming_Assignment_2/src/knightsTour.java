/* Author: Casie Ropski
/  Date: October 2 2016
/  Class: Data Structures & Algorithms
/
/  Description: Knight in chess will find path through
/  a map where it touches every square while not landing
/  on the same square twice.
*/


import java.util.*;

public class knightsTour {
	private static final int RIGHTUP = 0;
	private static final int RIGHTDOWN = 1;	
	private static final int LEFTUP = 2;	
	private static final int LEFTDOWN = 3;
	private static final int UPRIGHT = 4;
	private static final int UPLEFT = 5;
	private static final int DOWNRIGHT = 6;
	private static final int DOWNLEFT = 7;
	private static final int FIFTHD = 8;
	
	private static int [] [] maze = new int[9][9];
	private static int row = 0;
	private static int col = 0;
	private static int count = 0;
	
	private static int startRow;
	private static int startCol;
	
	private static Scanner keyb = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		//Construct initial maze, 2D array
		constructMaze(startRow, startCol);
		
		//Prompt user for the starting point.
		System.out.println("Enter where the starting row "
				+ "should be (2 thru 7): ");
		startRow = keyb.nextInt();

		System.out.println("Enter where the starting column"
				+ " should be (2 thru 7): ");
		startCol = keyb.nextInt();
		
		//Search for a path for the knight.
		if (findPath(startRow, startCol)){
			System.out.println("We found a path!!!");
		} else {
			System.out.println("No path found.");		
		}
		
		//re-print maze with answer or blank if no answer.
		writeMaze();
		System.out.println("Thanks for playing chess!");	
	}
	
	static void constructMaze(int startRow, int startColumn){
		System.out.println("");
		
		//Create initial map and border of 0s and -1s.
		for (col = 0; col < 9; col++){
			 for (row = 0; row < 9; row++){
				 maze[row][col] = -1;
			 }
		 }
		
		 for (col = 2; col < 7; col++){
			for (row = 2; row < 7; row++){
				maze[row][col] = 0;
			}
		 }
		 
		 //Print initial map with even spacing.
		 for (col = 0; col < 9; col++){
			for (row = 0; row < 9; row++){
				 System.out.printf(" %2d",maze[row][col]);
			}
			System.out.println("");
		 }
		 
	}
	
	//Write final maze with answer, if found.
	static void writeMaze(){
		for (col = 0; col < 9; col++){
			for (row = 0; row < 9; row++){
				 System.out.printf(" %2d",maze[row][col]);
			}
			System.out.println("");
		 }
	}
	
	public static boolean findPath(int x, int y){
		int dir;
		boolean foundPath;
		
		if (maze[x][y] == 24){ //If its the last tile,
			return true;		//it's been solved!
		} else if (maze[x][y] == -1) { //Hit a wall (-1)
			return false;
		} else if (maze[x][y] > 0) { //Hit already used
			return false;		      //tile.
		} else  {
			count++;
			maze[x][y] = count; 	//New tile! Mark with count.
		
			foundPath = false;
			dir = RIGHTUP;
			
			//Try different directions after backtracking
			while (!foundPath  && dir != FIFTHD) {
				switch (dir) {
					case RIGHTUP: foundPath = findPath(x+1,y+2);
						break;
					case RIGHTDOWN: foundPath = findPath(x+1,y-2);
						break;
					case LEFTUP:  foundPath = findPath(x-1,y+2);
						break;
					case LEFTDOWN:  foundPath = findPath(x-1,y-2);
						break;
					case UPRIGHT: foundPath = findPath(x+2,y+1);
						break;
					case UPLEFT: foundPath = findPath(x-2,y+1);
						break;
					case DOWNRIGHT:  foundPath = findPath(x+2,y-1);
						break;
					case DOWNLEFT:  foundPath = findPath(x-2,y-1);
						break;
				}
				
			dir += 1;
			}
			
			if (!foundPath){	//If no way is found, backtrack.
				maze[x][y] = 0;
				count--;
			}
			
			if (maze[x][y] == 1){ //If return to starting position,
				return foundPath; //Return false.
			}
			
			return foundPath;
		}
	}
	
}