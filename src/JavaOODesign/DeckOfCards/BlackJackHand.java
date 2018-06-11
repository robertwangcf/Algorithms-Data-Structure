/*
package JavaOODesign.DeckOfCards;

*/
/**
 * Created by Robert on 5/25/2018.
 *//*

public class BlackJackHand extends Hand{
    BlackJackHand() {
        super();
    }

    public int score() {
        int score = 0;
        if (cards.size() == 0) {
            return score;
        }

        int numOfAce = 0;
        for (int i = 0; i < cards.size(); i++) {
            final int valueOfCard = cards.get(i).value;
            if (valueOfCard == 1) {
                numOfAce++;
            }
            if (valueOfCard == 11
                    || valueOfCard == 12
                    || valueOfCard == 13
            ) {
                score += 10;
            }
        }

        for (int i = 0; i < numOfAce; i++) {
            if (score + 11 > 21) {
                score += 1;
            } else {
                score += 11;
            }
        }

        return score;
    }
}
*/
