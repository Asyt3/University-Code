import java.util.Arrays;
import java.util.Scanner;

public class Chess {

    public static void main(String[] args) {
        

        boolean isYourColorHere;
        boolean canmachineGunMove;
        boolean canQueenMove;
        boolean canDwarfMove;
        boolean canDwarfMoveForward;
        boolean canKingMove;
        boolean canDonkeyMove;
        
        Scanner scanner = new Scanner(System.in);
        
        //Variables for dwarf limit

        boolean gameOver = false;
        boolean isFigureDwRow6Col1Finished = false;
        boolean isFigureDwRow6Col6Finished = false;
        boolean isFigureDwRow1Col1Finished = false;
        boolean isFigureDwRow1Col6Finished = false;
       

        // Variables for overlap check
        
        String king = "";
        String queen = "";
        String kingKill = "";
        String dwarf = "";
        String machineGun = "";
        String donkey = "";

        // Variables for position
        int figuresRowPosition; //The figure's Row position input
        int figuresColPosition; //The figure's Col positio input

        int figuresPositionCol; //Figure's Row position with offset added [-1] -calculations done with this variable
        int figuresPositionRow; //Figure's Column position that offset added [-1] -calculations done with this variable

        // Variables to get position of the place that we want to put our figure
        int placementRow;//Figure's Row position that we want to put it as input
        int placementCol;//Figure's Column position that we want to put it as input

        int figuresPlaceRow; //Figure's Row position with offset added [-1] -calculations done with this variable
        int figuresPlaceCol; //Figure's Column position that offset added [-1] -calculations done with this variable

        final byte OFFSET_FOR_2D_ARRAY = 1;
        int maxTurns = Integer.MAX_VALUE;

        int  = 0;
        int blackPlayerTurnsCounter = 0;
        int playerIdAndTurnGiver    = 1;

        String currentPlayer = "";

        String[][] poniesChessBoard = {
                {"wDw", "wD",  "wQ",  "wK",  "wM",  "wDw"},     
                {"XXX", "XXX", "XXX", "XXX", "XXX", "XXX"},       
                {"XXX", "XXX", "XXX", "XXX", "XXX", "XXX"},       
                {"XXX", "XXX", "XXX", "XXX", "XXX", "XXX"},      
                {"XXX", "XXX", "XXX", "XXX", "XXX", "XXX"},       
                {"bDw", "bM",  "bK",  "bQ",  "bD",  "bDw"}        
        };

        System.out.println("NOTE: Please enter your figure's position with numbers.");
        
        while (!gameOver) {

            System.out.println(Arrays.deepToString(poniesChessBoard)
                    .replace("],", "\n").replace(",", "\t| ")
                    .replaceAll("[\\[\\]]", " "));

            if (isFigureDwRow6Col1Finished) {
                poniesChessBoard[5][0] = "XXX";
                poniesChessBoard[0][0] = "wDw";
            }
            if (isFigureDwRow6Col6Finished) {
                poniesChessBoard[5][5] = "XXX";
                poniesChessBoard[0][0] = "wDw";
            }
            if(isFigureDwRow1Col1Finished) {
                poniesChessBoard[0][0] = "XXX";
                poniesChessBoard[5][0] = "bWd";
            }
            if(isFigureDwRow1Col6Finished) {
                poniesChessBoard[0][5] = "XXX";
                poniesChessBoard[5][5] = "bWd";
            }

            while (playerIdAndTurnGiver <= maxTurns) {

                if (playerIdAndTurnGiver % 2 == 0) {
                    System.out.println("White Player's Turn");

                    donkey = "wD";
                    king = "wK";
                    queen = "wQ";
                    dwarf = "wDw";
                    machineGun = "wM";
                    currentPlayer = "White";
                    kingKill = "bK";

                    whitePlayerTurnCounter++;
                }
                if (playerIdAndTurnGiver % 2 != 0) {
                    System.out.println("Black Player's Turn");

                    dwarf         = "bDw";
                    donkey        = "bD";
                    king          = "bK";
                    queen         = "bQ";
                    machineGun        = "bM";
                    currentPlayer = "Black";
                    kingKill    = "wK";

                    blackPlayerTurnsCounter++;
                }

                System.out.println("From which Row you want to MOVE your figure");
                figuresRowPosition = Integer.parseInt(scanner.nextLine());

                System.out.println("From which COLUMN you want to MOVE your figure");
                figuresColPosition = Integer.parseInt(scanner.nextLine());

                figuresPositionRow = figuresRowPosition - OFFSET_FOR_2D_ARRAY; // Figure's col position var
                figuresPositionCol = figuresColPosition - OFFSET_FOR_2D_ARRAY; // Figure's Row position var

                System.out.println("To which Row you want to PLACE your figure ");
                placementRow = Integer.parseInt(scanner.nextLine());

                System.out.println("To which COLUMN you want to PLACE your figure ");
                placementCol = Integer.parseInt(scanner.nextLine());

                figuresPlaceRow = placementRow - OFFSET_FOR_2D_ARRAY; // Current position of the figure
                figuresPlaceCol = placementCol - OFFSET_FOR_2D_ARRAY; // Current position of the figure

                    isYourColorHere =
                            poniesChessBoard[figuresPlaceRow][figuresPlaceCol].equals("wDw")||
                            poniesChessBoard[figuresPlaceRow][figuresPlaceCol].equals("wD") ||
                            poniesChessBoard[figuresPlaceRow][figuresPlaceCol].equals("wQ") ||
                            poniesChessBoard[figuresPlaceRow][figuresPlaceCol].equals("wK") ||
                            poniesChessBoard[figuresPlaceRow][figuresPlaceCol].equals("wM") ||
                            poniesChessBoard[figuresPlaceRow][figuresPlaceCol].equals("wK");
                
                canDwarfMoveForward = figuresPositionCol + 1 == figuresPlaceRow;

                if (playerIdAndTurnGiver % 2 != 0) {
                    
                    isYourColorHere =
                            poniesChessBoard[figuresPlaceRow][figuresPlaceCol].equals("bDw")||
                            poniesChessBoard[figuresPlaceRow][figuresPlaceCol].equals("bD") ||
                            poniesChessBoard[figuresPlaceRow][figuresPlaceCol].equals("bQ") ||
                            poniesChessBoard[figuresPlaceRow][figuresPlaceCol].equals("bK") ||
                            poniesChessBoard[figuresPlaceRow][figuresPlaceCol].equals("bM") ||
                            poniesChessBoard[figuresPlaceRow][figuresPlaceCol].equals("bK");
                    
                    canDwarfMoveForward = figuresPositionRow - 1 == figuresPlaceRow;
             }

                // Calculations if one figure is moveable
                canmachineGunMove = (Math.abs(figuresPlaceRow - figuresPositionRow)    == 0) &&
                                   (Math.abs(figuresPositionCol  - figuresPlaceCol)   == 1) ||
                                   (Math.abs(figuresPlaceRow - figuresPositionRow)    == 1) &&
                                   (Math.abs(figuresPositionCol  - figuresPlaceCol)   == 0) ;
                canQueenMove  = (Math.abs(figuresPositionRow  - figuresPlaceRow)   == 1) &&
                                   (Math.abs(figuresPositionCol  - figuresPlaceCol)   == 1);
                canDwarfMove  = Math.abs(figuresPlaceRow  - figuresPositionRow)    == 1  &&
                                   canDwarfMoveForward;
                canDonkeyMove =(Math.abs(figuresPlaceRow  - figuresPositionRow)    == 2) ||
                                  (Math.abs(figuresPlaceRow  - figuresPlaceCol)   == 2);
                canKingMove   = canmachineGunMove || canQueenMove;

                if (poniesChessBoard[figuresPlaceRow][figuresPlaceCol].equals(kingKill)) {

                    gameOver = true;
                    break;

                } else if (poniesChessBoard[figuresPositionRow][figuresPositionCol].equals(dwarf)) {
                    if (canDwarfMove) {
                        if(isYourColorHere) {
                            System.out.println("\nSorry, your figure is there, try again");
                            break;
                        }
                        if (figuresPlaceRow == 5 && figuresPlaceCol == 0) {
                            isFigureDwRow6Col1Finished = true;
                        }
                        if (figuresPlaceRow == 5 && figuresPlaceCol == 5) {
                            isFigureDwRow6Col6Finished = true;
                        }
                        if(figuresPlaceRow  == 0 && figuresPlaceCol == 0) {
                            isFigureDwRow1Col1Finished = true;
                        }
                        if(figuresPlaceRow  == 0 && figuresPlaceCol == 5){
                            isFigureDwRow1Col6Finished = true;
                        }
                        poniesChessBoard[figuresPlaceRow][figuresPlaceCol] =
                                poniesChessBoard[figuresPositionRow][figuresPositionCol];

                        poniesChessBoard[figuresPositionRow][figuresPositionCol] = "XXX";
                        playerIdAndTurnGiver++;
                        break;
                    }
                } else if (poniesChessBoard[figuresPositionRow][figuresPositionCol].equals(machineGun)) {

                    if (canmachineGunMove) {
                        if(isYourColorHere) {
                            System.out.println("\nSorry, your figure is there, try again");
                            break;
                        }

                        poniesChessBoard[figuresPlaceRow][figuresPlaceCol] =
                                poniesChessBoard[figuresPositionRow][figuresPositionCol];

                        poniesChessBoard[figuresPositionRow][figuresPositionCol] = "XXX";
                        playerIdAndTurnGiver++;
                        break;
                    }
                } else if (poniesChessBoard[figuresPositionRow][figuresPositionCol].equals(queen)) {

                    if (canQueenMove) {
                        if(isYourColorHere) {
                            System.out.println("\nSorry, your figure is there, try again");
                            break;
                        }

                        poniesChessBoard[figuresPlaceRow][figuresPlaceCol] =
                                poniesChessBoard[figuresPositionRow][figuresPositionCol];

                        poniesChessBoard[figuresPositionRow][figuresPositionCol] = "XXX";
                        playerIdAndTurnGiver++;
                        break;
                    }
                } else if (poniesChessBoard[figuresPositionRow][figuresPositionCol].equals(king)) {

                    if (canKingMove) {
                        if(isYourColorHere) {
                            System.out.println("\nSorry, your figure is there, try again");
                            break;
                        }

                        poniesChessBoard[figuresPlaceRow][figuresPlaceCol] =
                                poniesChessBoard[figuresPositionRow][figuresPositionCol];

                        poniesChessBoard[figuresPositionRow][figuresPositionCol] = "XXX";
                        playerIdAndTurnGiver++;
                        break;
                    }
                } else if (poniesChessBoard[figuresPositionRow][figuresPositionCol].equals(donkey)) {

                    if ( % 3 == 0 || blackPlayerTurnsCounter % 3 == 0) {
                        if (canDonkeyMove) {
                            if(isYourColorHere) {
                                System.out.println("\nSorry, your figure is there, try again");
                                break;
                            }
                            poniesChessBoard[figuresPlaceRow][figuresPlaceCol] =
                                    poniesChessBoard[figuresPositionRow][figuresPositionCol];

                            poniesChessBoard[figuresPositionRow][figuresPositionCol] = "XXX";
                            playerIdAndTurnGiver++;
                            break;
                        }
                    }
                }
                System.out.println("That is not possible");
            }
        }
        System.out.printf("Game Over!\n%s Player is the WINNER!!!", currentPlayer);
    }
}
