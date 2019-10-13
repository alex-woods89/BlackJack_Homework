import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    private Deck deck;
    private Card card;
    private Player player1;
    private Player player2;

    @Before
    public void before() {
        deck = new Deck();
        card = new Card(SuitType.DIAMONDS, RankType.FIVE);
        player1 = new Player();
        player2 = new Player();
    }

    @Test
    public void testDeckStartEmpty() {
        assertEquals(0, deck.getDeckOfCardsCount());
    }

    @Test
    public void canAddCard() {
        deck.addCardToDeck(card);
        assertEquals(1, deck.getDeckOfCardsCount());
    }

    @Test
    public void canGetArrayOfSuits() {
        assertEquals(4, deck.getSuitsArray());
    }

    @Test
    public void canPopulateDeckOfCards() {
        deck.createDeckOfCards();
        assertEquals(52, deck.getDeckOfCardsCount());
    }

    @Test
    public void canShuffleCards() {
        deck.createShuffledDeckOfCards();
        assertEquals(52, deck.getShuffledDeck().size());
    }

    @Test
    public void canDealCards() {
        deck.createShuffledDeckOfCards();
        deck.drawCardFromDeckToPlayer(player1);
        deck.drawCardFromDeckToPlayer(player1);
        deck.drawCardFromDeckToPlayer(player2);
        assertEquals(49, deck.getShuffledDeck().size());
        assertEquals(2, player1.getHand().size());
        assertEquals(1, player2.getHand().size());
    }
}
