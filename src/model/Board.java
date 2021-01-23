package model;

import game.Game;
import players.InvestigatorPlayer;
import players.MrJackPlayer;
import players.Player;

import java.util.*;

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
    private boolean chaseMode;
    private boolean investigatorStarts;
    private int numberOfActionsUsed;
    private Alibi mrJackCharacter;
    private District mrJackDistrict;
    private int numberOfDistrictVerso;
    private InvestigatorPlayer investigatorPlayer;
    private MrJackPlayer mrJackPlayer;
    private Player winner;

    public Board() {
        this.generate();
    }

    public void generate() {
        alibiCards = new Stack<>();
        board = new District[3][3];
        listOfDetectives = Detective.values();
        listOfTokens = ActionToken.values();
        districtToPrint = new String[] {"╦","╣","╩","╠","╬"};
        turnNumber = 1;
        numberOfActionsUsed = 0;
        numberOfDistrictVerso = 0;
        investigatorStarts = true;

        deckGenerate();
        playersGenerate();
        districtBoardGenerate();
        shuffleTokens();
    }

    // Fonctions d'initialisation

    public void deckGenerate() {
        Alibi[] alibis = Alibi.values();
        mrJackCharacter = Alibi.values()[(int) (Math.random()*9)];
        alibiCards.addAll(Arrays.asList(alibis));
        Collections.shuffle(alibiCards);
    }

    public void playersGenerate() {
        Game.scan.nextLine(); //Règle un pb de scrolling
        System.out.println("Quel est le nom du joueur enqueteur ?");
        String userName = Game.scan.nextLine();
        investigatorPlayer = new InvestigatorPlayer(new ArrayList<>(), userName);
        System.out.println("Quel est le nom du joueur MrJack ?");
        userName = Game.scan.nextLine();
        mrJackPlayer = new MrJackPlayer(new ArrayList<>(), userName, mrJackCharacter);
    }

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
        Collections.shuffle(alibiCards);
    }

    // Fonctions actions

    public boolean actionsAllUsed() {
        boolean endActions = true;
        for (int i = 0; i<4; i++) {
            if (ActionToken.values()[i].isHasBeenUsed()) {
                endActions = false;
                break;
            }
        }
        return !endActions;
    }

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

    public void chooseActions() {
        boolean inputError = true;
        while (inputError) {
            try {
                int userChoice = Game.scan.nextInt();
                switch (userChoice - 1) {
                    case 0:
                        if (listOfTokens[0].isHasBeenUsed()) {
                            if (listOfTokens[0].isHead()) {
                                alibiDraw();
                            } else {
                                moveDetective(listOfDetectives[1]);
                            }
                            listOfTokens[0].setHasBeenUsed(true);
                            numberOfActionsUsed++;
                        } else {
                            System.out.println("Cette action a deja ete utilisee, choisissez en une autre ");
                        }
                        break;

                    case 1:
                        if (listOfTokens[1].isHasBeenUsed()) {
                            if (listOfTokens[1].isHead()) {
                                moveDetective(listOfDetectives[2]);
                            } else {
                                moveDetective(listOfDetectives[0]);
                            }
                            listOfTokens[1].setHasBeenUsed(true);
                            numberOfActionsUsed++;
                        } else {
                            System.out.println("Cette action a deja ete utilisee, choisissez en une autre ");
                        }
                        break;

                    case 2:
                        if (listOfTokens[2].isHasBeenUsed()) {
                            if (listOfTokens[2].isHead()) {
                                rotate();
                            } else {
                                swapDistricts();
                            }
                            listOfTokens[2].setHasBeenUsed(true);
                            numberOfActionsUsed++;
                        } else {
                            System.out.println("Cette action a deja ete utilisee, choisissez en une autre ");
                        }
                        break;

                    case 3:
                        if (listOfTokens[3].isHasBeenUsed()) {
                            if (listOfTokens[3].isHead()) {
                                rotate();
                            } else {
                                moveChosenDetective();
                            }
                            listOfTokens[3].setHasBeenUsed(true);
                            numberOfActionsUsed++;
                        } else {
                            System.out.println("Cette action a deja ete utilisee, choisissez en une autre ");
                        }
                        break;

                    default:
                        System.out.println("L'entee saisie est invalide, veuillez ressaisir votre demande\n");
                }
                inputError = false;
            } catch (InputMismatchException e) {
                System.out.println("L'entree doit etre un entier\n");
                inputError = false;
            }
        }
    }

    public void alibiDraw() {
        Alibi alibiCardDrawn;
        alibiCardDrawn = alibiCards.pop();
        if(investigatorPlays()) {
            System.out.println("L'alibi obtenu est : " + alibiCardDrawn.getName());
            investigatorPlayer.addToAlibiCards(alibiCardDrawn);
            investigatorPlayer.addToCountHourglass(alibiCardDrawn.getHourglass());
            for (int i = 0; i<3; i++) {
                for (int j = 0; j<3; j++) {
                    if (board[i][j].getCharacter() == alibiCardDrawn) {
                        board[i][j].setVerso();
                    }
                }
            }
        }
        else {
            mrJackPlayer.addToAlibiCards(alibiCardDrawn);
            mrJackPlayer.addToCountHourglass(alibiCardDrawn.getHourglass());
            System.out.println("Mr. Jack a maintenant " + mrJackPlayer.getCountHourglass() + " sabliers en sa possession");
        }
    }

    public void moveDetective(Detective detective) {
        System.out.println("De combien ce cases souhaitez-vous le faire avancer (1 ou 2) ?");
        boolean inputError = true;
        while (inputError) {
            try {
                int distance = Game.scan.nextInt();
                if (distance == 1 || distance == 2) {
                    detective.setPosition((detective.getPosition() + distance) % 12);
                }
                else {
                    System.out.println("Le deplacement  n'est pas valide, veuillez reesayer");
                    moveDetective(detective);
                }
                inputError = false;
            } catch (InputMismatchException e) {
                System.out.println("L'entree doit etre un entier egal a 1 ou 2\n");
                inputError = false;
                moveDetective(detective);
            }
        }
    }

    public void moveChosenDetective() {
        int userChoice=1;
        boolean inputError = true;
        while(inputError) {
            try {
                if (!investigatorPlays()) {
                    System.out.println("Voulez-vous deplacer 1 detective (1) ou laisser les 3 detectives a leur place (0)?");
                    userChoice = Game.scan.nextInt();
                    if(userChoice != 1 && userChoice !=0) {
                        System.out.println("La demande n'est pas valide, veuillez reessayer");
                        inputError = false;
                        moveChosenDetective();
                    }
                }
                if (userChoice != 0) {
                    System.out.println("Choisissez un detective a deplacer : Watson (1) | Sherlock (2) | Tobby (3)");
                    userChoice = Game.scan.nextInt();
                    listOfDetectives[userChoice - 1].setPosition((listOfDetectives[userChoice - 1].getPosition() + 1) % 12);
                    inputError = false;
                }
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.out.println("L'entree doit etre un entier de 1 a 3\n");
                inputError = false;
                moveChosenDetective();
            }
        }
    }

    public void rotate() {
        System.out.println("Quel quartier voulez-vous tourner ? Entrez un numero de 1 à 9, en suivant la correspondance");
        Scanner userInput = new Scanner(System.in);
        int districtPosition;
        boolean inputError = true;
        while (inputError) {
            try {
                districtPosition = userInput.nextInt();
                int positionRow = (districtPosition - 1) / 3;
                int positionColumn = (districtPosition - 1) % 3;
                District district = board[positionRow][positionColumn];
                if (!district.HasBeenRotate()) {
                    System.out.println("De combien de quarts de tour voulez-vous le faire tourner (sens horaire) ?");
                    int times = userInput.nextInt();
                    district.setOrientation(Orientation.values()[(district.getOrientation().ordinal() + times) % 4]);
                    district.setHasBeenRotate(true);
                    inputError=false;
                } else {
                    System.out.println("Ce quartier a deja ete tourne, choisissez en un autre\n");
                    rotate();
                }
            } catch (InputMismatchException e) {
                userInput.nextLine();
                System.out.println("L'entree doit etre un entier\n");
            } catch (ArrayIndexOutOfBoundsException e) {
                userInput.nextLine();
                System.out.println("L'entree doit etre comprise entre 1 et 9\n");
            }
        }
    }

    public void swapDistricts() {

        /*
        1|2|3
        4|5|6
        7|8|9
        */
        Scanner userInput = new Scanner(System.in);
        boolean inputError = true;
        while(inputError) {
            try {
                System.out.println("Quel quartier voulez-vous deplacer ?");
                int positionDistrict1 = userInput.nextInt();
                System.out.println("Avec quel quartier voulez-vous l'echanger ?");
                int positionDistrict2 = userInput.nextInt();
                District swapDistrict;

                int positionRow1 = (positionDistrict1 -1)/3;
                int positionColumn1 = (positionDistrict1 -1)%3;
                int positionRow2 = (positionDistrict2 -1)/3;
                int positionColumn2 = (positionDistrict2 -1)%3;

                swapDistrict = board[positionRow2][positionColumn2];
                board[positionRow2][positionColumn2] = board[positionRow1][positionColumn1];
                board[positionRow1][positionColumn1] = swapDistrict;
                inputError = false;
            } catch (InputMismatchException e) {
                userInput.nextLine();
                System.out.println("L'entree doit etre un entier\n");
            } catch (ArrayIndexOutOfBoundsException e) {
                userInput.nextLine();
                System.out.println("L'entree doit etre comprise entre 1 et 9\n");
            }
        }
    }

    // Fin de tour
    // Vision des detectives

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
                    System.out.println("Il y a eu une erreur, veuillez redemarrer le programme");
            }
        }
    }

    public void makeDistrictsVerso() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mrJackDistrict.isInSight()) {
                    if (!board[i][j].isInSight()) {
                        board[i][j].setVerso();
                    }
                }
                else {
                    if (board[i][j].isInSight()) {
                        board[i][j].setVerso();
                    }
                }
                if(!board[i][j].isRecto()) {
                    numberOfDistrictVerso++;
                }
            }
        }
    }

    public void hasPlayersReachObjectives() {
        if (!chaseMode) {
            if (numberOfDistrictVerso == 8) {
                investigatorPlayer.setHasReachObjective();
            }
            if (mrJackPlayer.getCountHourglass() >= 6) {
                mrJackPlayer.setHasReachObjective();
            }
            if (investigatorPlayer.isHasReachObjective() != mrJackPlayer.isHasReachObjective()) {
                winner = (investigatorPlayer.isHasReachObjective() ? investigatorPlayer : mrJackPlayer);
            }
            if (investigatorPlayer.isHasReachObjective() == mrJackPlayer.isHasReachObjective() && investigatorPlayer.isHasReachObjective()) {
                if (mrJackDistrict.isInSight()) {
                    winner = investigatorPlayer;
                }
                else {
                    chaseMode = true;
                    hasPlayersReachObjectives();
                }
            }
        }

        else {
            if(turnNumber == 8) {
                winner = mrJackPlayer;
            }
            if (mrJackDistrict.isInSight() && turnNumber <= 8) {
                winner = investigatorPlayer;
            }
        }
    }

    //Reset, verifications et logique de fin de tour

    public void endTurn() {
        visibleCharacters();
        makeDistrictsVerso();
        playerAddToCountHourglass();
        hasPlayersReachObjectives();
        endTurnToPrint();
        turnNumber++;
        numberOfActionsUsed=0;
        numberOfDistrictVerso=0;
        resetDistricts();
        changeHand();
        shuffleTokens();
    }

    public void resetDistricts() {
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                board[i][j].setInSight(false);
                board[i][j].setHasBeenRotate(false);
            }
        }
    }

    public void playerAddToCountHourglass() {
        if(mrJackDistrict.isInSight()) {
            investigatorPlayer.addToCountHourglass(1);
        }
        else {
            mrJackPlayer.addToCountHourglass(1);
        }
    }

    public boolean isEndGame() {
        return winner!=null;
    }

    public void changeHand() {
        investigatorStarts = turnNumber % 2 != 0;
    }

    public boolean investigatorPlays() {
        return ((investigatorStarts && (numberOfActionsUsed == 0 || numberOfActionsUsed == 3)) || (!investigatorStarts && (numberOfActionsUsed == 1 || numberOfActionsUsed == 2)));
    }

    // Affichage du board

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

        if(actionsAllUsed()) {
            System.out.println("\n\nLes actions disponibles sont les suivantes : ");
            for (int i = 0; i<4; i++ ) {
                if (listOfTokens[i].isHasBeenUsed()) {
                    System.out.println(listOfTokens[i].toString() + " (Tapez " + (i+1) + ") ");
                }
            }
            System.out.println();
        }
    }

    //Affichage de fin de tour, avec fin de partie

    public void endTurnToPrint() {
        if (!chaseMode) {
            System.out.println("\n\nAttention ! Mr. Jack possede " + mrJackPlayer.getCountHourglass() + " sablier(s) !");
            System.out.println("\nMr. Jack " + (mrJackDistrict.isInSight() ? "est visible" : "n'est pas visible") +
                " pour les detectives...\nLes quartiers " + (mrJackDistrict.isInSight() ? "caches" : "en vue") + " sont " +
                "tournes face verso!\n");
            System.out.println(numberOfDistrictVerso + " quartiers sont a present face verso!");
            System.out.println("\n\nLe tour est fini, nous passons au tour suivant !");
        }
        else {
            System.out.println("\n\nLes deux joueurs ont atteint leurs objectifs ! L'enqueteur et mr. Jack sont dans une course poursuite !");
        }
        if (winner != null) {
            System.out.println("\n\n" + (winner == investigatorPlayer ? "Mr. Jack est pris au piege !" : "L'enqueteur a perdu trop de temps !"));
            System.out.println("\nLa partie est finie !\n\nLe joueur " + winner.getName() + " remporte donc la partie en tant " +
                    (winner == investigatorPlayer ? "qu'enqueteur" : "que mr. Jack") + " !\n\n");
        }
    }

    public String getMrJackCharacter() {
        return mrJackCharacter.getName() + " (" + mrJackCharacter.toString().charAt(0)
                + mrJackCharacter.toString().charAt(1) + mrJackCharacter.toString().charAt(2) + ")";
    }

    //Getters pour la logique du jeu dans game.Game

    public boolean getInvestigatorStarts() {
        return investigatorStarts;
    }

    public int getTurnNumber() {
        return turnNumber;
    }
}