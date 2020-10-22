import java.util.ArrayList;

/*
 * Programmer: Madison Leyens
 * Class: OrderM
 * Date: 9.20.2020
 * Description: Markov Generator of Order M
 */

import java.util.ArrayList;

public class OrderM<T> extends MarkovGenerator<T> {
	ArrayList<ArrayList<Integer>> transitionTable = new ArrayList(); // declaring the transition table array list which
																		// holds an array list of an array list of
																		// integers
	MarkovGenerator<T> markovGen = new MarkovGenerator(); // using markov generator class to declare a markov generator
	ArrayList<ArrayList<T>> uniqueAlphabetSequences = new ArrayList(); // add the previous tokens to a container
	int orderM; // declare orderM as a global variable

	OrderM(int sequenceSize) {
		super(); // allows inheritance of other classes
		orderM = sequenceSize; // set orderM equal to sequenceSize, which the user will pass in
	}

	void train(ArrayList<T> newTokens) { // filling the empty transition table
		for (int i = orderM - 1; i < newTokens.size() - 1; i++) { // loops starting at one less than the sequence size
																	// for one less than newTokens size
			
			
			ArrayList<T> curSequence = new ArrayList (newTokens.subList(i - (orderM - 1), i)); // create the current sequence of size Order M from the input
			//adding previous tokens; read about inclusive exclusive...sublists are exclusive
			System.out.println(curSequence);
//			// uniqueAlphabetSequences.add(orderM); //add array list of sequences to uniqueAlphabetSequences. do i need this?
//
//			//int rowIndex = uniqueAlphabetSequences.indexOf(newTokens.get(i)); //setting rowIndex equal to the indices in newTokens in uniqueAlphabetSequences
//
////	if (curSequence == -1) { //if curSequence is not found
////		int rowIndex = uniqueAlphabetSequences.size(); //TRY ONE setting rowIndex equal to the size of uniqueAlphabetSequences
//
//
////		how do i use rowIndex? i am using it in curSequence, right? 
//
////			uniqueAlphabetSequences.add(curSequences);
//
////a lot of the below is borrowed from Markov Generator. Would inheritance have been better?
//
//			ArrayList<Integer> myRow = new ArrayList(); // create a row array list to add a new row
//			transitionTable.add(myRow);// add the new row to the transition table
//			for (int m = 0; m < alphabet.size(); m++) { // new row will start at 0 and loop through all possible
//														// values in alphabet
//				myRow.add(0); // add a 0 to myRow array list
//			}
//
//			alphabet.add(newTokens.get(i)); // add the newToken to alphabet
//			for (int j = 0; j < transitionTable.size(); j++) { // looping through all of the transition table
//				ArrayList<Integer> row = transitionTable.get(j); // using the new token at myRow to a new column
//																	// (horizontal expansion)
//				row.add(0);
//			}
////	}
//
//			// adding the counts to the transition table
//			if (lastIndex > -1) { // if we have a token and it is not the first time through
//				int tokenIndex = alphabet.indexOf(newTokens.get(i + 1));
//				// if (tokenIndex == -1) { //if tokenIndex is not found in the alphabet
//				// tokenIndex = alphabet.size();
//				// alphabet.add(tokenIndex);
//				// expand the transition table horizontally
//				// }
//
//				// updating the counts
//				ArrayList<Integer> row = transitionTable.get(lastIndex); // get whatever the lastIndex is in transition
//																			// table and set it to the row array
//				Integer transitionColumn = row.get(tokenIndex); // get the row using tokenIndex
//				Integer transitionRow = row.get(rowIndex);
//				transitionColumn++;// increment the tokenIndex
//				transitionRow++;
//				row.set(tokenIndex, transitionColumn, transitionRow);
//			}
//			lastIndex = tokenIndex; // setting current index to previous for next loop
		}
	}
}

/*
 * T generate(ArrayList initSeq) { curSeqIndex = find the index of initSeq in
 * uniqueAlphabetSequence if(initSeq is not found) { 1. generate from a trained
 * markov chain 1 //note – there are other solutions, you could generate from
 * prob. dist. instead. //you could rollback your generation one character &
 * generate again
 * 
 * //whatever you choose will affect your transition tables in Unit 3 – note
 * that only the sequences // found in training will have the reported
 * probabilities for each row. Eg. you will see "discrepancies" //in the
 * rhythms, as the symbol 4.0 comes after things but nothing comes after it. }
 * else { 1. find the row in the transition table using curSeqIndex 2. generate
 * from that row using your Probability Generator //note: remember to handle 0%
 * probability across all tokens }
 * 
 * ArrayList generate(ArrayList initSeq, int numTokensToGen) { 1. create an
 * ArrayList of T - outputMelody 2. for 1 to numTokensToGen do { 1. call your
 * single generate using your initSeq 2. remove the first token you added from
 * your initSeq 3. add the generated token to your initSeq 4. add the generated
 * token to outputMelody 5. remove the first token off the top of the initSeq }
 * }
 */
 