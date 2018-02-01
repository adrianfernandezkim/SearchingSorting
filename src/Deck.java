import java.util.Collections;
import java.util.Arrays;
import java.util.Random;


public class Deck {
    public static Card[] allCards = new Card[52];
    public static Card[] hand = new Card[7];
    int deckSize;
    public Deck(boolean numOfCards){
        if(numOfCards){
            this.deckSize = 52;
            //creates 52
            for(int i = 0; i<52; i++){

                    if(i<13){

                            allCards[i] = new Card("Spades", i+1);
                    }
                    if(13<=i&&i<26){
                            allCards[i] = new Card("Diamonds", i-13+1);
                    }
                    if(26<=i&&i<39){
                            allCards[i] = new Card("Clubs", i-26+1);
                    }
                    if(39<=i){
                            allCards[i] = new Card("Hearts", i-39+1);
                    }
            }

        }

        if(!numOfCards){
            this.deckSize = 13;
            //creates 13
            Random rand = new Random();
            int n = rand.nextInt(4)+1;
            switch(n){
                case 1:
                    for(int i = 0; i<13; i++){
                        allCards[i] = new Card("Spades", i+1);
                    }
                case 2:
                    for(int i = 0; i<13; i++){
                        allCards[i] = new Card("Diamonds", i+1);
                    }
                case 3:
                    for(int i = 0; i<13; i++){
                        allCards[i] = new Card("Clubs", i+1);
                    }
                case 4:
                    for(int i = 0; i<13; i++){
                        allCards[i] = new Card("Hearts", i+1);
                    }
            }




        }
    }
    public void swap(int first, int second){
        Card a = hand[first];
        Card b = hand[second];
        hand[first] = b;
        hand[second] = a;
    }
    public void dealHand(int numCards){
        for(int i = 0;i<numCards; i++){
            hand[i] = allCards[i];
        }
    }
    public void listHand(){
        for(int i = 0; i<hand.length; i++){
            System.out.println(hand[i].getName());
        }
    }
    public void shuffleDeck(){
        Collections.shuffle(Arrays.asList(allCards));
    }

    public void bubbleSort(){
        for(int j = 0; j<hand.length; j++) {
            for (int i = 0; i < hand.length - j; i++) {
                if (hand[i].getValue() > hand[i + 1].getValue()) {
                    swap(i, i + 1);
                }
            }
        }



    }
    public void selectionSort(){
        int lowestInd = 0;
        for(int i = 0;i<hand.length; i++) {
            lowestInd = i;
            for (int j = i + 1; j < hand.length ; j++) {
                if (hand[j].getValue() < hand[lowestInd].getValue()) {
                    lowestInd = j;
                }
            }
            swap(i,lowestInd);
        }
    }


   public void mergeSortHand() {
        mergeSort(hand);
    }
    public void mergeSort(Card[] array){
        if (array.length > 2) {
            Card[] left = leftHalf(array);
            Card[] right = rightHalf(array);
            mergeSort(leftHalf(array));
            mergeSort(right);
            merge(array, left, right);
        }
    }
    public static Card[] leftHalf(Card[] array) {
        int size = array.length / 2;
        Card[] left = new Card[size];
        for (int i = 0; i < size; i++) {
            left[i] = array[i];
        }
        return left;
    }
    public static Card[] rightHalf(Card[] array) {
        int size = array.length / 2;
        int sizeB = array.length - size;
        Card[] right = new Card[sizeB];
        for (int i = 0; i <= sizeB - 1; i++) {
            right[i] = array[i - 1 + sizeB];
        }
        return right;

    }
    public static void merge(Card[] result, Card[] left, Card[] right) {
        int indexLeft = 0;
        int indexRight = 0;
        for (int i = 0; i < result.length; i++) {
            if (indexRight >= right.length || (indexLeft < left.length && left[indexLeft].getValue() <= right[indexRight].getValue())) {
                result[i] = left[indexLeft];
                indexLeft++;
            } else {
                result[i] = right[indexRight];
                indexRight++;
            }
        }
    }


    public void binSearchHand(int x){
        Card[] arr = new Card[hand.length];
        for(int i = 0; i<hand.length; i++){
            arr[i] = hand[i];
        }
        binarySearch(x, arr, 0, arr.length);
    }
    public int binarySearch(int x, Card[] arr, int low, int high){
        int middle = (high - low)/2 ;

        if(high-low  < 2 && arr[high - low].getValue()!=x){
            System.out.println("not found");
            return -1;
        }
        else if(arr[middle].getValue() == x){
            System.out.println("found at index:" + middle);
            return middle;
        }
        else {
            if (arr[middle].getValue() > x) {
                high = middle - 1;
                binarySearch(x, arr, low, high);
            }
            if(arr[middle].getValue()<x){
                low = middle + 1;
                binarySearch(x, arr, low, high);
            }
        }
        return -1;
    }
}
