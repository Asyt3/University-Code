import java.util.Scanner;

public class AdministrationV2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Задавене на променливи
        int arrNumSize;
        int arrSize;
        String[] arr;
        int[] arrNum;
        boolean prime = true;
        int option;
        int selection;
        String reverse = "";

        // Изкарва менюто за селектиране
        System.out.println("\n1.Работа с числа");
        System.out.println("2.Работа с думи");
        System.out.println("3.Изход от програмата");

        System.out.println("Choose option");
        option = Integer.parseInt(scanner.nextLine());

        if (option == 1) {

            // Ако се избере тази опция изкарва простите числа
            System.out.println("\n1.Prime numbers ");

            selection = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter numbers");
            arrNumSize = Integer.parseInt(scanner.nextLine());

            arrNum = new int[arrNumSize];

            for (int i = 0; i < arrNumSize;) {

                System.out.println("Enter a number: ");
                arrNum[i] = Integer.parseInt(scanner.nextLine());

                if (arrNum[i] > 10000 && arrNum[i] < 0)
                    System.out.println("Wrong entry!");
                else
                    i++;
            }

            // Прости числа
            if (selection == 1) {

                for (int i = 0; i <= arrNumSize - 1; i++) {

                    for (int p = 2; p < Math.sqrt(arrNum[i]); i++) {
                        if (arrNum[i] % p == 0) {
                            prime = false;
                            break;
                        }
                        if (prime) {
                            System.out.println(arrNum[i] + " is prime");
                        }
                    }
                }
            }
            // Ако се селектира от менюто опция 2, работим с думи
        } else if (option == 2) {

            // Извежда се меню
            System.out.println("\n1.Reverse ");
            System.out.println("2.Work in Progress");
            System.out.println("3.Length");

            selection = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter number of words");
            arrSize = scanner.nextInt();
            arr = new String[arrSize];
            for (int i = 0; i < arrSize;) {

                System.out.println("Enter a word: ");
                arr[i] = scanner.nextLine();

                if (arr[i].length() > 20)
                    System.out.println("Wrong entry!");
                else
                    i++;
            }
            // Ако се селектира опция 3, извежда броя на думите
            if (selection == 3) {
                for (int i = 0; i < arrSize; i++) {

                    System.out.printf("%s -%d Count: ", arr[i], arr[i].length());
                }
            }
            // Ако се селекитра опция 1, String се обръща
            else if (selection == 1) {

                for (int s = 0; s < arrSize; s++) {

                    for (int i = arr[s].length() - 1; i >= 0; i--) {
                        reverse = reverse + arr[s].charAt(i);
                    }
                    arr[s] = reverse;
                    System.out.println("Reversed string is:");
                    System.out.println(reverse);
                }
            }
            // действие при излизане от програмата
        } else if (option == 3) {
            System.out.println("You've exited the program.");
        }
    }
}