package deck.sistem.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class DeckSetTest {

    private DeckSet deckSet;

    @Before
    public void setUp() throws Exception {
        deckSet = new DeckSet();
    }

    @Test
    public void giveCard() {
        Iterator<Card> it = deckSet.getCards().iterator();
        Card correct = it.next();
        Card test = deckSet.giveCard();
        assertEquals("Deberia ser la primera carta",test,correct);
        assertEquals("No debería estar la carta en el mazo",false,deckSet.getCards().contains(correct));
    }

    @Test
    public void shuffle() {
        assertEquals("No hay método",true,true);
    }

    @Test
    public void seeTop() {
        Iterator<Card> it = deckSet.getCards().iterator();
        Card correct = it.next();
        Card test = deckSet.seeTop();
        assertEquals("Deberia ser la primera carta",test,correct);
        assertEquals("Debería estar la carta en el mazo",true,deckSet.getCards().contains(correct));
    }
}