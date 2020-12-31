import java.sql.SQLOutput;
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
        
        while(!board.isEndGame()) {
            System.out.println("------ Nous sommes au tour numero : " + board.getTurnNumber() + " ------");
            board.gameToPrint();
            System.out.println();

            System.out.println("Le joueur " + (board.getInvestigatorStarts() ? "enqueteur" : "Mr. Jack") + " commence à jouer");
            int userChoice = Game.scan.nextInt();
            board.chooseActions(userChoice);

            while(!board.actionsAllUsed()) {
                board.gameToPrint();

                // TEST
                for (int i=0; i<3; i++) {
                    System.out.print(Detective.values()[i].getName() + " : " + Detective.values()[i].getPosition() + " ");
                }

                //


                System.out.println("\nC'est au tour de " + (board.investigatorPlays() ? "l'enqueteur" : "Mr. Jack") + " de choisir une action");
                userChoice = Game.scan.nextInt();
                board.chooseActions(userChoice);
            }
            board.endTurn();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////

        //TEST

        /*
        for (int i = 0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.println(board[i][j].getOrientation());
            }
        }

        for (int i = 0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(board[i][j].toString(districtToPrint, board[i][j].getOrientation())+" ");
            }
            System.out.println();
        }

        for (int i = 0; i<3; i++) {
            System.out.println(listOfDetectives[i].getPosition());
        }

        Board.MoveDetective(listOfDetectives, 1, 2);

        for (int i = 0; i<3; i++) {
            System.out.println(listOfDetectives[i].getPosition());
        }

        EndTurn(board, listOfDetectives, endGame);
        System.out.println(endGame);
    }

    */


    ////////////////////////////////////////////////////////////////////////////////////////////////////

}