public class Runner {

    public static void main(String[] args){
        Deck d = new Deck(true);
        d.shuffleDeck();
        d.dealHand(7);
        System.out.println("List Hand:");
        System.out.println();
        d.selectionSort();
        d.listHand();
        d.binSearchHand(1);
    }
}
