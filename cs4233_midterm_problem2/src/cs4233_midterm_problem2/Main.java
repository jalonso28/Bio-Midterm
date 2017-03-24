package cs4233_midterm_problem2;

import java.util.ArrayList;

public class Main {
	
	private static CreateLists createLists;
	
	private static FindBest matches;
	
	private static ArrayList<String> sequences;
	
	private static Float[][] pwm;

	public static void main(String[] args) {
		
		createLists = new CreateLists("seq.txt", "ppm.txt");
		
		sequences = createLists.getSequences();
		
		pwm = createLists.getPwm();
		
		matches = new FindBest(sequences, pwm);
		
		
	}

}
