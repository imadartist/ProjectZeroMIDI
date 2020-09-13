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
		fill(120, 50, 240);
		
		//create my generators for pitch and rhythm
		ProbabilityGenerator<Integer>pitchGenerator =  new ProbabilityGenerator<Integer>();
		ProbabilityGenerator<Double>rhythmGenerator =  new ProbabilityGenerator<Double>();
		
		
		// returns a url
		String filePath = getPath("mid/gardel_por.mid");
		
		// playMidiFile(filePath);
		midiNotes = new MidiFileToNotes(filePath); //creates a new MidiFileToNotes -- reminder -- ALL objects in Java must 
													//be created with "new". Note how every object is a pointer or reference. Every. single. one.


//		// which line to read in --> this object only reads one line (or ie, voice or ie, one instrument)'s worth of data from the file
		midiNotes.setWhichLine(0);
		
		//training the generators for pitch and rhythm to get the pitch and rhythm arrays from the MIDI Notes object 
		pitchGenerator.train(midiNotes.getPitchArray());
		rhythmGenerator.train(midiNotes.getRhythmArray());
		
		//enables use to generate and play a MIDI sequence file
		player = new MelodyPlayer(this, 100.0f);
		player.setup();
		player.setMelody( pitchGenerator.generate(20) );
		player.setRhythm( rhythmGenerator.generate(20) );
	}

	public void draw() {
		//player.play(); //play each note in the sequence -- the player will determine whether is time for a note onset
		//this is what the user sees that allows them to start the program
		textSize(12);
		fill(0,102,153);
		text("Press 1 to start the unit test!", width/4, height/2);
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
		//this calls the Probability Generator class delineated by Pitch and Rhythm
		ProbabilityGenerator<Integer> generatorPitch = new ProbabilityGenerator(); 
		ProbabilityGenerator<Double> generatorRhythm = new ProbabilityGenerator();
		
		MidiFileToNotes midiNotesMary; //read a midi file
		
		// returns a url
		String filePath = getPath("mid/MaryHadALittleLamb.mid");
		// playMidiFile(filePath);

		midiNotesMary = new MidiFileToNotes(filePath);//creates a new MidiFileToNotes -- reminder -- ALL objects in Java must 
		//be created with "new". Note how every object is a pointer or reference. Every. single. one.


		// which line to read in --> this object only reads one line (or ie, voice or ie, one instrument)'s worth of data from the file
		midiNotesMary.setWhichLine(0);
		
		//training the generators for pitch and rhythm to get the pitch and rhythm arrays from the MIDI Notes Mary object 
		generatorPitch.train(midiNotesMary.getPitchArray());
		generatorRhythm.train(midiNotesMary.getRhythmArray());
		
		if (key == ' ') {
			player.reset();
			println("Melody started!");
		} else if( key == '1') {
			//runs unit 1 test when the user presses "1" by printing both the pitch and rhythm tokens & probabilities using the methods in ProbabilityGenerator
			generatorPitch.printProbabilityDistribution("Pitches:");
			generatorRhythm.printProbabilityDistribution("Rhythms:");
			
		} else if (key == '2') {
			//runs unit 2 test
			generatorPitch.printProbabilityDistribution("Pitches:");
			generatorRhythm.printProbabilityDistribution("Rhythms:");
			
		}
		}
	}
}