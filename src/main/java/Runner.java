import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


//        TwoCard Hi Low
//        System.out.print("Enter 1 if hit or 0 if stick: ");
//        int choice = input.nextInt();
//        if(choice == 1){
//         Game game = new Game();
//            System.out.println(game.playTheGameHiLow());}
//        else {
//            System.out.println("You entered no" + choice);
//        }
//

//        BlackJack
        Game blackJack = new Game();
        blackJack.playBlackJack();



    }
}
