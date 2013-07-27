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
	 */
	public Card(char color, boolean doubleCard){
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