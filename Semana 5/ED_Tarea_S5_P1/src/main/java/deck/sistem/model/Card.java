package deck.sistem.model;

public class Card {

    private final CardType type;
    private final CardRank rank;

    public Card(CardType type, CardRank rank) {
        this.type = type;
        this.rank = rank;
    }

    public CardType getType() {
        return type;
    }

    public CardRank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "|" + type + ", " + rank + "|";
    }
}
