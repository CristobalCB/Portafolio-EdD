package deck.sistem.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckList {

    private List<Card> cards;

    public DeckList() {
        this.cards = new ArrayList<Card>();
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

    public List<Card> getCards() {
        return cards;
    }

    /**
     * Elimina y retorna la primera carta del mazo.
     * @return - Primera carta del mazo.
     */
    public Card giveCard(){
        return cards.remove(0);
    }

    /**
     * Baraja las cartas actuales del mazo.
     */
    public void shuffle(){
        Collections.shuffle(cards);
    }

    /**
     * Muestra la primera carta del mazo sin sacarla.
     * @return - Primera carta del mazo.
     */
    public Card seeTop(){
        return cards.get(0);
    }
}
