/*
 * Programmer: Madison Leyens
 * Class: ProjectZeroMIDIMain
 * Date: 9.15.2020
 * Description: Main Class that holds all unit tests
 */
import processing.core.*;

import java.util.*; 

//importing the JMusic stuff
import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.midi.*;

import java.io.UnsupportedEncodingException;
import java.net.*;

//import javax.sound.midi.*;

public class ProjectZeroMIDIMain extends PApplet {

	MelodyPlayer player; //play a midi sequence
	MidiFileToNotes midiNotes; //read a midi file

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("ProjectZeroMIDIMain"); //change this to match above class & file name 

	}

	//setting the window size to 300x300
	public void settings() {
		size(500, 500);

	}

	//doing all the setup stuff
	public void setup() {
//		fill(120, 50, 240);
//		
//		//create my generators for pitch and rhythm
//		ProbabilityGenerator<Integer>pitchGenerator =  new ProbabilityGenerator<Integer>();
//		ProbabilityGenerator<Double>rhythmGenerator =  new ProbabilityGenerator<Double>();
//		
//		//MarkovGenerator<Integer>pitchMarkovGenerator =  new MarkovGenerator<Integer>();
//		MarkovGenerator<Double>rhythmMarkovGenerator =  new MarkovGenerator<Double>();
//		
//		// returns a url
//		String filePath = getPath("mid/gardel_por.mid");
//		
//		// playMidiFile(filePath);
//		midiNotes = new MidiFileToNotes(filePath); //creates a new MidiFileToNotes -- reminder -- ALL objects in Java must 
//													//be created with "new". Note how every object is a pointer or reference. Every. single. one.
//
//
////		// which line to read in --> this object only reads one line (or ie, voice or ie, one instrument)'s worth of data from the file
//		midiNotes.setWhichLine(0);
//		
//		//training the generators for pitch and rhythm to get the pitch and rhythm arrays from the MIDI Notes object 
//		pitchGenerator.train(midiNotes.getPitchArray());
//		rhythmGenerator.train(midiNotes.getRhythmArray());
//		
//		//enables use to generate and play a MIDI sequence file
//		player = new MelodyPlayer(this, 100.0f);
//		player.setup();
//		player.setMelody( pitchGenerator.generate(20) );
//		player.setRhythm( rhythmGenerator.generate(20) );
//		player.setMelody( pitchMarkovGenerator.generate(20) );
//		player.setRhythm( rhythmMarkovGenerator.generate(20) );
	}

	public void draw() {
		//player.play(); //play each note in the sequence -- the player will determine whether is time for a note onset
		//this is what the user sees that allows them to start the program
		
		//start and stop boolean
		
		textSize(12);
		fill(0,102,153);
		text("Press 1 to start unit test 1, 2 to start unit test 2, 3 to start unit test 3, and 4 to start unit test 4!", width/4, height/2);
		
	}

	//this finds the absolute path of a file
	String getPath(String path) {

		String filePath = "";
		try {
			filePath = URLDecoder.decode(getClass().getResource(path).getPath(), "UTF-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

	//this function is not currently called. you may call this from setup() if you want to test
	//this just plays the midi file -- all of it via your software synth. You will not use this function in upcoming projects
	//but it could be a good debug tool.
	void playMidiFile(String filename) {
		Score theScore = new Score("Temporary score");
		Read.midi(theScore, filename);
		Play.midi(theScore);
	}

	//this starts & restarts the melody.
	public void keyPressed() {
		
		//DECLARING GENERATORS 
		//why do I have probability generators declared and training in setup?
		
		//Project 1 - this calls the Probability Generator class delineated by Pitch and Rhythm
		ProbabilityGenerator<Integer> generatorPitch = new ProbabilityGenerator(); 
		ProbabilityGenerator<Double> generatorRhythm = new ProbabilityGenerator();
		
		//Project 1 - this class the Markov Generator class delineated by Pitch and Rhythm EXTRA?
		MarkovGenerator<Integer> markovPitches = new MarkovGenerator();
		MarkovGenerator<Double> markovRhythms = new MarkovGenerator();
		
		//Project 2 - declaring Markov Generator array lists for pitches and rhythms
		MarkovGenerator<Integer> mPitches = new MarkovGenerator();
		MarkovGenerator<Double> mRhythms = new MarkovGenerator();
		
		//Project 3 - declaring Order M Markov Generator array lists for pitches and rhythms;
		OrderM<Integer> pitchesOrderM = new OrderM(2); 
		OrderM<Double> rhythmsOrderM = new OrderM(2); 
		
		//MidiNotesMary setup
		MidiFileToNotes midiNotesMary; //read a midi file
		String filePath = getPath("mid/MaryHadALittleLamb.mid"); // returns a url
		midiNotesMary = new MidiFileToNotes(filePath);//creates a new MidiFileToNotes 
		midiNotesMary.setWhichLine(0); // which line to read in --> this object only reads one line (or ie, voice or ie, one instrument)'s worth of data from the file
		
		//TRAINING GENERATORS
		//Project 1 - training the generators for pitch and rhythm to get the pitch and rhythm arrays from the MIDI Notes Mary object 
		generatorPitch.train(midiNotesMary.getPitchArray());
		generatorRhythm.train(midiNotesMary.getRhythmArray());
		
		//Project 1 - Why do I not train markovPitches and markovRhythms?

		//Project 2 - training the markov generators for pitch and rhythm to get the pitch and rhythm arrays from the MIDI Notes Mary object 
		mPitches.train(midiNotesMary.getPitchArray());
		mRhythms.train(midiNotesMary.getRhythmArray());
		
		//Project 3- training the Order M markov generators for pitch and rhythm to get the pitch and rhythm arrays from the MIDI Notes Mary object 
		pitchesOrderM.train(midiNotesMary.getPitchArray());
		rhythmsOrderM.train(midiNotesMary.getRhythmArray());
		System.out.println("here");
		
		if (key == ' ') {
			player.reset();
			println("Melody started!");
		} else if( key == '1') { 
			//runs Project 0 Unit 1 test when the user presses "1" by printing both the pitch and rhythm tokens & probabilities using the methods in ProbabilityGenerator
			generatorPitch.printProbabilityDistribution("Pitches:");
			generatorRhythm.printProbabilityDistribution("Rhythms:");
			
		} else if (key == '2') {
			//runs Project 0 Unit 2 test when the user presses "2" and calls the generate function to make a melody with 20 notes and then print the pitches and rhythms to the console
			System.out.println(generatorPitch.generate(20));
			System.out.println(generatorRhythm.generate(20));
			
		} else if (key=='3') {
			//runs Project 0 Unit 3 test when the user presses "3" and probabilities are calculated and printed for melodies of 20 notes 10,000 times
			ProbabilityGenerator<Integer> probDistPitch = new ProbabilityGenerator(); 
			ProbabilityGenerator<Double> probDistRhythm = new ProbabilityGenerator();
			for (int i = 0; i < 10000; i++) {	
				probDistPitch.train(generatorPitch.generate(20));
				probDistRhythm.train(generatorRhythm.generate(20));
			}
				probDistPitch.printProbabilityDistribution("ProbDist Pitches:");
				probDistRhythm.printProbabilityDistribution("ProbDist Rhythms:");
				
		} else if (key=='4') {
			//runs unit 4 test when the user presses "4"
			int initTokenOne = generatorPitch.generate();
			double initTokenTwo = generatorRhythm.generate();
			
			mPitches.printTransitionTable("Markov Unit Test 1 Pitches:");
			mRhythms.printTransitionTable("Markov Unit Test 1 Rhythms:");
			
		} else if (key=='5') {
			
			System.out.println(mPitches.generate(20));
			System.out.println(mRhythms.generate(20));
			

			}
		}
}
//		//} else if (key == '6') {
			//markovPitches.printTransitionTable("Markov Pitches:");
//			System.out.println(" ");
//			markovRhythms.printTransitionTable("Markov Rhythms:");
//			
//			mPitches.printTransitionTable("Markov New Melody Pitches:");
//			mRhythms.printTransitionTable("Markove New Melody Rhythms:");
			//training and generating melodies of 20 notes 10000 times
//			for (int i = 0; i< 10000; i++)  { 
//			mPitches.train(generatorPitch.generate(20));
//			mRhythms.train(generatorRhythm.generate(20)); 
//			}
		//}
		//} else if (key == '7') {
			
		//}
		
		
	
