package cs4233_midterm_problem1;

import java.util.ArrayList;
import java.io.*;

public class CreateAlignmentFromFile {
	
	private ArrayList<String> alignment = new ArrayList<String>();
	private int checkNum;
	
	CreateAlignmentFromFile(String file){
		BufferedReader br = null;
		checkNum = 1;
		try {
			br = new BufferedReader(new FileReader(file));
		    String line = br.readLine();
		    while (line != null) {
		    	alignment.add(line);
		        line = br.readLine();	
		    }
			br.close();
		} catch (IOException e) {
			checkNum = 0;
		}
		return;
	}
	
	public ArrayList<String> getAlignment(){
		return alignment;
	}
	
	public int check(){
		return checkNum;
	}
}
