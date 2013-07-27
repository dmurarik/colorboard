package dm.colorboard.component;

/**
 * Card Class
 * @author dmurarik
 *
 */
public class Card{
	private final char color;
	private final boolean doubleCard;
	
	/**
	 * Constructor
	 * @param color Char representing the card color
	 * @param doubleCard The card is a double color
	 * @throws FormatException 
	 */
	public Card(char color, boolean doubleCard) throws FormatException{
		if(!Character.isLetter(color))
			throw new FormatException("Incorrect card input");
		this.color = color;
		this.doubleCard = doubleCard;
			
	}
	
	/**
	 * Get card color
	 * @return Char representing the card color
	 */
	public char getColor(){
		return color;
	}
	
	/**
	 * Is the card a double color
	 * @return boolean 
	 */
	public boolean isDouble(){
		return doubleCard;
	}
	
}