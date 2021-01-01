import java.util.Scanner;

public class Game {

    /*

         0 1 2
     11  .|.|.  3       1|2|3
     10  .|.|.  4       4|5|6
      9  .|.|.  5       7|8|9
         8 7 6

     */

    private final Board board;
    public static final Scanner scan = new Scanner(System.in);

    public Game() {
        board = new Board();
    }

    public void play() {
        System.out.println("La partie commence !\n");
        System.out.println("Le personnage " + board.getMrJackCharacter() + " est Mr. Jack !\n");

        // TEST

        while(!board.isEndGame()) {
            System.out.println("\n------ Nous sommes au tour numero " + board.getTurnNumber() + " ------");
            board.gameToPrint();
            System.out.println();

            System.out.println("Le joueur " + (board.getInvestigatorStarts() ? "enqueteur" : "Mr. Jack") + " commence à jouer");
            int userChoice = Game.scan.nextInt();
            board.chooseActions(userChoice);
            board.gameToPrint();

            while(!board.actionsAllUsed()) {
                System.out.println("\nC'est au tour de " + (board.investigatorPlays() ? "l'enqueteur" : "Mr. Jack") + " de choisir une action");
                userChoice = Game.scan.nextInt();
                board.chooseActions(userChoice);
                board.gameToPrint();
            }
            board.endTurn();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}