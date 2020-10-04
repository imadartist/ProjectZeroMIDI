import java.util.ArrayList;

/*
 * Programmer: Madison Leyens
 * Class: OrderM
 * Date: 9.20.2020
 * Description: Markov Generator of Order M
 */

//import java.util.ArrayList;

public class OrderM <T> extends MarkovGenerator<T>{
	ArrayList<ArrayList<Integer>> transitionTable = new ArrayList();


OrderM() {
	super();
}

void train(ArrayList<T> newTokens) { //filling the empty transition table
	
	//for (i = orderM-1 ; i < newTokens.size() - 1; i++) {
		
	//}
}
}

/*
 * 	T generate(ArrayList initSeq)
	{	
		curSeqIndex  = find the index of initSeq in uniqueAlphabetSequence 
		if(initSeq is not found)
		{
			1. generate from a trained markov chain 1
			//note – there are other solutions, you could generate from prob. dist. instead.
			//you could rollback your generation one character & generate again

			//whatever you choose will affect your transition tables in Unit 3 – note that only the sequences 
			// found in training will have the reported probabilities for each row. Eg. you will see "discrepancies"
			//in the rhythms, as the symbol 4.0 comes after things but nothing comes after it.
		}
		else
		{
			1. find the row in the transition table using curSeqIndex  
			2. generate from that row using your Probability Generator 
			//note: remember to handle 0% probability across all tokens
		}

	ArrayList generate(ArrayList initSeq, int numTokensToGen)
	{
		1.	create an ArrayList of T - outputMelody
		2.	for 1 to numTokensToGen do 
		{
			1.	call your single generate using your initSeq
			2.	remove the first token you added from your initSeq
			3.	add the generated token to your initSeq
			4.	add the generated token to outputMelody
			5.	remove the first token off the top of the initSeq
		}
	}
 * */
 