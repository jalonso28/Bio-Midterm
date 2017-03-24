package cs4233_midterm_problem3b;

import java.util.ArrayList;

/**
 * Implement the pattern-based motif finding algorithm. 
 * Your program should take as input a set of sequences and 
 * a parameter k (motif length), and output the consensus 
 * with the smallest total number of mismatches to all sequences. 
 * Your program should also report the total number of mismatches, 
 * the matched subsequences and locations on each sequence, and the 
 * amount of wall-clock time taken by your program to find the consensus.
 * 
 * @author Juan A. Alonso
 *
 */
public class Main {

	private static CreateList createList;
	
	private static ArrayList<String> sequences;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		createList = new CreateList("seq.txt");
		
		sequences = createList.getSequences();

	}

}
