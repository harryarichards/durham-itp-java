import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Game implements GameInterface{

    private Colour currentColour;
    private HashMap<Colour, PlayerInterface> colourPlayer;
    private Board board;
    private List<Integer> diceValues;
    private Dice dice;
    private Scanner scan;

    public Game(){
        colourPlayer = new HashMap<Colour, PlayerInterface>();
        board = new Board();
        currentColour = Colour.values()[0];
        scan = new Scanner(System.in);
        dice = new Dice();
        diceValues = new ArrayList<Integer>();
    }

    public static void main(String[] args){
        Game game = new Game();
        game.mainMenu();
    }

    public void mainMenu(){
        String welcomeString = "Welcome to Tabula. \n \n" + "Select one of the following options: \n" + "1: Load Game \n" + "2: Continue game \n" + "3: New game \n" + "4: Exit \n Input 'pause' or 'p' at any point to pause. \n \n";
        System.out.println(welcomeString);
        String input = scan.nextLine();
        boolean welcomeLoop = true;
        while (welcomeLoop){
            if (input.toLowerCase().trim().equals("1") | input.toLowerCase().trim().equals("load game") | input.toLowerCase().trim().equals("load")){
                System.out.println("Please input the file name of the game you wish to load.");
                String filename = scan.nextLine();
                try {
                    loadGame(filename);
                }
                catch (IOException e){
                    System.out.println("Game failed to load.");
                }
            }
            else if (input.toLowerCase().trim().equals("2") | input.toLowerCase().trim().equals("continue") | input.toLowerCase().trim().equals("continue game")){
                try {
                    setPlayer(Colour.values()[0], new HumanConsolePlayer());
                    setPlayer(Colour.values()[1], new HumanConsolePlayer());
                    play();
                }
                catch (PlayerNotDefinedException e){
                }
            }
            else if (input.toLowerCase().trim().equals("3") | input.toLowerCase().trim().equals("new") | input.toLowerCase().trim().equals("new game")){
                try {
                    setPlayer(Colour.values()[0], new HumanConsolePlayer());
                    setPlayer(Colour.values()[1], new HumanConsolePlayer());
                    play();
                }
                catch (PlayerNotDefinedException e){
                }
            }
            else if (input.toLowerCase().trim().equals("4") | input.toLowerCase().trim().equals("exit") | input.toLowerCase().trim().equals("exit program")){
                welcomeLoop = false;
            }
        }
    }

    /**
     * @param colour of the player to set
     *
     * @param player the player to use
     **/
    public void setPlayer(Colour colour, PlayerInterface player){
        colourPlayer.put(colour, player);
    }

    /**
     * @return the player who has the next turn. Green goes first.
     **/
    public Colour getCurrentPlayer(){
        return currentColour;
    }

    /**
     * Play the game until completion or pause. Should work either for a new game or the continuation of a paused game. This method should roll the dice and pass the dice values to the players. The players should be asked one after another for their choice of turn via their getTurn method. The board that is passed to the players should be a clone of the game board so that they can try out moves without affecting the state of the game.
     *
     * @return the colour of the winner if there is one, or null if not (the game has been paused by a player). If a player tries to take an illegal turn then they forfeit the game and the other player immediately wins.
     *
     * @throws PlayerNotDefinedException if one or both of the players is undefined
     **/
    public Colour play() throws PlayerNotDefinedException{

        if(colourPlayer.size() != 2){
            throw new PlayerNotDefinedException("Define both players before playing the game.");
        }
        PlayerInterface player;


        while(!board.isWinner(currentColour)){
            player = colourPlayer.get(currentColour);
            System.out.println(currentColour + " player turn:");
            try{
                dice.roll();
                try{
                    diceValues = dice.getValues();
                }
                catch (NotRolledYetException e){
                    System.out.println("Dice not yet rolled.");
                }
                TurnInterface turn = player.getTurn(currentColour, board.clone(), diceValues);
                if (turn != null){
                    board.takeTurn(currentColour, turn, diceValues);
                    diceValues.clear();
                }
            }
            catch (PauseException e){
                System.out.println("Game paused");
                pauseMenu();
            } catch (IllegalTurnException e) {
                e.printStackTrace();
            }
            currentColour = currentColour.otherColour();
        }
        if(board.isWinner(currentColour)) {
            System.out.println(currentColour + " player won the game.");
            return currentColour;
        }
        else{
            return null;
        }

    }

    public void pauseMenu(){
        System.out.println("Please enter one of the following commands:");
        System.out.println("Save Game, Resume or Main Menu.");
        boolean validInput = false;
        while (!validInput){
            String input = scan.nextLine();
            if (input.toLowerCase().trim().equals("save game") | input.toLowerCase().trim().equals("s") | input.toLowerCase().trim().equals("save")){
                System.out.println("\nPlease type the name of the file you wish to save.");
                String fileName = scan.nextLine();
                try {
                    saveGame(fileName);
                }
                catch (IOException e){
                    System.out.println("File failed to save.");
                }
            }
            else if (input.toLowerCase().trim().equals("resume game") | input.toLowerCase().trim().equals("r") | input.toLowerCase().trim().equals("resume")){
                try{
                    play();
                }
                catch (PlayerNotDefinedException e){
                }
            }
            else if (input.toLowerCase().trim().equals("main menu")){
                mainMenu();
            }
            else {
                System.out.println("Input not valid, please input one of the given commands: Save Game, Resume or Main Menu.");
            }
        }

    }

    /**
     * Save the current state of the game (including the board, dice and player types) into a file so it can be re-loaded and game play continued. You choose what the format of the file is.
     *
     * @param filename the name of the file in which to save the game state
     *
     * @throws IOException when an I/O problem occurs while saving
     **/
    public void saveGame(String filename) throws IOException{
        try {
            File saveGame = new File(filename + ".txt");
            FileWriter gameSaver = new FileWriter(saveGame);
            gameSaver.write(gameFileFormat());
            gameSaver.close();
            System.out.println("Game saved \n");
            pauseMenu();
        }
        catch (IOException e){
            throw new IOException("Game could not save.");
        }
    }



    public String gameFileFormat(){
        String diceString = "";
        try{
            if (dice.getValues().size() == 2){
                diceString = dice.getValues().get(0) + ":" + dice.getValues().get(1);
            }
            else{
                diceString = dice.getValues().get(0) + ":" + dice.getValues().get(1) + ":" + dice.getValues().get(2) + ":" +dice.getValues().get(3);
            }
        }
        catch (NotRolledYetException e){
            System.out.println("Not yet rolled.");
        }




        return (diceString +"\n" + currentColour + "\n" + board.toString() + "\n");
        /*
        Gives the format of the file we are save@
        e.g.
        GREEN | HumanPlayer
        BLUE | ComputerPlayer
        GREEN
        Board as seen in the board class.
        4 4 2 6
         */

    }


    /**
     * Load the game state from the given file
     *
     * @param filename  the name of the file from which to load the game state
     *
     * @throws IOException when an I/O problem occurs or the file is not in the correct format (as used by saveGame())
     **/
    public void loadGame(String filename) throws IOException{
        try{
            File file = new File(filename + ".txt");
            BufferedReader reader = new BufferedReader((new FileReader(file)));
            colourPlayer.clear();
            diceValues.clear();
            board = new Board();
            Location startLocation = (Location)board.getStartLocation();
            startLocation.setNumberOfPieces(Colour.values()[0], 0);
            startLocation.setNumberOfPieces(Colour.values()[1], 0);
            Location endLocation = (Location)board.getEndLocation();
            endLocation.setNumberOfPieces(Colour.values()[0], 0);
            endLocation.setNumberOfPieces(Colour.values()[1], 0);
            for (int i = 0; i<BoardInterface.NUMBER_OF_LOCATIONS; i++){
                try{
                    Location location = (Location)board.getBoardLocation(i);
                    location.setNumberOfPieces(Colour.values()[0], 0);
                    location.setNumberOfPieces(Colour.values()[1], 0);
                }
                catch (NoSuchLocationException e){
                }
            }

            int lineReading = 1;
            while (1<= lineReading && lineReading <=5) {
                String lineToRead = reader.readLine();
                if (lineReading == 1) {
                    for (String diceStringVal : lineToRead.split(":")) {
                        diceValues.add(Integer.parseInt(diceStringVal.trim()));
                    }
                    lineReading ++;
                } else if (lineReading == 2) {
                    String colourString = lineToRead;
                    if (colourString.equals(Colour.values()[0].toString())) {

                        currentColour = Colour.values()[0];
                    } else if (colourString.equals(Colour.values()[1].toString())) {
                        currentColour = Colour.values()[1];
                    }
                    lineReading++;
                }
                else if (lineReading ==3){
                    lineReading ++;
                } else if (lineReading == 4) {
                    int k = -3;
                    for (String locationPiecesString : lineToRead.trim().split("\\|")) {
                        if (1<= k && k <= 24) {
                            for (int i = 0; i < Integer.parseInt(locationPiecesString.trim()); i++) {
                                try {
                                    board.getBoardLocation(k).addPieceGetKnocked(Colour.values()[0]);
                                } catch (IllegalMoveException e) {
                                    System.out.println("Failed to load");
                                } catch (NoSuchLocationException e) {
                                    System.out.println("No such location.");
                                }
                            }

                        } else if (k == -1) {
                            for (int i = 0; i < Integer.parseInt(locationPiecesString.trim()); i++) {
                                try {
                                    board.getKnockedLocation().addPieceGetKnocked(Colour.values()[0]);
                                } catch (IllegalMoveException e) {
                                    System.out.println("Failed to load.");
                                }
                            }
                        } else if (k == 0) {
                            for (int i = 0; i < Integer.parseInt(locationPiecesString.trim()); i++) {
                                try {
                                    board.getStartLocation().addPieceGetKnocked(Colour.values()[0]);
                                } catch (IllegalMoveException e) {
                                    System.out.println("Failed to load.");
                                }
                            }
                        } else if (k == 25) {
                            for (int i = 0; i < Integer.parseInt(locationPiecesString.trim()); i++) {
                                try {
                                    board.getEndLocation().addPieceGetKnocked(Colour.values()[0]);
                                } catch (IllegalMoveException e) {
                                    System.out.println("Failed to load.");
                                }
                            }
                        }
                        k++;
                    }
                    lineReading ++;
                } else if (lineReading == 5) {
                    int k = -3;
                    for (String locationPiecesString : lineToRead.trim().split("\\|")) {
                        if (1 <= k && k <= 24) {
                            for (int i = 0; i < Integer.parseInt(locationPiecesString.trim()); i++) {
                                try {
                                    board.getBoardLocation(k).addPieceGetKnocked(Colour.values()[1]);
                                } catch (IllegalMoveException e) {
                                    System.out.println("Failed to load.");
                                } catch (NoSuchLocationException e) {
                                    System.out.println("No such location.");
                                }
                            }

                        } else if (k == -1) {
                            for (int i = 0; i < Integer.parseInt(locationPiecesString.trim()); i++) {
                                try {
                                    board.getKnockedLocation().addPieceGetKnocked(Colour.values()[1]);
                                } catch (IllegalMoveException e) {
                                    System.out.println("Failed to load.");
                                }
                            }
                        } else if (k == 0) {
                            for (int i = 0; i < Integer.parseInt(locationPiecesString.trim()); i++) {
                                try {
                                    board.getStartLocation().addPieceGetKnocked(Colour.values()[1]);
                                } catch (IllegalMoveException e) {
                                    System.out.println("Failed to load.");
                                }
                            }
                        } else if (k == 25) {
                            for (int i = 0; i < Integer.parseInt(locationPiecesString.trim()); i++) {
                                try {
                                    board.getEndLocation().addPieceGetKnocked(Colour.values()[1]);
                                } catch (IllegalMoveException e) {
                                    System.out.println("Failed to load.");
                                }
                            }
                        }
                        k++;
                    }
                    lineReading++;
                }

            }
            reader.close();
            System.out.println("Game loaded.");
            System.out.println(board.toString());
            mainMenu();

        }
        catch (IOException e){
            System.out.println("Failed to load game.");
        }
    }
}
