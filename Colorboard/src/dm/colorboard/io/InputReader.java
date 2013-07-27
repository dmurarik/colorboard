package dm.colorboard.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dm.colorboard.component.Board;
import dm.colorboard.component.Card;
import dm.colorboard.component.Deck;
import dm.colorboard.component.FormatException;
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
	private final char END_OF_FILE_CHAR = '0';
	
	
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
	 * @throws FormatException 
	 * @throws IOException 
	 */
	public Game readNextGame() throws FormatException, IOException{
		String line;
		Game nextGame = new Game();
		if((line = br.readLine()) != null){
			char initalChar = line.charAt(0);
			if(initalChar == END_OF_FILE_CHAR){//EOF test
				br.close();
				return null;
			}
			if(!Character.isDigit(initalChar))//If this is not a digit there is a formatting error
				throw new FormatException("Incorrect input format");
			
			parseGameSetupLine(nextGame, line);//Read game setup line
			
		}
		
		if((line = br.readLine()) != null){
			nextGame.getBoard().parseBoardFromString(line);//Read board string
		}
		
		
		for(int i = 0; i < nextGame.getDeck().getDeckSize();i++){
			if((line = br.readLine()) != null){
				nextGame.getDeck().addCardToDeck(//Read deck 
						new Card(line.charAt(0), line.length() == 2)
						);
			}
		}
		
		return nextGame;
	}
	
	/**
	 * Parse game initialization line
	 * @param currentGame new Game 
	 * @param line line to parse
	 * @throws FormatException 
	 */
	private void parseGameSetupLine(Game currentGame, String line) throws FormatException{
		String[] intsToParse = line.split(" ");
		if(intsToParse.length <= 2)
			throw new FormatException("Incorrect input format. Game initialization line");
		// Parse each part in turn
		for (int i = 0; i < intsToParse.length; i++)
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