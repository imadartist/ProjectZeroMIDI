import java.util.ArrayList;

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
}
