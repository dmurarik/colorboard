package dm.colorboard.component;

/**
 * Player Class
 * @author dmurarik
 *
 */
public class Player{
	private String name;
	private int boardPosition = -1;
	
	/**
	 * Constructor
	 * @param playerNumber Actual Player number 
	 */
	public Player(int playerNumber){
		name = (new StringBuilder()).append("Player ").append(playerNumber).toString();
	}
	
	/**
	 * Get Players Display name
	 * @return String display name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Get board position
	 * @return Int array board position
	 */
	public int getBoardPosition(){
		return boardPosition;
	}
	
	/**
	 * Set board position
	 * @param boardPosition Int array board position
	 */
	public void setBoardPosition(int boardPosition){
		this.boardPosition = boardPosition;
	}
	
	
}