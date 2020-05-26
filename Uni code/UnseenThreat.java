import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class UnseenThreat {
    public static void main(String[] args) throws FileNotFoundException {
        
       
        Scanner scanner = new Scanner(System.in);

        int probes;
        int disposal;

        int boardWidth = 0;
        int boardHeight = 0;
        int numOfMines = 0;

        String[][] boardToDisplay;
        int[] randomNumsForCol = {0, 1, 2, 3, 4, 5};

       
        File boardSize = new File("resources/enemy_territory.txt");
        File mines = new File("resources/configurations.txt");

        FileReader boardSizeReader = new FileReader(boardSize);
        FileReader minesInformation = new FileReader(mines);

        BufferedReader bufferedReader = new BufferedReader(boardSizeReader);
        BufferedReader bufferedReaderMines = new BufferedReader(minesInformation);


        boardWidth = boardWidth(boardSizeReader, bufferedReader, boardSize);

        boardHeight = boardHeight(boardSizeReader, bufferedReader, boardSize);

        numOfMines = numOfMines(boardSizeReader, bufferedReader, boardSize);

        probes = numberOfProbes(mines, minesInformation, bufferedReaderMines);

        disposal = disposalsForMines(mines, minesInformation, bufferedReaderMines);
        
        boardToDisplay = new String[boardWidth][boardHeight];
        boardToDisplay = createBoardInGame(boardToDisplay, boardHeight, boardWidth);

        for (int checker = 0; checker <= 0; ) {

            Random randomNum = new Random();

            int randomGeneratedNum = randomNum.nextInt(4) + 1;

            int startRow = 0;
			int startCol = 0;
			int finishRow = 0;
			int finishCol = 0;
			int lastRow = boardWidth - 1;
            int lastCol = boardHeight - 1;
			if (randomGeneratedNum == 1) {

                startRow = 0;

                startCol = new Random().nextInt(randomNumsForCol.length);

                finishRow = lastRow;

                finishCol = new Random().nextInt(randomNumsForCol.length);

            } else if (randomGeneratedNum == 2) {

                startRow = (int) lastRow;

                startCol = new Random().nextInt(randomNumsForCol.length);

                finishRow = 0;

                finishCol = new Random().nextInt(randomNumsForCol.length);

            } else if (randomGeneratedNum == 3) {

                startCol = lastCol;

                startRow = new Random().nextInt(randomNumsForCol.length);

                finishCol = 0;

                finishRow = new Random().nextInt(randomNumsForCol.length);

            } else if (randomGeneratedNum == 4) {

                startCol = 0;

                startRow = new Random().nextInt(randomNumsForCol.length);

                finishCol = lastCol;

                finishRow = new Random().nextInt(randomNumsForCol.length);
            }
            if (startRow == 0 || startRow == lastRow && finishRow == 0 || finishRow == lastRow) {

                System.out.println("Corner case");

            } else if (startRow == finishRow && startCol != finishCol) {

                checker++;

            } else if (startRow != finishRow && startCol != finishCol) {

                checker++;
            }
        }
    }
    public static int numberOfProbes(File mines, FileReader minesReader, BufferedReader minesBufferedReader) {

        int probes = 0;
        String lineReferences;
        String fileInformation;
        String information;

        mines = new File("resources/configurations.txt");
        try {
            minesReader = new FileReader(mines);

            minesBufferedReader = new BufferedReader(minesReader);

            while ((lineReferences = minesBufferedReader.readLine()) != null) {

                String[] boardSizeInformation = lineReferences.split("=");

                fileInformation = boardSizeInformation[0];

                information = boardSizeInformation[1];

                if (boardSizeInformation[0].equalsIgnoreCase("probes")) {

                    probes = Integer.parseInt(information);
                }
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return probes;
    }
    public static int disposalsForMines(File mines, FileReader minesReader, BufferedReader minesBufferedReader) {

        int disposals = 0;
        String lineReferences;
        String fileInformation;
        String information;

        mines = new File("resources/configurations.txt");
        try {
            minesReader = new FileReader(mines);

            minesBufferedReader = new BufferedReader(minesReader);

            while ((lineReferences = minesBufferedReader.readLine()) != null) {

                String[] boardSizeInformation = lineReferences.split("=");

                fileInformation = boardSizeInformation[0];

                information = boardSizeInformation[1];

                if (boardSizeInformation[0].equalsIgnoreCase("disposal")) {

                    disposals = Integer.parseInt(information);
                }
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return disposals;
    }
    public static int boardWidth(FileReader boardSizeReader, BufferedReader bufferedReader, File boardSize) {

        int boardWidth = 0;
        String lineReferences;
        String boardInformation;
        String boardWidthAndHeight;

        boardSize = new File("resources/enemy_territory.txt");
        try {
            boardSizeReader = new FileReader(boardSize);

            bufferedReader = new BufferedReader(boardSizeReader);

            while ((lineReferences = bufferedReader.readLine()) != null) {

                String[] boardSizeInformation = lineReferences.split("=");

                boardInformation = boardSizeInformation[0];

                boardWidthAndHeight = boardSizeInformation[1];

                if (boardSizeInformation[0].equalsIgnoreCase("Width")) {

                    boardWidth = Integer.parseInt(boardWidthAndHeight);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return boardWidth;
    }
    public static int boardHeight(FileReader boardSizeReader, BufferedReader bufferedReader, File boardSize) {

        int boardHeight = 0;
        String lineReferences;
        String boardInformation;
        String boardWidthAndHeight;

        boardSize = new File("resources/enemy_territory.txt");
        try {
            boardSizeReader = new FileReader(boardSize);

            bufferedReader = new BufferedReader(boardSizeReader);

            while ((lineReferences = bufferedReader.readLine()) != null) {

                String[] boardSizeInformation = lineReferences.split("=");

                boardInformation = boardSizeInformation[0];

                boardWidthAndHeight = boardSizeInformation[1];

                if (boardSizeInformation[0].equalsIgnoreCase("Height")) {
                    boardHeight = Integer.parseInt(boardWidthAndHeight);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return boardHeight;
    }
    public static int numOfMines(FileReader boardSizeReader, BufferedReader bufferedReader, File boardSize) {

        int numOfmines = 0;
        String lineReferences;
        String boardInformation;
        String boardWidthAndHeight;

        boardSize = new File("resources/enemy_territory.txt");
        try {
            boardSizeReader = new FileReader(boardSize);

            bufferedReader = new BufferedReader(boardSizeReader);

            while ((lineReferences = bufferedReader.readLine()) != null) {

                String[] boardSizeInformation = lineReferences.split("=");

                boardInformation = boardSizeInformation[0];

                boardWidthAndHeight = boardSizeInformation[1];

                if (boardSizeInformation[0].equalsIgnoreCase("mines")) {

                    numOfmines = Integer.parseInt(boardWidthAndHeight);
                }
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
        return numOfmines;
    }
    public static String[][] createBoardInGame(String[][] boardToDisplay, int boardHeight, int boardWidth) {

        for (int rowNo = 0; rowNo < boardHeight; rowNo++) {

            for (int colNo = 0; colNo < boardWidth; colNo++) {

                boardToDisplay[rowNo][colNo] = "X";
            }
        }
        return boardToDisplay;
    }
 }