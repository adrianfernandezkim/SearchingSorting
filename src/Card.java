public class Card {
    private String suit; // hearts, spades, diamonds, clubs
    private int value; // 1 to 13... 11 = jack, 12 = queen, 13 = king
    private String name;


    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
       if(value>10 || value==1){
            this.name = faceCards()+" of "+suit;
        }
        else {
            this.name = Integer.toString(value) + " of " + suit;
        }
    }


    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;

    }
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public  void setValue(int value) {
        this.value = value;

    }

    public String getName(){
        return name;
    }
    public String faceCards(){
        if(value == 1){
            return "Ace";
        }
        if(value == 11){
            return "Jack";
        }
        if(value == 12){
            return "Queen";
        }
        if(value == 13){
            return "King";
        }
        return "";
    }
}
