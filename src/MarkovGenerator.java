/*
 * Programmer: Madison Leyens
 * Class: MelodyPlayer
 * Date: 9.20.2020
 * Description: Generating melodies not just based on probability of occurrence of a given note but also using the probability of 
 * the note appearing at a given position in the sequence of notes
 */

import java.util.ArrayList;

//Markov Generator will use ProbabilityGenerator to get the counts and probabilities

public class MarkovGenerator<T> extends ProbabilityGenerator<T> {

	MarkovGenerator() {
		super();
	}
	
	void train(ArrayList<T> newTokens) {
		
	}
	
	ArrayList<T> generate( int length ) 
	{
		ArrayList<T> newSequence = new ArrayList<T>();
//		for(int i=0; i<length; i++)
//		{
//			newSequence.add(generate());			
//		}
		return newSequence;
	}
	
	ArrayList<T> generate( int length, T initToken )
	{
		ArrayList<T> newSequence = new ArrayList<T>();
//		for(int i=0; i<length; i++)
//		{
//			newSequence.add(generate());
//		}
		return newSequence;
	}
	/*
	 * ArrayList<ArrayList<Integer>> transitionTable( ArrayList alphabet<int input>
	 * ); { 
	 * to create the ArrayList 
	 * transitionTable = new ArrayList();
	 * 
	 * to add a row 
	 * ArrayList<Integer> myRow = new ArrayList(); myRow.add(8);
	 * 
	 * to get the 0th (i.e., first) ArrayList or row from our ArrayList of
	 * Arraylists:
	 * 
	 * ArrayList<Integer> row = transitionTable.get(0);
	 * 
	 * then to get the 0th element from the row (assuming it is both not empty &
	 * has been instantiated) Integer myElement = row.get(0);
	 * 
	 * System.out.println(row.get(0)); //will print 8. }
	 */
}
