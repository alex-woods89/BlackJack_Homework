import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private Card card1;

    @Before
    public void before(){
        card1 = new Card(SuitType.SPADES, RankType.ACE);
    }

    @Test
    public void testCardcanGetRankAndSuit(){
        assertEquals(SuitType.SPADES, card1.getSuit());
        assertEquals(RankType.ACE, card1.getRank());
    }
}
