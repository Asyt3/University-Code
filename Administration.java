import java.util.Random;
import java.util.Scanner;

public class Administration {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Брой на числа за въвеждане? ");
        int arrSize = Integer.parseInt(scanner.nextLine());

        int[] mainArray = new int[arrSize];

        int selection;
        int numCounter = 1;

        boolean programUsage = true;

        System.out.println("Числата трябва да са между 0 и 100");

        for (int i = 0; i < arrSize;) {

            System.out.printf("Въведете число номер: %d\n", numCounter);

            mainArray[i] = Integer.parseInt(scanner.nextLine());

            if (mainArray[i] > 0 && mainArray[i] < 100) {
                i++;
                numCounter++;
            } else {
                System.out.println("Числото НЕ е между 0 и 100");
            }
        }

        optionDisplayer();

        selection = selection();

        while (programUsage) {

            if (selection == 1) {

                ascendingAndDescendingSort(arrSize, mainArray, selection);
            } else if (selection == 2) {

                ascendingAndDescendingSort(arrSize, mainArray, selection);
            } else if (selection == 3) {

                findNumPos(arrSize, mainArray);
            } else if (selection == 4) {

                arrayScramble(arrSize, mainArray);
            } else if (selection == 5) {

                sumAndAverageCalculator(arrSize, mainArray, selection);
            } else if (selection == 6) {

                smallestAndBiggestNumFinder(arrSize, mainArray, selection);
            } else if (selection == 7) {

                smallestAndBiggestNumFinder(arrSize, mainArray, selection);
            } else if (selection == 8) {

                sumAndAverageCalculator(arrSize, mainArray, selection);
            } else if (selection == 9) {

                isArraySymmetrical(arrSize, mainArray);
            } else if (selection == 10) {

                reversingArray(arrSize, mainArray);
            } else if (selection == 11) {

                displayEnteredNums(arrSize, mainArray);
            } else if (selection == 12) {
                break;
            }

            programUsage = moreWork(programUsage);

            if (programUsage) {

                optionDisplayer();

                selection = selection();
            }
        }
        System.out.println("Програмата е затворена");
    }

    /**
     * Method that does Ascending and Descending sorting
     *
     * @param arrSize   size of mainArrya
     * 
     * @param mainArray Array that stores all the numbers
     * 
     * @param selection User's selection
     */
    public static void ascendingAndDescendingSort(int arrSize, int[] mainArray, int selection) {

        for (int i = 0; i < arrSize; i++) {

            for (int j = 0; j < arrSize; j++) {
                if (mainArray[i] < mainArray[j]) {

                    int temporary = mainArray[i];
                    mainArray[i] = mainArray[j];
                    mainArray[j] = temporary;
                }
            }
        }
        if (selection == 2) {
            for (int i = arrSize - 1; i >= 0; i--) {

                System.out.printf("%d, ", mainArray[i]);
            }
        } else {
            for (int i = 0; i < arrSize; i++) {

                System.out.printf("%d, ", mainArray[i]);
            }
        }
    }

    /**
     * Method that finds the position of a number from the Array
     *
     * @param arrSize   The size of the mainArray
     * @param mainArray Array that contains all of the numbers, entered by the user
     */
    public static void findNumPos(int arrSize, int[] mainArray) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arrSize; i++) {

            for (int j = 0; j < arrSize; j++) {
                if (mainArray[i] < mainArray[j]) {

                    int temporary = mainArray[i];
                    mainArray[i] = mainArray[j];
                    mainArray[j] = temporary;
                }
            }
        }

        int positionOfSearchedNum = 0;
        int firstNum = 0;
        int lastNum = arrSize - 1;
        int middleNum = (firstNum + lastNum) / 2;
        int findThisNumPos;

        boolean isNumFound = false;

        System.out.println("На кое число желаете да намерите позицията?");

        findThisNumPos = Integer.parseInt(scanner.nextLine());

        while (firstNum <= lastNum) {

            if (findThisNumPos == mainArray[middleNum]) {

                positionOfSearchedNum = middleNum;

                isNumFound = true;
                break;

            } else if (findThisNumPos < mainArray[middleNum]) {

                lastNum = middleNum - 1;
            } else {

                firstNum = middleNum + 1;
            }
            middleNum = (firstNum + lastNum) / 2;
        }
        if (isNumFound) {
            System.out.printf("Числото %d е в %d позиция", findThisNumPos, ++positionOfSearchedNum);
        } else {
            System.out.printf("Числото %d не е намерено", findThisNumPos);
        }
    }

    /**
     * Method that scrambles an array
     *
     */
    public static void arrayScramble(int arrSize, int[] mainArray) {
        Random randomNum = new Random();

        for (int i = 0; i < arrSize; i++) {

            int randomIndexToSwap = randomNum.nextInt(arrSize);
            int temp = mainArray[randomIndexToSwap];

            mainArray[randomIndexToSwap] = mainArray[i];
            mainArray[i] = temp;
        }
        for (int i = 0; i < arrSize; i++) {

            System.out.printf("%d, ", mainArray[i]);
        }
    }

    /**
     * Method that calculates the sum and the average of the numbers in the array
     */
    public static void sumAndAverageCalculator(int arrSize, int[] mainArray, int selection) {

        double sumOfTheNumsInArray = 0.00;
        double averageOfNumsInArray = 0.00;

        for (int i = 0; i < arrSize; i++) {

            sumOfTheNumsInArray += mainArray[i];
        }
        averageOfNumsInArray = sumOfTheNumsInArray / arrSize;

        if (selection == 5) {
            System.out.printf("Сбор: %.0f", sumOfTheNumsInArray);
        } else {
            System.out.printf("Средно-аритметично: %.2f", averageOfNumsInArray);
        }
    }

    /**
     * Method that finds the biggest and the smallest number from an Array
     */
    public static void smallestAndBiggestNumFinder(int arrSize, int[] mainArray, int selection) {
        int biggestNumInArray = Integer.MIN_VALUE;
        int smallestNumInArray = Integer.MAX_VALUE;

        for (int i = 0; i < arrSize; i++) {
            if (mainArray[i] > biggestNumInArray) {
                biggestNumInArray = mainArray[i];
            }
            if (mainArray[i] < smallestNumInArray) {
                smallestNumInArray = mainArray[i];
            }
        }
        if (selection == 6) {
            System.out.printf("Най-голямото число е: %d", biggestNumInArray);
        } else {
            System.out.printf("Най-малкото число е: %d", smallestNumInArray);
        }
    }

    /**
     * Method that checks if the array is symmetrical
     */
    public static void isArraySymmetrical(int arrSize, int[] mainArray) {

        boolean isArraySimetric = false;
        int arrSize2 = arrSize;

        if (arrSize % 2 == 0) {

            for (int i = 0; i < arrSize; i++) {
                if (mainArray[i] == mainArray[--arrSize]) {
                    isArraySimetric = true;
                } else {
                    isArraySimetric = false;
                    break;
                }
            }
        }
        if (isArraySimetric) {
            System.out.println("Масивът е симетричен");
        } else {
            System.out.println("Масивът не е симетричен");
        }
        for (int i = 0; i < arrSize2; i++) {
            System.out.printf("%d ", mainArray[i]);
        }
    }

    /**
     * Method for array reverting
     */
    public static void reversingArray(int arrSize, int[] mainArray) {

        for (int i = arrSize - 1; i >= 0; i--) {

            System.out.printf("%d, ", mainArray[i]);
        }
    }

    /**
     * Method for numbers displaying
     */
    public static void displayEnteredNums(int arrSize, int[] mainArray) {

        for (int i = 0; i < arrSize; i++) {

            System.out.printf("%d, ", mainArray[i]);
        }
    }

    /**
     * Method for usage check
     */
    public static boolean moreWork(boolean programUsage) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nЖелаете ли да затворите програмата?");
        System.out.println("Да/Не");

        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("Да")) {
            programUsage = false;
        }
        return programUsage;
    }

    /**
     * Method that displays options
     */
    public static void optionDisplayer() {

        System.out.println("\n1.Сортиране на въведените числа във възходящ ред");
        System.out.println("2.Сортиране на въведените числа в низходящ ред");
        System.out.println("3.Търсене на позиция на конкретно число");
        System.out.println("4.Разбъркване на числата");
        System.out.println("5.Изчисляване на сбора на всички числа");
        System.out.println("6.Намиране на най-голямото число");
        System.out.println("7.Намиране на най-малкото число");
        System.out.println("8.Намиране средно-аритметично на числата");
        System.out.println("9.Проверка за симетричност на масива от числа");//
        System.out.println("10.Обръщане на масива от числа");
        System.out.println("11.Визуализирай въведените числа");
        System.out.println("12.Изход");
    }

    /**
     * Method that gets the option's number that user wants to use
     *
     * @return Returns the number of selection
     */
    public static int selection() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nКоя опция желаете да използвате ?");

        int numOfselection = Integer.parseInt(scanner.nextLine());

        return numOfselection;
    }
}