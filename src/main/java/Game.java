public class Game {

    private Deck deck;
    private Player player1;
    private Player player2;

    public Game(){
        this.deck = new Deck();
        this.player1 = new Player();
        this.player2 = new Player();
    }

    public String compareCards(){
        int player1CardRankValue = this.player1.firstCardRankValueInHand();
        int player2CardRankValue = this.player2.firstCardRankValueInHand();

        int player1CardSuitValue = this.player1.firstCardSuitValueinHand();
        int player2CardSuitValue = this.player2.firstCardSuitValueinHand();

        if(player1CardRankValue > player2CardRankValue){
            return  "Player 1 is The WINNER";
        } else if (player2CardRankValue > player1CardRankValue){
            return "Player 2 is The WINNER";
        } else {
                if(player1CardSuitValue > player2CardSuitValue){
                    return  "Player 1 is The WINNER";
                }
                return  "Player 2 is The WINNER";
        }
    }

    public String playTheGame(){
        this.deck.createShuffledDeckOfCards();
        this.deck.drawCadFromDeckToPlayer(player1);
        this.deck.drawCadFromDeckToPlayer(player2);
        return this.compareCards();
    }


}
