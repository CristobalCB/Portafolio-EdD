package deck.sistem.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckQueueTest {

    DeckQueue deckQueue;

    @Before
    public void setUp() throws Exception {
        deckQueue = new DeckQueue();
    }

    @Test
    public void giveCard() {
        Card correct = deckQueue.getCards().peek();
        Card test = deckQueue.giveCard();
        assertEquals("Deberia ser la primera carta",test,correct);
        assertEquals("No debería estar la carta en el mazo",false,deckQueue.getCards().contains(correct));
    }

    @Test
    public void shuffle() {
        Card notShuffle = deckQueue.getCards().peek();
        deckQueue.shuffle();
        Card shuffle = deckQueue.getCards().peek();
        assertEquals("(Solo si da error el 100% de los casos esta malo)", false, notShuffle.equals(shuffle));
    }

    @Test
    public void seeTop() {
        Card correct = deckQueue.getCards().peek();
        Card test = deckQueue.seeTop();
        assertEquals("Deberia ser la primera carta",test,correct);
        assertEquals("Debería estar la carta en el mazo",true,deckQueue.getCards().contains(correct));
    }
}