import java.util.Collections;
import java.util.Stack;

public class Board {

    /*

         0 1 2
     11  .|.|.  3       1|2|3
     10  .|.|.  4       4|5|6
      9  .|.|.  5       7|8|9
         8 7 6

    */

    private Stack<Alibi> alibiCards;
    private District[][] board;
    private Detective[] listOfDetectives;
    private ActionToken[] listOfTokens;
    private String[] districtToPrint;
    private int turnNumber;
    private Alibi mrJackCharacter;
    private boolean endGame;
    private boolean investigatorStarts;
    private boolean investigatorHasHand;
    private boolean endActions;
    private int numberOfActionsUsed;

    public Board() {
        this.generate();
    }

    public void generate() {
        alibiCards = new Stack();
        board = new District[3][3];
        listOfDetectives = Detective.values();
        listOfTokens = ActionToken.values();
        districtToPrint = new String[] {"╦","╣","╩","╠"};
        turnNumber = 1;
        numberOfActionsUsed = 0;
        investigatorStarts = true;

        deckGenerate();
        mrJackCharacterGenerate();
        districtBoardGenerate();
        shuffleTokens();
    }

    // Fonctions d'initialisation

    public void deckGenerate() {
        Alibi[] values = Alibi.values();
        for (Alibi character : values) {
            alibiCards.add(character);
        }
        Collections.shuffle(alibiCards);
    }

    public void mrJackCharacterGenerate() {
        mrJackCharacter = alibiCards.peek();
        Collections.shuffle(alibiCards);
    }

