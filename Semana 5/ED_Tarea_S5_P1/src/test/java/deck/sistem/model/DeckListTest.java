package deck.sistem.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckListTest {

    private DeckList deckList;

    @Before
    public void setUp() throws Exception {
        deckList = new DeckList();
    }

    @Test
    public void giveCard() {
        Card correct = deckList.getCards().get(0);
        Card test = deckList.giveCard();
        assertEquals("Deberia ser la primera carta",test,correct);
        assertEquals("No debería estar la carta en el mazo",false,deckList.getCards().contains(correct));
    }

    @Test
    public void shuffle() {
        Card notShuffle1 = deckList.getCards().get(0);
        Card notShuffle2 = deckList.getCards().get(1);
        Card notShuffle3 = deckList.getCards().get(5);
        Card notShuffle4 = deckList.getCards().get(9);
        deckList.shuffle();
        Card shuffle1 = deckList.getCards().get(0);
        Card shuffle2 = deckList.getCards().get(1);
        Card shuffle3 = deckList.getCards().get(5);
        Card shuffle4 = deckList.getCards().get(9);
        assertEquals("(Solo si da error el 100% de los casos esta malo)", false, notShuffle1.equals(shuffle1));
        assertEquals("(Solo si da error el 100% de los casos esta malo)", false, notShuffle2.equals(shuffle2));
        assertEquals("(Solo si da error el 100% de los casos esta malo)", false, notShuffle3.equals(shuffle3));
        assertEquals("(Solo si da error el 100% de los casos esta malo)", false, notShuffle4.equals(shuffle4));
    }

    @Test
    public void seeTop() {
        Card correct = deckList.getCards().get(0);
        Card test = deckList.seeTop();
        assertEquals("Deberia ser la primera carta",test,correct);
        assertEquals("Debería estar la carta en el mazo",true,deckList.getCards().contains(correct));

    }
}