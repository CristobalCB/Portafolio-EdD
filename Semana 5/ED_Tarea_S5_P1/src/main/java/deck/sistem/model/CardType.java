package deck.sistem.model;

public enum CardType {
    CLUB("Club","Black"),       //0
    SPADE("Spade","Black"),     //1
    HEART("Heart","Red"),       //2
    DIAMOND("Diamond","Red"),   //3
    REDJOKER("Joker","Red"),    //4
    BLACKJOKER("Joker","Black");//5

    private String type;
    private String coulor;

    CardType(String type, String coulor){
        this.type = type;
        this.coulor = coulor;
    }

    public String getType() {
        return type;
    }

    public String getCoulor() {
        return coulor;
    }

    @Override
    public String toString() {
        return "type= '" + type + '\'' +
                " (" + coulor + ')';
    }
}
