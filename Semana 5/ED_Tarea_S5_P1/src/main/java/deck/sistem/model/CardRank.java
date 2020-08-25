package deck.sistem.model;

public enum CardRank {
    ACE("Ace",1),       //0
    TWO("Two",2),       //1
    THREE("Three",3),   //2
    FOUR("Four",4),     //3
    FIVE("Five",5),     //4
    SIX("Six",6),       //5
    SEVEN("Seven",7),   //6
    EIGHT("Eight", 8),  //7
    NINE("Nine", 9),    //8
    TEN("Ten", 10),     //9
    JACK("Jack", 11),   //10
    QUEEN("Queen", 12), //11
    KING("King", 13),   //12
    JOKER("Joker", 0);  //13

    private String rank;
    private int value;

    CardRank(String rank, int value) {
        this.rank = rank;
        this.value = value;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "rank= '" + rank + '\'' + " ("+value + ")";
    }
}
