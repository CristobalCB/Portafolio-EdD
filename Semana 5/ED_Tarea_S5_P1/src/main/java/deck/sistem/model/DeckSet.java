package deck.sistem.model;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class DeckSet {

    private Set<Card> cards;

    public DeckSet() {
        this.cards = new HashSet<>(14);
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

    /**
     * Elimina y retorna la primera carta del mazo.
     * @return - Primera carta del mazo.
     */
    public Set<Card> getCards() {
        return cards;
    }

    public Card giveCard(){
        Card card = seeTop();
        this.cards.remove(card);
        return card;
    }

    /**
     * Baraja las cartas actuales del mazo.
     */
    public void shuffle(){
        //not needed, the deck is already shuffle and it's cannot unshuffle easily.
    }

    /**
     * Muestra la primera carta del mazo sin sacarla.
     * @return - Primera carta del mazo.
     */
    public Card seeTop(){
        Iterator<Card> it = cards.iterator();
        return it.next();
    }
}
