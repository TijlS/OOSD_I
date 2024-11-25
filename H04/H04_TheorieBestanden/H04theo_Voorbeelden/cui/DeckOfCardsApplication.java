package cui;

import java.util.ArrayList;
import java.util.List;

import domein.Card;
import domein.DeckOfCards;

public class DeckOfCardsApplication {

	public static void main(String args[]) {
		new DeckOfCardsApplication().makeDeckAndGiveCards();
	}

	private void makeDeckAndGiveCards() {
		DeckOfCards deck = new DeckOfCards(); // <.>
		System.out.printf("Before dealing: the fresh deck of cards contains %d cards.%n", deck.giveNumberOfCards());

		// <.>
		List<Card> handPlayer1 = new ArrayList<>();
		List<Card> handPlayer2 = new ArrayList<>();

		// <.>
		for (int i = 0; i < 8; i++) {
			handPlayer1.add(deck.dealCard());
			handPlayer2.add(deck.dealCard());
		}

		showHand("Player 1", handPlayer1);
		showHand("Player 2", handPlayer2);

		System.out.printf("%nAfter dealing: the deck of cards now contains %d cards.%n", deck.giveNumberOfCards());
	}

	private void showHand(String playerName, List<Card> cards) {
		System.out.printf("%nHand of %S%n", playerName);
		for (Card card : cards) {
			System.out.printf("- %s%n", card);
		}
	}
}
