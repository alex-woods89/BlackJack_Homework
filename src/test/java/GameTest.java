import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Deck deck;
    private Player dealer;

    @Before
    public void before(){
        deck = new Deck();
        deck.createDeckOfCards();
//       we want to pass the deck without shuffling to the game
        game = new Game();
        dealer = new Player();
    }

    //@Test
    public void canPlayTheGames(){
        assertEquals("Player 1 is The WINNER",game.playTheGameHiLow());
    }

    //@Test
    public void canPlayGameTwoCardHiLow(){
        assertEquals("Dealer wins", game.PlayGameTwoCardHiLow());
    }

    //@Test
    public void dealersTurnWorks(){
        deck.createShuffledDeckOfCards();
        deck.drawCardFromDeckToPlayer(dealer);
        deck.drawCardFromDeckToPlayer(dealer);
        game.dealersTurn();
        assertEquals(21, dealer.getHandValue());
    }
}


