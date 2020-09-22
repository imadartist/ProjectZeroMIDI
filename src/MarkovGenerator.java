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
		int lastIndex = -1;
		for (int i = 0; i < newTokens.size(); i++) {
			int tokenIndex = alphabet.indexOf(newTokens.get(i));
			if (lastIndex == -1) {
				tokenIndex = alphabet.size();
				ArrayList<ArrayList<Integer>> transitionTable = new ArrayList();
				ArrayList<Integer> myRow = new ArrayList();
				myRow.add(tokenIndex);
				ArrayList<Integer> row = transitionTable.get(0);
				Integer myElement = row.get(0);
			} if (lastIndex > -1 ) {
				//ArrayList<Integer> row = transitionTable.get(lastIndex);
				
				
			}
			 lastIndex = tokenIndex;
		}
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

}
