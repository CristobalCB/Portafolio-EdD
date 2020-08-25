package deck.sistem.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeckQueue {

    private Queue<Card> cards;

    public DeckQueue() {
        this.cards = new LinkedList<>();
        CardType[] types = CardType.values();
        CardRank[] ranks = CardRank.values();
        int type = 0;
        for (int i = 0 ; i<52 ;i++) {
            cards.add(new Card(types[type], ranks[i%13]));
            if(i%13 == 12){ type++; }
        }
        cards.add(new Card(types[4],ranks[13]));
        cards.add(new Card(types[5],ranks[13]));
    }

    public Queue<Card> getCards() {
        return cards;
    }

    /**
     * Elimina y retorna la primera carta del mazo.
     * @return - Primera carta del mazo.
     */
    public Card giveCard(){
        return cards.poll();
    }

    /**
     * Baraja las cartas actuales del mazo.
     */
    public void shuffle(){
        Collections.shuffle((List<Card>) cards);
    }

    /**
     * Muestra la primera carta del mazo sin sacarla.
     * @return - Primera carta del mazo.
     */
    public Card seeTop(){
        return cards.peek();
    }
}