    public void districtBoardGenerate() {
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                Orientation randomOrientation = Orientation.values()[(int) (Math.random()*4)];
                board[i][j] = new District(randomOrientation, alibiCards.get(3*i+j));
                if (board[i][j].getCharacter() == mrJackCharacter) {
                    board[i][j].isJack();
                }
            }
        }
        alibiCards.remove(mrJackCharacter);
    }

    public boolean actionsAllUsed() {
        endActions = true;
        for (int i = 0; i<4; i++) {
            if (!ActionToken.values()[i].isHasBeenUsed()){
                endActions = false;
            }
        }
        return endActions;
    }

    // Fonctions actions

    public void shuffleTokens() {
        for (int i = 0; i<4; i++) {
            listOfTokens[i].setHasBeenUsed(false);
            if ((int) Math.random()*2 < 0.5) {
                listOfTokens[i].setHead(false);
            }
        }
    }

    public void alibiDraw() {
        if (alibiCards.empty()) {
            System.out.println("Il n'y a plus de cartes Alibi !");
        }
        else {
            System.out.println("L'alibi obtenu est : " + alibiCards.pop().getName());
        }
    }

    public void moveDetective(Detective detective) {
        System.out.println("De combien ce cases souhaitez-vous le faire avancer ?");
        int distance = Game.scan.nextInt();
        detective.setPosition((detective.getPosition()+distance)%12);
    }

    public void moveDetectivesTogether() {
        System.out.println("Voulez-vous deplacer les 3 detectives (1) ou les laisser en place (0) ?");
        int distance = Game.scan.nextInt();
        if (distance == 1) {
            for (int i = 0; i<3; i++) {
                listOfDetectives[i].setPosition((listOfDetectives[i].getPosition()+distance)%12);
            }
        }
    }

    public void rotate() {
        System.out.println("Quel quartier voulez-vous tourner ? Entrez un numero de 1 à 9, en suivant la correspondance");
        int districtPosition = Game.scan.nextInt();
        System.out.println("De combien de quarts de tour voulez-vous le faire tourner (sens horaire) ?");
        int times = Game.scan.nextInt();

        int positionRow = (districtPosition-1)/3;
        int positionColumn = (districtPosition-1)%3;
        District district = board[positionRow][positionColumn];
        district.setOrientation(Orientation.values()[(district.getOrientation().ordinal()+times)%4]);
    }

    public void swapDistricts () {

        /*
        1|2|3
        4|5|6
        7|8|9
        */

        System.out.println("Quel quartier voulez-vous deplacer ?");
        int positionDistrict1 = Game.scan.nextInt();
        System.out.println("Avec quel quartier voulez-vous l'echanger ?");
        int positionDistrict2 = Game.scan.nextInt();
        District swapDistrict;

        int positionRow1 = (positionDistrict1 -1)/3;
        int positionColumn1 = (positionDistrict1 -1)%3;
        int positionRow2 = (positionDistrict2 -1)/3;
        int positionColumn2 = (positionDistrict2 -1)%3;

        swapDistrict = board[positionRow2][positionColumn2];
        board[positionRow2][positionColumn2] = board[positionRow1][positionColumn1];
        board[positionRow1][positionColumn1] = swapDistrict;
    }

    public void chooseActions(int userChoice) {
        switch (userChoice-1) {
            case 0:
                if (!listOfTokens[0].isHasBeenUsed()) {
                    if (listOfTokens[0].isHead()) {
                        alibiDraw();
                    } else {
                        moveDetective(listOfDetectives[1]);
                    }
                    listOfTokens[0].setHasBeenUsed(true);
                    numberOfActionsUsed++;
                }
                else {
                    System.out.println("Cette action a deja ete utilisee, choisissez en une autre ");
                }
                break;

            case 1:
                if (!listOfTokens[1].isHasBeenUsed()) {
                    if (listOfTokens[1].isHead()) {
                        moveDetective(listOfDetectives[2]);
                    } else {
                        moveDetective(listOfDetectives[0]);
                    }
                    listOfTokens[1].setHasBeenUsed(true);
                    numberOfActionsUsed++;
                }
                else {
                    System.out.println("Cette action a deja ete utilisee, choisissez en une autre ");
                }
                break;

            case 2:
                if (!listOfTokens[2].isHasBeenUsed()) {
                    if (listOfTokens[2].isHead()) {
                        rotate();
                    } else {
                        swapDistricts();
                    }
                    listOfTokens[2].setHasBeenUsed(true);
                    numberOfActionsUsed++;
                }
                else {
                    System.out.println("Cette action a deja ete utilisee, choisissez en une autre ");
                }
                break;

            case 3:
                if (!listOfTokens[3].isHasBeenUsed()) {
                    if (listOfTokens[3].isHead()) {
                        rotate();
                    }
                    else {
                        moveDetectivesTogether();
                    }
                    listOfTokens[3].setHasBeenUsed(true);
                    numberOfActionsUsed++;
                }
                else {
                    System.out.println("Cette action a deja ete utilisee, choisissez en une autre ");
                }
                break;

            default:
                System.out.println("Il y a eu une erreur, veuillez ressaisir votre demande\n");
        }
    }

    // Vision des detectives

    //Fonction à appeler à la fin, quand le tour va se terminer
    //Voir si on peut faire en sorte de savoir qui a vu mr. Jack

    public void visibleCharacters() {
        int detectivePosition;
        for (int k=0; k<3; k++) {
            detectivePosition = listOfDetectives[k].getPosition();
            switch (detectivePosition) {
                case 0:
                case 1:
                case 2:
                    for (int i = 0; i < 3; i++) {
                        if (board[i][detectivePosition].getOrientation() != Orientation.SOUTH) {
                            board[i][detectivePosition].isVerso();
                        } else {
                            break;
                        }
                    }
                    break;

                case 6:
                case 7:
                case 8:
                    int correspondColumn = (detectivePosition % 6 - 2) * (-1);
                    for (int i = 0; i < 3; i++) {
                        if (board[i][correspondColumn].getOrientation() != Orientation.NORTH) {
                            board[i][correspondColumn].isVerso();
                        } else {
                            break;
                        }
                    }
                    break;

                case 3:
                case 4:
                case 5:
                    int correspondRowRight = (detectivePosition % 3);
                    for (int i = 2; i >= 0; i--) {
                        if (board[correspondRowRight][i].getOrientation() != Orientation.WEST) {
                            board[correspondRowRight][i].isVerso();
                        } else {
                            break;
                        }
                    }
                    break;

                case 9:
                case 10:
                case 11:
                    int correspondRowLeft = (detectivePosition % 9 - 2) * (-1);
                    for (int i = 0; i < 3; i++) {
                        if (board[correspondRowLeft][i].getOrientation() != Orientation.EAST) {
                            board[correspondRowLeft][i].isVerso();
                        } else {
                            break;
                        }
                    }
                    break;

                default:
                    System.out.println("il y a eu une erreur");
            }
        }
    }

    public boolean isMrJackCaught() {
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

    // Fin de tour

    public void endTurn() {
        for (int i = 0; i<listOfDetectives.length; i++) {
            visibleCharacters();
        }
        isMrJackCaught();
        turnNumber++;
        numberOfActionsUsed=0;
        changeHand();
        shuffleTokens();
    }

    public boolean isEndGame() {
        return endGame;
    }

    public void changeHand() {
        if(turnNumber % 2 == 0) {
            investigatorStarts = false;
        }
        else {
            investigatorStarts = true;
        }
    }

    public boolean investigatorPlays() {
        if (investigatorStarts && numberOfActionsUsed == 3) {
            investigatorHasHand = investigatorStarts;
        }

        else {
            investigatorHasHand = false;
        }

        return investigatorHasHand;
    }

    public boolean getInvestigatorStarts() {
        return investigatorStarts;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void gameToPrint() {
        System.out.println("\nVoici le plateau de jeu : ");
        for (int i = 0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(board[i][j].toString(districtToPrint, board[i][j].getOrientation()) + "("
                + board[i][j].getCharacter().toString().charAt(0) + board[i][j].getCharacter().toString().charAt(1) + ") ");
            }
            System.out.println();
        }
        System.out.println("\nLes actions disponibles sont les suivantes : ");
        for (int i = 0; i<4; i++ ) {
            if (!listOfTokens[i].isHasBeenUsed()) {
                System.out.println(listOfTokens[i] + " (Tapez " + (i+1) + ") ");
            }
        }
    }

    public String getMrJackCharacter() {
        return mrJackCharacter.getName() + " (" + mrJackCharacter.toString().charAt(0)
        + mrJackCharacter.toString().charAt(1) + ")";
    }

    //TEST

    public boolean isInvestigatorHasHand() {
        return investigatorHasHand;
    }

    public int getNumberOfActionsUsed() {
        return numberOfActionsUsed;
    }
}
