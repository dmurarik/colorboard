package dm.colorboard.component;


/**
 * Board Class
 * @author dmurarik
 *
 */
public class Board{
	private final char squares[];
	
	/**
	 * Constructor
	 * @param boardLength Actual board length
	 */
	public Board(int boardLength){
		this.squares = new char[boardLength];
	}
	
	/**
	 * Populate board from string input
	 * @param line String to parse
	 * @throws FormatException 
	 */
	public void parseBoardFromString(String line) throws FormatException{
		if(line.length() != squares.length)
			throw new FormatException("Incorrect input format. Board length and actual do not match");
		
		for(int i = 0; i < line.length();i++){
			squares[i] = line.charAt(i);
		}
	}
	
	/**
	 * Get boards array length
	 * @return returns Array Length
	 */
	public int getBoardLenght(){
		return squares.length;
	}
	
	/**
	 * Finds the position of the next color
	 * @param currentPosition Position from which to start the search
	 * @param color The next color position to search for
	 * @return Requested color position or last position if none are in front
	 */
	public int findNextColorPosition(int startPosition, char color){
		for(int i = startPosition+1; i < squares.length; i++){//loop down the board to find the requested color
			if(squares[i] == color){
				return i;
			}
		}
		return squares.length; //Reached the of the board
	}
}