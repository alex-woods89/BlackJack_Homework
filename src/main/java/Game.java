import java.util.Scanner;

public class Game {

    private Deck deck;
    private Player player1;
    private Player player2;
    private Player dealer;

    public Game() {
        this.deck = new Deck();
        this.player1 = new Player();
        this.player2 = new Player();
        this.dealer = new Player();
    }

    public String compareCardsHiLow() {
        int player1CardRankValue = player1.firstCardRankValueInHand();
        int player2CardRankValue = player2.firstCardRankValueInHand();

        int player1CardSuitValue = this.player1.firstCardSuitValueinHand();
        int player2CardSuitValue = this.player2.firstCardSuitValueinHand();

        if (player1CardRankValue > player2CardRankValue) {
            return "Player 1 is The WINNER";
        } else if (player2CardRankValue > player1CardRankValue) {
            return "Player 2 is The WINNER";
        } else {
            if (player1CardSuitValue > player2CardSuitValue) {
                return "Player 1 is The WINNER";
            }
            return "Player 2 is The WINNER";
        }
    }

    public String playTheGameHiLow() {
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

    public String PlayGameTwoCardHiLow() {
        this.deck.createShuffledDeckOfCards();
        this.deck.drawCardFromDeckToPlayer(player1);
        this.deck.drawCardFromDeckToPlayer(player2);
        this.deck.drawCardFromDeckToPlayer(dealer);
        this.deck.drawCardFromDeckToPlayer(player1);
        this.deck.drawCardFromDeckToPlayer(player2);
        this.deck.drawCardFromDeckToPlayer(dealer);
        return this.compareCardsTwoCardHiLow();
    }


    public int dealersTurn() {
        int dealerHandValue = dealer.getHandValue();
        if (dealerHandValue <= 16) {
            this.deck.drawCardFromDeckToPlayer(dealer);
            this.dealersTurn();
        }
        return dealerHandValue;
    }

    public void blackJackDeal() {
        this.deck.createShuffledDeckOfCards();
        this.deck.drawCardFromDeckToPlayer(player1);
        this.deck.drawCardFromDeckToPlayer(dealer);
        this.deck.drawCardFromDeckToPlayer(player1);
        this.deck.drawCardFromDeckToPlayer(dealer);
    }

    public void playBlackJack() {
        // deal cards to player and dealer
        this.blackJackDeal();
        // player takes turn draws cards
        this.playersTurn();
        //dealer takes turn and draws cards
        this.dealersTurn();
        //decide on a winner
         this.decideBlackJackWinner();
    }

    private void decideBlackJackWinner() {
        int dealerHandValue = dealersTurn();
        int newHandValue = this.playersTurn();
        if(dealerHandValue > 21){
            System.out.println("Dealer is bust on " + dealerHandValue);
        } else if (newHandValue > 21){
            System.out.println("Player is bust on " + newHandValue);
        }
        else {
            if (dealerHandValue > newHandValue) {
             System.out.println("Dealer Wins");
             System.out.print("Dealer scored " + dealerHandValue + " Player scored " + newHandValue);
        } else {
        System.out.println("Player Wins");
        System.out.print("Dealer scored " + dealerHandValue + " Player scored " + newHandValue);
        }
        }
    }



    public int playersTurn() {
        int playersHand = player1.getHandValue();
        Scanner input = new Scanner(System.in);
        System.out.println("Your current hand is " + playersHand);
        System.out.print("Enter 1 if hit or 0 if stick: ");
        int choice = input.nextInt();
        if (choice == 1) {
            deck.drawCardFromDeckToPlayer(player1);
            playersHand += player1.getHandValue();
        }
        return playersHand;

    }
}





