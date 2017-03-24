package cs4233_midterm_problem1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a program that takes as input an alignment, and outputs
 * the PWM and the information content of the PWM.
 * 
 * (To prevent prob = 0 from happening, add a pseducount 1 for 
 * each nucleotide. i.e., p_A = (c_A+1)/(c_A+C_c+c_G+c_T+4),
 * where c_A is the number of A's observed in the column. 
 * 
 * @author Juan A. Alonso
 *
 */
public class main {
	
	private static CreateAlignmentFromFile cAlignment;
	
	private static PWM pwm;
	
	private static ArrayList<String> alignment;

	private static String option;
	

	/**
	 * Main class to be the center of functionality for 
	 * the purpose of allowing other functions to be 
	 * used in other problems more easily
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * Inquire if the given sample is the desired alignment to check, if not
		 * prompt for the alignment to be manually inserted
		 */
		while(true){
			System.out.println("Would you like to use the sample given in the midterm(y/n)?");
			Scanner reader = new Scanner(System.in);
			option = reader.nextLine();
			if(option.equals("y") || option.equals("Y")){
			
				cAlignment = new CreateAlignmentFromFile("MidtermSample.txt");
				alignment = cAlignment.getAlignment();
				break;
			}
			
			else if(option.equals("n") || option.equals("N")){
				System.out.println("Input the location of the file containing the alignment");
				option = reader.nextLine();
				cAlignment = new CreateAlignmentFromFile(option);
				alignment = cAlignment.getAlignment();
				if(cAlignment.check() == 1)
					break;
				else
					System.out.println("Invalid file path\n");
			}
		
			else {
				System.out.println("invalid entry");
			}
		}
		
		pwm = new PWM(alignment);
			
	}

}
