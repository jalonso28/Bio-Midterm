package cs4233_midterm_problem3a;

import java.util.ArrayList;
import java.util.List;

public class PossibleMotifs {
	
	private ArrayList<String> motifs = new ArrayList<String>();
	
	List<char[]> subsets = new ArrayList<>();
	
	private ArrayList<String> ch = new ArrayList<String>();
	

	public  PossibleMotifs(int k) {
		ch.add("A");
		ch.add("C");
		ch.add("G");
		ch.add("T");
	    int carry;
	    int[] indices = new int[k];
	    do
	    {
	        for(int index : indices)
	            motifs.add(ch.get(index));
	        

	        carry = 1;
	        for(int i = indices.length - 1; i >= 0; i--)
	        {
	            if(carry == 0)
	                break;

	            indices[i] += carry;
	            carry = 0;

	            if(indices[i] == ch.size())
	            {
	                carry = 1;
	                indices[i] = 0;
	            }
	        }
	    }
	    while(carry != 1); // Call this method iteratively until a carry is left over
	}
	
	public ArrayList<String> getMotifs() {
		return motifs;
	}

}
