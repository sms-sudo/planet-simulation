/*
 * Salwa Abdalla - ICS4U
 * 20/01/2020 Jeff Radulovic
 * ICS Culminating
 * 
 * This is the class that reads in various planets information
 * from the Info Resources file. Displays in a side tab in the 
 * main application
 * 
 */

//importing necessary imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileReader {
	//list that includes all of the planets available
	private MyArrayList<String> planets = new MyArrayList<String>();
	
	//returns planets to be called when viewing
	public MyArrayList<String> getPlanets(){
		return planets;
	}
	
	//loading the planet list into an array list (customizable)
	public MyArrayList<String> loadPlanets() {
		MyArrayList<String> planets = new MyArrayList<String>();
		String[] list = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
		for (int i = 0; i < list.length; i++) {
			MyNode<String> planetName = new MyNode<String>(list[i]);
			planets.addNode(planetName);
		}
		
		return planets;
	}

	//loading information and return the info per planet
	public String loadInformation(String filename){
		//searches file and if it is possible to open...
		File file = new File(filename);
		Scanner scan = null;
		String info = new String();
		try {
			//...format properly
			scan = new Scanner(file);
			while (scan.hasNextLine()) {
				info += scan.nextLine().toUpperCase() + ":\n";
				info += scan.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			//...or don't do anything
		}
		//close scanner and return info
		scan.close();	
		return info;	
	}
	
}
