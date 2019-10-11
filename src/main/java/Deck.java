import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deckOfCards;
    private ArrayList<Card> shuffledDeck;

    public Deck(){
        this.deckOfCards = new ArrayList<Card>();
        this.shuffledDeck = new ArrayList<Card>();
    }

    public int getDeckOfCardsCount(){
        return this.deckOfCards.size();
    }

    public void addCardToDeck(Card card){
        this.deckOfCards.add(card);
    }

    public int getSuitsArray(){
        SuitType[] suits = SuitType.values();
        return suits.length;
    }

    public ArrayList createDeckOfCards(){
        SuitType[] suits = SuitType.values();
        RankType[] ranks = RankType.values();

        for (SuitType suit : suits){
            for (RankType rank : ranks){
                Card card = new Card(suit,rank);
                this.addCardToDeck(card);
            }
        }
        return this.deckOfCards;
    }

    public void createShuffledDeckOfCards(){
       this.shuffledDeck = this.createDeckOfCards();
       Collections.shuffle(shuffledDeck);
    }

    public void drawCardFromDeckToPlayer(Player player){
        Card removedCard = this.shuffledDeck.remove(0);
        player.addCardToHand(removedCard);
    }

    public ArrayList getShuffledDeck() {
        return this.shuffledDeck;
    }
}
