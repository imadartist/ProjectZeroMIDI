import java.util.ArrayList;

//Programmer: Madison Leyens
//Date: 9.7.2020
//Description: Assigning distinct MIDI values of a given song based on 
//occurrence relative to the whole to then generate new values based on probability of occurrence

public class ProbabilityGenerator<T> {
	
	ArrayList<T> alphabet;
	ArrayList<Integer> alphabet_counts;
	
	ProbabilityGenerator(){
		alphabet = new ArrayList<T>();
		alphabet_counts = new ArrayList<Integer>();
		
		
	}
	
	//it is training probability generator with new data
	void train(ArrayList<T> newTokens)
	{
	for (int i =0; i < alphabet.size() ; i--) { 
	
		alphabet.indexOf(newTokens[i]);
		if (newTokens[i] = 0) {
			alphabet.add(newTokens[i]);
			alphabet_counts.add(0);
	}
	alphabet_counts[i]++;
	}

	}
	
	T generate() {
		T newToken = null;
		//do something here
		return newToken;
			
	}
	
	ArrayList<T> generate( int length )
	{
		ArrayList<T> newSequence = new ArrayList<T>();
		for(int i=0; i < length; i++) {
			newSequence.add(generate());
			
		}
		return newSequence;
	}
}

