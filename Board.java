package com.thipasa.mrjack.model;

import com.thipasa.mrjack.game.Game;
import com.thipasa.mrjack.players.Detective;
import com.thipasa.mrjack.players.InvestigatorPlayer;
import com.thipasa.mrjack.players.MrJackPlayer;

import java.util.ArrayList;
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
    private boolean endGame;
    private boolean investigatorStarts;
    private boolean endActions;
    private int numberOfActionsUsed;
    private Alibi mrJackCharacter;
    private District mrJackDistrict;
    private int numberOfDistrictVerso;
    private InvestigatorPlayer investigatorPlayer;
    private MrJackPlayer mrJackPlayer;

    public Board() {
        this.generate();
    }

    public void generate() {
        alibiCards = new Stack();
        board = new District[3][3];
        listOfDetectives = Detective.values();
        listOfTokens = ActionToken.values();
        districtToPrint = new String[] {"╦","╣","╩","╠","╬"};
        turnNumber = 1;
        numberOfActionsUsed = 0;
        numberOfDistrictVerso = 0;
        investigatorStarts = true;

        deckGenerate();
        mrJackCharacterGenerate();
        playersGenerate();
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

    public void playersGenerate() {
        System.out.println("Quel est le nom du joueur enqueteur ?");
        String userName = Game.scan.nextLine();
        investigatorPlayer = new InvestigatorPlayer(new ArrayList(), 0, userName);
        System.out.println("Quel est le nom du joueur MrJack ?");
        userName = Game.scan.nextLine();
        mrJackPlayer = new MrJackPlayer(new ArrayList(), 0, userName, mrJackCharacter);
    }

    int Po = 0;

    public void districtBoardGenerate() {
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                Orientation randomOrientation = Orientation.values()[(int) (Math.random()*4)];
                board[i][j] = new District(randomOrientation, alibiCards.get(3*i+j));
                if (board[i][j].getCharacter() == mrJackCharacter) {
                    mrJackDistrict = board[i][j];


                }
                if (board[i][j].getCharacter() == Alibi.BROWN) {
                    board[i][j].isCross();
                }
            }
        }
        board[0][0].setOrientation(Orientation.WEST);
        board[0][2].setOrientation(Orientation.EAST);
        board[2][1].setOrientation(Orientation.SOUTH);
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
        for (int i = 0; i < 4; i++) {
            listOfTokens[i].setHasBeenUsed(false);
        }
        for (int j = 0; j < 4; j++) {
            if (investigatorStarts) {
                if ((int) (Math.random() * 2) < 0.5) {
                    listOfTokens[j].setHead(false);
                }
            }
            else {
                listOfTokens[j].setHead(!listOfTokens[j].isHead());
            }
        }
    }

    public void alibiDraw() {
        Alibi alibiCardDrawed;
        alibiCardDrawed = alibiCards.pop();
        System.out.println("L'alibi obtenu est : " + alibiCardDrawed.getName());
        System.out.println(investigatorPlays());
        if (investigatorPlays()) {
            investigatorPlayer.addToAlibiCards(alibiCardDrawed);
            investigatorPlayer.addToCountHourglass(alibiCardDrawed.getHourglass());
            for (int i = 0; i<3; i++) {
                for (int j = 0; j<3; j++) {
                    if (board[i][j].getCharacter() == alibiCardDrawed) {
                        board[i][j].setVerso();
                    }
                }
            }
        }
        else {
            mrJackPlayer.addToAlibiCards(alibiCardDrawed);
            mrJackPlayer.addToCountHourglass(alibiCardDrawed.getHourglass());
        }
    }

    public void moveDetective(Detective detective) {
        System.out.println("De combien ce cases souhaitez-vous le faire avancer (1 ou 2) ?");
        int distance = Game.scan.nextInt();
        if (distance == 1 || distance == 2) {
            detective.setPosition((detective.getPosition() + distance) % 12);
        }
        else {
            System.out.println("La demande n'est pas valide, veuillez reessayer");
            moveDetective(detective);
        }
    }

    public void moveDetectivesTogether() {
        //JEN SUIS A LA
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Choisissez un detective");
        int userChoice = Game.scan.nextInt();
        if (userChoice == 1) {
            for (int i = 0; i<3; i++) {
                listOfDetectives[i].setPosition((listOfDetectives[i].getPosition()+ userChoice)%12);
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

        if (district.isHasBeenRotate()) {
            System.out.println("Ce quartier a deja ete tourne, choisissez en un autre\n");
            rotate();
        }
        else {
            district.setOrientation(Orientation.values()[(district.getOrientation().ordinal()+times)%4]);
            district.setHasBeenRotate();
        }
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
        for (int j=0; j<3; j++) {
            detectivePosition = listOfDetectives[j].getPosition();
            switch (detectivePosition) {
                case 0:
                case 1:
                case 2:
                    for (int i = 0; i < 3; i++) {
                        if (board[i][detectivePosition].getOrientation() != Orientation.NORTH) {
                            board[i][detectivePosition].setInSight(true);
                            if (board[i][detectivePosition].getOrientation() == Orientation.SOUTH) {
                                break;
                            }
                        }
                        else {
                            break;
                        }
                    }
                    break;

                case 6:
                case 7:
                case 8:
                    int correspondColumn = (detectivePosition % 6 - 2) * (-1);
                    for (int i = 2; i >= 0; i--) {
                        if (board[i][correspondColumn].getOrientation() != Orientation.SOUTH) {
                            board[i][correspondColumn].setInSight(true);
                            if (board[i][correspondColumn].getOrientation() == Orientation.NORTH) {
                                break;
                            }
                        }
                        else {
                            break;
                        }
                    }
                    break;

                case 3:
                case 4:
                case 5:
                    int correspondRowRight = (detectivePosition % 3);
                    for (int i = 2; i >= 0; i--) {
                        if (board[correspondRowRight][i].getOrientation() != Orientation.EAST) {
                            board[correspondRowRight][i].setInSight(true);
                            if (board[correspondRowRight][i].getOrientation() == Orientation.WEST) {
                                break;
                            }
                        }
                        else {
                            break;
                        }
                    }
                    break;

                case 9:
                case 10:
                case 11:
                    int correspondRowLeft = (detectivePosition % 9 - 2) * (-1);
                    for (int i = 0; i < 3; i++) {
                        if (board[correspondRowLeft][i].getOrientation() != Orientation.WEST) {
                            board[correspondRowLeft][i].setInSight(true);
                            if (board[correspondRowLeft][i].getOrientation() == Orientation.EAST) {
                                break;
                            }
                        }
                        else {
                            break;
                        }
                    }
                    break;

                default:
                    System.out.println("il y a eu une erreur");
            }
        }
    }

    public void makeDistrictsVerso() {
        if (mrJackDistrict.isInSight()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!board[i][j].isInSight()) {
                        board[i][j].setVerso();
                    }
                }
            }
        }
        else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].isInSight()) {
                        board[i][j].setVerso();
                    }
                }
            }
        }
    }

    public boolean isMrJackCaught() {
        for (int i = 0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!board[i][j].isRecto()) {
                    numberOfDistrictVerso++;
                }
            }
        }
        System.out.println(numberOfDistrictVerso);
        if (numberOfDistrictVerso==8) {
            endGame=true;
        }
        return endGame;
    }

    // Fin de tour

    public void endTurn() {
        visibleCharacters();
        makeDistrictsVerso();
        isMrJackCaught();
        turnNumber++;
        numberOfActionsUsed=0;
        numberOfDistrictVerso=0;
        changeHand();
        shuffleTokens();
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                board[i][j].setInSight(false);
            }
        }
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
        return ((investigatorStarts && (numberOfActionsUsed == 0 || numberOfActionsUsed == 3)) || (!investigatorStarts && (numberOfActionsUsed == 1 || numberOfActionsUsed == 2)));
    }

    public boolean getInvestigatorStarts() {
        return investigatorStarts;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void gameToPrint() {
        System.out.println("\nVoici le plateau de jeu : ");
        System.out.println("     1      2      3");
        for (int i = 0; i<3; i++) {
            System.out.print(12-i + " ");
            for (int j = 0; j < 3; j++) {
                if(board[i][j].getIsCross() && !board[i][j].isRecto()) {
                    board[i][j].setOrientation(Orientation.CROSS);
                }
                System.out.print(board[i][j].toString(districtToPrint, board[i][j].getOrientation()));
                if (board[i][j].isRecto()) {
                    System.out.print("(" + board[i][j].getCharacter().toString().charAt(0)
                            + board[i][j].getCharacter().toString().charAt(1) + board[i][j].getCharacter().toString().charAt(2) + ") ");
                }
                else {
                    System.out.print("      ");
                }
            }
            System.out.println(i+4);
        }
        System.out.println("     9      8      7");
        System.out.print("\nLes detectives sont postionnes de la maniere suivante :\n- ");
        for (int i=0; i<3; i++) {
            System.out.print(Detective.values()[i].getName() + " : " + (Detective.values()[i].getPosition()+1) + " - ");
        }
        System.out.println("\n\n");

        if(!actionsAllUsed()) {
            System.out.println("Les actions disponibles sont les suivantes : ");
            for (int i = 0; i<4; i++ ) {
                if (!listOfTokens[i].isHasBeenUsed()) {
                    System.out.println(listOfTokens[i].toString() + " (Tapez " + (i+1) + ") ");
                }
            }
            System.out.println();
        }
        else {
            System.out.println("Le tour est fini, nous passons au tour suivant !");
        }
    }

    /*public MrJackPlayer getMrJackPlayer() {
        return mrJackPlayer;
    }*/

    public String getMrJackCharacter() {
        return mrJackCharacter.getName() + " (" + mrJackCharacter.toString().charAt(0)
                + mrJackCharacter.toString().charAt(1) + mrJackCharacter.toString().charAt(2) + ")";
    }

    //TEST

    public District getMrJackDistrict() {
        return mrJackDistrict;
    }

    public int getNumberOfDistrictVerso() {
        return numberOfDistrictVerso;
    }
}