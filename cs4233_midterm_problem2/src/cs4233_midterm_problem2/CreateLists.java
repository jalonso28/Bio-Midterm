package cs4233_midterm_problem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateLists {
	
	private ArrayList<String> sequences = new ArrayList<String>();
	private Float pwms[][];
	private int checkNum;

	CreateLists(String seq, String pwm) {
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
		try {
			br = new BufferedReader(new FileReader(pwm));
		    String line = br.readLine();
		    String[] sub = line.split("\\s");
		    pwms = new Float[4][sub.length];
		    int c = 0;
		    while (line != null) {
		    	sub = line.split("\\s");
		    	for(int i = 0; i < sub.length; i++){
		    		pwms[c][i] = Float.parseFloat(sub[i]);
		    	}
		    	line = br.readLine();
		    	c++;
		    }
			br.close();
		} catch (IOException e) {
			checkNum = 0;
		}
		return;
	}
	
	public ArrayList<String> getSequences(){
		return sequences;
	}
	
	public Float[][] getPwm(){
		return pwms;
	}
	
	public int check(){
		return checkNum;
	}
	
}
