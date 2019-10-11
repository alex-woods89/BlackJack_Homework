import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand;

    public Player(){
        this.hand = new ArrayList<Card>();
    }

    public ArrayList getHand(){
        return this.hand;
    }

    public void addCardToHand(Card card){
        this.hand.add(card);
    }

    public int firstCardRankValueInHand(){
        Card firstCard = this.hand.get(0);
        return firstCard.getRank().getValue();
    }

    public int firstCardSuitValueinHand(){
        Card firstCard = this.hand.get(0);
        return firstCard.getSuit().getValue();
    }

}
