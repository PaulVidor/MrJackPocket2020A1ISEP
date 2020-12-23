import java.util.Arrays;
import java.util.Stack;
import java.util.Collections;
import java.util.ArrayList;
import static java.lang.Math.sqrt;


public class Main {
    public static void main(String[] args) {

        int enumSize = Alibi.values().length;
        int boardSideSize = (int) (enumSize / Math.sqrt(enumSize));

        Stack<Alibi> alibiCards = new Stack<>();
        District[][] board = new District[boardSideSize][boardSideSize];
        Detective[] detectives = new Detective[Detective.values().length];


        DeckGenerate(alibiCards);
        Alibi mrJackCharacter = MrJackCharacterGenerate(alibiCards);
        DistrictBoardGenerate(board, alibiCards, boardSideSize, mrJackCharacter);
        ListOfDetectives(detectives);

        //Bien tout générer avant de faire quoi que ce soit sur les decks / Board !!


        //TEST
        for (int i = 0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.println(board[i][j].getIsJack());
            }
        }
    }


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

    public static void ListOfDetectives (Detective[] tokens) {
        for (int i = 0; i<Detective.values().length; i++ ) {
            tokens[i] = Detective.values()[i];
        }
    }

    public static Alibi MrJackCharacterGenerate(Stack<Alibi> cards) {
        Alibi mrJackCharacter = cards.peek();
        Collections.shuffle(cards);
        return mrJackCharacter;
    }


    // VOIR SI C'EST OPTIMAL DE RECREER UNE LISTE DES CHARACTERES VISIBLES A CHAQUE FOIS

    //Fonction à appeler à la fin, quand le tour va se terminer

    public static void GetVisibleCharacter(int detectivePosition, District[][] board) {
        switch (detectivePosition) {
            case 0: case 1: case 2:
                for (int i = 0; i < 3; i++) {
                    if (board[i][detectivePosition].getOrientation() != Orientation.SOUTH) {
                        board[i][detectivePosition].isVisible();
                    }
                }
                break;

            case 6: case 7: case 8:
                int correspondColumn = (detectivePosition % 6 * -2) * (-1);
                for (int i = 0; i < 3; i++) {
                    if (board[i][correspondColumn].getOrientation() != Orientation.NORTH) {
                        board[i][correspondColumn].isVisible();
                    }
                }
                break;

            case 3: case 4: case 5:
                int correpsondRowRight = (detectivePosition%3-2)*(-1);
                for (int i = 0; i<3; i++) {
                    if (board[correpsondRowRight][i].getOrientation() != Orientation.WEST) {
                        board[correpsondRowRight][i].isVisible();
                    }
                }

            case 9: case 10: case 11:
                int correpsondRowLeft = (detectivePosition%9-2)*(-1);
                for (int i = 0; i<3; i++) {
                    if (board[correpsondRowLeft][i].getOrientation() != Orientation.EAST) {
                        board[correpsondRowLeft][i].isVisible();
                    }
                }

            default :
                System.out.println("il y a eu une erreur");
        }
    }
}