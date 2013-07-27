package dm.colorboard.component;

import java.util.ArrayList;

/**
 * Deck class
 * @author dmurarik
 *
 */
public class Deck{
	private ArrayList<Card> cards;
	private int deckSize = 0;
	
	/**
	 * Constructor
	 * @param deckSize Actual size of the deck
	 */
	public Deck(int deckSize){
		cards = new ArrayList<Card>(deckSize);
		this.deckSize = deckSize; 
	}
	
	/**
	 * Add a card to the deck
	 * @param card Card to be added
	 */
	public void addCardToDeck(Card card){
		cards.add(card);
	}
	
	/**
	 * Get the deck size
	 * @return The actual deck size
	 */
	public int getDeckSize(){
		return deckSize;
	}
	
	/**
	 * Removes the top card and returns it
	 * @return Top card pulled
	 */
	public Card pullTopCard(){
		return cards.remove(0);
	}
	
}