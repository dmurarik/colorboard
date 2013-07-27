package dm.colorboard.component;


/**
 * Game Class
 * @author dmurarik
 *
 */
public class Game{
	private final String RESULT_FORMAT = "%s won after %d cards.";
	private final String NO_PLAYER = "No Player";
	
	private Board board;
	private Player[] players;
	private Deck deck;
	private int currentPlayerTurn = 0;//keep track of the current players turn
	
	public Game(){}

	/**
	 * Get game board
	 * @return Game board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Set game board
	 * @param board Game board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * Get game players
	 * @return Players
	 */
	public Player[] getPlayers() {
		return players;
	}

	/**
	 * Set actual player count
	 * @param playerCount Actual player count
	 */
	public void setPlayerCount(int playerCount) {
		players = new Player[playerCount];
		for(int i = 0; i < playerCount;i++){
			players[i] = new Player(i+1);
		}
	}

	/**
	 * Get game deck
	 * @return Deck
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * Set game deck
	 * @param deck Deck
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	/**
	 * Run this game and returns the results
	 * @return Results of the game
	 */
	public String runGame(){
		Player activePlayer;
		for(int i = 0; i < deck.getDeckSize();i++){//Loop through the deck until a winner is found
			activePlayer = getNextPlayer();
			updatePlayerPosition(activePlayer, deck.pullTopCard());
			if(checkIfPlayerWon(activePlayer)){
				return String.format(RESULT_FORMAT, activePlayer.getName(), i+1);
			}
		}
		return String.format(RESULT_FORMAT, NO_PLAYER, deck.getDeckSize());//No winner the deck was finished
	}
	
	/**
	 * Get the next player in turn
	 * @return Player
	 */
	private Player getNextPlayer(){
		Player player = players[currentPlayerTurn];
		currentPlayerTurn++;
		if(currentPlayerTurn > players.length-1)
			currentPlayerTurn = 0;
		return player;
	}
	
	/**
	 * Update the players position on the board
	 * @param player Player who drew the card
	 * @param cardPulled Card the player pulled from the deck
	 */
	private void updatePlayerPosition(Player player, Card cardPulled){
			player.setBoardPosition(
					board.findNextColorPosition(player.getBoardPosition(), cardPulled.getColor())
					);
			if(cardPulled.isDouble()){//If its a double card move again 
				player.setBoardPosition(
						board.findNextColorPosition(player.getBoardPosition(), cardPulled.getColor())
								);
			}
		
	}
	
	/**
	 * Test if this player won the game
	 * @param player Player to be tested
	 * @return true if this player won the game
	 */
	private boolean checkIfPlayerWon(Player player){
		if(player.getBoardPosition() == board.getBoardLenght())
			return true;
		else
			return false;
	}
	
}