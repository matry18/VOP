package opg3_playingcards;

/**
 * VOP eksamen F2014 Tom klasse til opgave 3
 *
 * @author erso
 */
public class Card implements CardInterface {

    private int face;
    private int suit;

    public Card(int face, int suit)  {  

        if (face < ACE || face > KING || suit < CLUBS || suit > SPADES) {
            System.out.println("Ulovligt kort: " + suit + " " + face);
            return;
        }
        this.face = face;
        this.suit = suit;
    }
    public String toString() {
        String cardName = "";
        switch (suit) {
            case CLUBS:
                cardName += CLUBS_NAME;
                break;
            case DIAMONDS:
                cardName += DIAMONDS_NAME;
                break;
            case HEARTS:
                cardName += HEARTS_NAME;
                break;
            case SPADES:
                cardName += SPADES_NAME;
                break;
        }
        switch (face) {
            case ACE:
                cardName += ACE_NAME;
                break;
            case JACK:
                cardName += JACK_NAME;
                break;
            case QUEEN:
                cardName += QUEEN_NAME;
                break;
            case KING:
                cardName += KING_NAME;
                break;
        }
        return cardName;
    }
public static void main(String[] args) {
       
            System.out.println(new Card(1, 3));
            System.out.println(new Card(3, 1));
            System.out.println(new Card(13, 4));
            System.out.println(new Card(12, 3));
            System.out.println(new Card(17, 5));
            



    }
}
