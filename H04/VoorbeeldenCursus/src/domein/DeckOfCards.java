package domein;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
	private List<Card> cards; // <.>
	private SecureRandom random = new SecureRandom();

	public DeckOfCards() {
		// <.>
		String[] faces = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King" };
		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

		cards = new ArrayList<>(); // <.>

		// <.>
		for (String face : faces)
			for (String suit : suits)
				cards.add(new Card(face, suit));

		shuffle();
	}

	private void shuffle() { // <.>
		for (int index = 0; index < cards.size(); index++) { // <.>
			int indexToSwap = random.nextInt(cards.size()); // <.>
			// <.>
			Card temp = cards.get(index);
			cards.set(index, cards.get(indexToSwap));
			cards.set(indexToSwap, temp);
		}
	}

	public int giveNumberOfCards() { // <.>
		return cards.size();
	}

	public Card dealCard() { // <.>
		if (!cards.isEmpty()) {
			return cards.removeFirst(); // <.>
		}
		return null; // <.>
	}
}
