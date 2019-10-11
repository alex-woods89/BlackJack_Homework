import java.util.Scanner;

public class Game {

    private Deck deck;
    private Player player1;
    private Player player2;
    private Player dealer;

    public Game(){
        this.deck = new Deck();
        this.player1 = new Player();
        this.player2 = new Player();
        this.dealer = new Player();
    }

    public String compareCardsHiLow(){
        int player1CardRankValue = player1.firstCardRankValueInHand();
        int player2CardRankValue = player2.firstCardRankValueInHand();

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

    public String playTheGameHiLow(){
        this.deck.createShuffledDeckOfCards();
        this.deck.drawCardFromDeckToPlayer(player1);
        this.deck.drawCardFromDeckToPlayer(player2);
        return this.compareCardsHiLow();
    }

    public String compareCardsTwoCardHiLow() {
        int dealerHandValue = dealer.getHandValue();
        int player1HandValue = player1.getHandValue();
        int player2HandValue = player2.getHandValue();

        if ((dealerHandValue > player1HandValue) && (dealerHandValue > player2HandValue)) {
            return "Dealer wins";
        } else if ((player1HandValue > dealerHandValue) && (player1HandValue > player2HandValue)) {
            return "Player 1 wins";
        } else {
            return "Player 2 wins";
        }

    }

    public String PlayGameTwoCardHiLow(){
        this.deck.createShuffledDeckOfCards();
        this.deck.drawCardFromDeckToPlayer(player1);
        this.deck.drawCardFromDeckToPlayer(player2);
        this.deck.drawCardFromDeckToPlayer(dealer);
        this.deck.drawCardFromDeckToPlayer(player1);
        this.deck.drawCardFromDeckToPlayer(player2);
        this.deck.drawCardFromDeckToPlayer(dealer);
        return this.compareCardsTwoCardHiLow();
    }


    public int dealersTurn(){
        int handValue = dealer.getHandValue();
        if(handValue < 16){
            this.deck.drawCardFromDeckToPlayer(dealer);
        }
        return handValue;
    }

    public void blackJackDeal(){
        this.deck.drawCardFromDeckToPlayer(player1);
        this.deck.drawCardFromDeckToPlayer(dealer);
        this.deck.drawCardFromDeckToPlayer(player1);
        this.deck.drawCardFromDeckToPlayer(dealer);
    }

    public String playBlackJack(){
        this.blackJackDeal();
        this.dealersTurn();
        Scanner input = new Scanner(System.in);
        String choice = input.next();
        if(choice == "hit"){
            deck.drawCardFromDeckToPlayer(player1);
        } else if(player1.getHandValue() > dealer.getHandValue()){
            return "player1 wins";
        }
            return "dealer wins";

    }
    }



