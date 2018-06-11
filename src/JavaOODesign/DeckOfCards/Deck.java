package JavaOODesign.DeckOfCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Robert on 5/25/2018.
 */
public class Deck {
    private final static int i = 0;
    private List<Card> cards;
    private static final Random RAND = new Random();

    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (int i = 0; i < 13; i++) {
                Card card = new Card(suit, i);
            }
        }

    }

    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int newPos = RAND.nextInt(cards.size() - i) + i;
            swap(cards, newPos, i);
        }
    }

    private void swap(List<Card> cards, int newPos, int oldPos) {
        Card temp = cards.get(newPos);
        cards.set(newPos, cards.get(oldPos));
        cards.set(oldPos, temp);
    }

    public void deal() {

    }
}
