import java.util.Stack;
import java.util.Collections;
import javax.swing.*;
import java.awt.*;

    /*
         0 1 2
     11  .|.|.  3
     10  .|.|.  4
      9  .|.|.  5
         8 7 6

     */

public class Main {
    public static void main(String[] args) {

        PrincipalWindow PrincipalWindow = new PrincipalWindow();

        /*
        int turnNumber = 0;
        boolean endGame = false;
        int enumSize = Alibi.values().length;
        int boardSideSize = (int) (enumSize / Math.sqrt(enumSize));
        String [] districtToPrint = {"╦","╩","╠","╣"};

        Stack<Alibi> alibiCards = new Stack<>();
        District[][] board = new District[boardSideSize][boardSideSize];
        Detective[] listOfDetectives = Detective.values();

        DeckGenerate(alibiCards);
        Alibi mrJackCharacter = MrJackCharacterGenerate(alibiCards);
        DistrictBoardGenerate(board, alibiCards, boardSideSize, mrJackCharacter);

        //Bien tout générer avant de faire quoi que ce soit sur les decks / Board !!

////////////////////////////////////////////////////////////////////////////////////////////////////////

        //TEST
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

        endTurn(board, listOfDetectives, endGame);
        System.out.println(endGame);
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////


    public static void DistrictBoardGenerate (District[][] boardCards, Stack<Alibi> cards, int size, Alibi mrJackCharacter) {
        for (int i = 0; i<size; i++) {
            for (int j = 0; j<size; j++) {
                Orientation randomOrientation = Orientation.values()[(int) (Math.random()*4)];
                boardCards[i][j] = new District(randomOrientation, cards.get(size*i+j));
                if (boardCards[i][j].getCharacter() == mrJackCharacter) {
                    boardCards[i][j].isJack();
                }
            }
        }
        cards.remove(mrJackCharacter);
    }

    public static void DeckGenerate (Stack cards) {
        Alibi[] values = Alibi.values();
        for (Alibi character : values) {
            cards.add(character);
        }
        Collections.shuffle(cards);
    }

    public static void AlibiDraw (Stack<Alibi> cards) {
        if (cards.empty()) {
            System.out.println("Il n'y a plus de cartes Alibi ! Choisissez une autre action");
        }
        else {
            System.out.println("L'alibi obtenu est : " + cards.pop().getName());
        }
    }

    public static Alibi MrJackCharacterGenerate(Stack<Alibi> cards) {
        Alibi mrJackCharacter = cards.peek();
        Collections.shuffle(cards);
        return mrJackCharacter;
    }

    //Fonction à appeler à la fin, quand le tour va se terminer

    public static void VisibleCharacter(int detectivePosition, District[][] board) {
        switch (detectivePosition) {
            case 0: case 1: case 2:
                for (int i = 0; i < 3; i++) {
                    if (board[i][detectivePosition].getOrientation() != Orientation.SOUTH) {
                        board[i][detectivePosition].isVerso();
                    }

                    else {
                        break;
                    }
                }
            break;

            case 6: case 7: case 8:
                int correspondColumn = (detectivePosition % 6 * -2) * (-1);
                for (int i = 0; i < 3; i++) {
                    if (board[i][correspondColumn].getOrientation() != Orientation.NORTH) {
                        board[i][correspondColumn].isVerso();
                    }

                    else {
                        break;
                    }
                }
            break;

            case 3: case 4: case 5:
                int correpsondRowRight = (detectivePosition%3);
                for (int i = 2; i>=0; i--) {
                    if (board[correpsondRowRight][i].getOrientation() != Orientation.WEST) {
                        board[correpsondRowRight][i].isVerso();
                    }

                    else {
                        break;
                    }
                }
            break;

            case 9: case 10: case 11:
                int correpsondRowLeft = (detectivePosition%9-2)*(-1);
                for (int i = 0; i<3; i++) {
                    if (board[correpsondRowLeft][i].getOrientation() != Orientation.EAST) {
                        board[correpsondRowLeft][i].isVerso();
                    }

                    else {
                        break;
                    }
                }
            break;


            default :
                System.out.println("il y a eu une erreur");
        }
    }

    public static boolean IsMrJackVisible(District[][] board, boolean endGame) {
        for (int i = 0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getIsJack() && !board[i][j].isRecto()) {
                    endGame = true;
                    break;
                }
            }
        }
        return endGame;
    }

    public static void endTurn(District[][] board, Detective[] detectives, boolean endGame) {
        for (int i = 0; i< detectives.length; i++) {
            VisibleCharacter(detectives[i].getPosition(), board);
        }
        IsMrJackVisible(board, endGame);


 */
    }


}