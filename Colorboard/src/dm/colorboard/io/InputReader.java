package dm.colorboard.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dm.colorboard.component.Board;
import dm.colorboard.component.Card;
import dm.colorboard.component.Deck;
import dm.colorboard.component.Game;

/**
 * InputReader Class
 * @author dmurarik
 *
 */
public class InputReader{
	
	private final int PARSE_PLAYER_COUNT = 0;
	private final int PARSE_BOARD_SIZE = 1;
	private final int PARSE_DECK_SIZE = 2;
	
	private BufferedReader br;
	
	
	/**
	 * Constructor
	 * @param fileLocation File location to parse
	 * @throws FileNotFoundException
	 */
	public InputReader(String fileLocation) throws FileNotFoundException{
		br = new BufferedReader(new FileReader(fileLocation));
	}
	
	/**
	 * Read input stream for the next game
	 * @return Parsed game or null for EOF
	 */
	public Game readNextGame(){
		String line;
		Game nextGame = new Game();
		try {
			line = br.readLine();
			
			if(line.charAt(0) == '0')//EOF test
				return null;
			
			if(line != null){//Read game setup line
				parseGameSetupLine(nextGame, line);
			}
			
			//Read board string
			if((line = br.readLine()) != null){
				nextGame.getBoard().parseBoardFromString(line);
			}
			
			//Read deck 
			for(int i = 0; i < nextGame.getDeck().getDeckSize();i++){
				if((line = br.readLine()) != null){
					nextGame.getDeck().addCardToDeck(
							new Card(line.charAt(0), line.length() == 2)
							);
				}
			}
			return nextGame;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Parse game initialization line
	 * @param currentGame new Game 
	 * @param line line to parse
	 */
	private void parseGameSetupLine(Game currentGame, String line){
		String[] intsToParse = line.split(" ");
		int[] gameInfo = new int[intsToParse.length];
		// Parse each part in turn
		for (int i = 0; i < gameInfo.length; i++)
		{
			if(i == PARSE_PLAYER_COUNT){
				currentGame.setPlayerCount(Integer.parseInt(intsToParse[i]));
			}
			if(i == PARSE_BOARD_SIZE){
				currentGame.setBoard(new Board(Integer.parseInt(intsToParse[i])));
			}
			if(i == PARSE_DECK_SIZE){
				currentGame.setDeck(new Deck(Integer.parseInt(intsToParse[i])));
			}
		}
		
	}
}