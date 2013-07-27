package dm.colorboard;

import java.io.FileNotFoundException;
import java.io.IOException;

import dm.colorboard.component.Game;
import dm.colorboard.io.InputReader;
import dm.colorboard.io.OutputWriter;

public class Main{
	
	private static final String INPUT_FILE = "resources/colorboard.in";
	private static final String OUTPUT_FILE = "output/colorboard.out";
	
	public static void main(String[] args) {
		InputReader inputReader = null;
		OutputWriter outputWriter = null;
		
		try {
			//Setup the input reader
			inputReader = new InputReader(INPUT_FILE);
			outputWriter = new OutputWriter(OUTPUT_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Failed to create input reader");
			return;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to create output writer");
			return;
		}
		
		//User one or the other
		//writeToConsole(inputReader);
		writeToFile(inputReader, outputWriter);
		
	}
	
	private static void writeToFile(InputReader inputReader, OutputWriter outputWriter){
		Game game;
		while((game = inputReader.readNextGame()) != null){//Loop through games until null game is returned
			try {
				outputWriter.writeln(game.runGame());
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Output writer failed to write");
			}
		}
		try {
			outputWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void writeToConsole(InputReader inputReader){
		Game game;
		while((game = inputReader.readNextGame()) != null){//Loop through games untill null game is returned
			System.out.println(game.runGame());
		}
	}

}