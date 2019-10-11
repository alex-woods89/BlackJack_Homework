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

    public int secondCardRankValueInHand(){
        Card secondCard = this.hand.get(1);
        return secondCard.getRank().getValue();
    }

    public int firstCardSuitValueinHand(){
        Card firstCard = this.hand.get(0);
        return firstCard.getSuit().getValue();
    }

    public int secondCardSuitValueInHand(){
        Card secondCard = this.hand.get(1);
        return secondCard.getSuit().getValue();
    }

    public int getHandValue(){
        int handValue = 0;
        for (Card card : hand) {
           int cardValue = card.getRank().getValue();
           handValue += cardValue;
        }
        return handValue;
            }

}
