package cs4233_midterm_problem2;

import java.util.ArrayList;

public class FindBest {
	
	Float[][] best; 
	
	Float[] scores;;
	
	Float[] current;
	
	private int seqInd;
	
	private int seqCount;

	public FindBest(ArrayList<String> sequences, Float[][] pwm) {
		
		scores = new Float[sequences.get(0).length() - pwm[0].length];
		
		best = new Float[sequences.size()][2];
		
		current = new Float[2];
		
		seqInd = 0;
		
		seqCount = 0;
		
		current[0] = (float) 0;
		current[1] = (float) 0;
		
		//Go through each sequence
		for(; seqCount < sequences.size(); seqCount++) {
			
			//go through every subsequence
			for(; seqInd < (sequences.get(0).length() - pwm[0].length); seqInd++) {
				
				int c = 0;
				scores[seqInd] = (float) 1;
				
				for(int i = seqInd; i < (seqInd + pwm[0].length); i++) {
					if(i >= sequences.get(0).length())
						break;
					switch ( sequences.get(seqCount).charAt(i)) {
					case 'A':
						scores[seqInd] *= pwm[0][c];
						break;
					case 'C':
						scores[seqInd] *= pwm[1][c];
						break;
					case 'G':
						scores[seqInd] *= pwm[2][c];
						break;
					case 'T':
						scores[seqInd] *= pwm[3][c];
						break;
					}
					c++;
				}
				//find the highest value for current sequence
				int retval = Float.compare(scores[seqInd], current[0]);
				if(retval > 0) {
					current[0] = scores[seqInd];
					current[1] = (float) seqInd;
				}
			}
			
			best[seqCount][0] = current[0];
			best[seqCount][1] = current[1];
			current[0] = (float) 0;
			current[1] = (float) 0;
			seqInd = 0;
		}
		
		printBest();
	}

	//Print the best values for each sequence and the location
	private void printBest() {
		System.out.println("Last value is the starting index of the subsequence starting from index of 0");
		for(int i = 0; i < best.length; i++) {
			System.out.println((i+1) + ":"  + "\t\t" + best[i][0] + "\t\t" + best[i][1]);
			
		}
		
	}

}
