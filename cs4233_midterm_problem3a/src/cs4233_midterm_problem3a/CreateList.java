package cs4233_midterm_problem3a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateList {
	
	private ArrayList<String> sequences = new ArrayList<String>();
	private int checkNum;

	CreateList(String seq) {
		checkNum = 1;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(seq));
		    String line = br.readLine();
		    while (line != null) {
		    	sequences.add(line);
		        line = br.readLine();	
		    }
			br.close();
		} catch (IOException e) {
			checkNum = 0;
		}
	}
	
	public ArrayList<String> getSequences(){
		return sequences;
	}
	
	public int check(){
		return checkNum;
	}
}
