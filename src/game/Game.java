package game;

import model.Board;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private final Board board;
    public static Scanner scan = new Scanner(System.in);

    public Game() {
        board = new Board();
    }

    public void play() {
        System.out.println("\nLa partie commence !\n");
        System.out.println("Le personnage " + board.getMrJackCharacter() + " est Mr. Jack !\n");

        while (!board.isEndGame()) {
            System.out.println("\n------ Nous sommes au tour numero " + board.getTurnNumber() + " ------");
            board.gameToPrint();
            System.out.println();
            System.out.println("Le joueur " + (board.getInvestigatorStarts() ? "enqueteur" : "Mr. Jack") + " commence à jouer");
            board.chooseActions();
            board.gameToPrint();

            while (board.actionsAllUsed()) {
                System.out.println("\nC'est au tour de " + (board.investigatorPlays() ? "l'enqueteur" : "Mr. Jack") + " de choisir une action");
                board.chooseActions();
                board.gameToPrint();
            }
            board.endTurn();
        }
    }

    public static void main(String[] args) {
        int userMenuChoice = 0;
        while (userMenuChoice != 3) {
            try {
                System.out.println("------ Mr. Jack Pocket ------");
                System.out.println("Que souhaitez-vous faire ?");
                System.out.println("1. Lancer une nouvelle partie\n2. Règles\n3. Quitter");
                userMenuChoice = Game.scan.nextInt();
                switch (userMenuChoice) {
                    case 1:
                        System.out.println();
                        Game.scan.nextLine();
                        Game game = new Game();
                        game.play();
                        break;
                    case 2:
                        System.out.println("Voici un lien vers les règles :\n\n\n");
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("L'entree est invalide, veuillez reessayer\n\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("L'entree doit etre un entier\n");
                Game.scan.nextLine();
                System.out.println();
            }
        }
    }
}
