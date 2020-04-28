import java.util.Random;
import java.util.Scanner;

public class MiceDestroyer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int hitCapacity = 4;
        int robotBatteryCharge = 100;

        for (int hitCounter = 1; hitCounter <= hitCapacity; hitCounter++) {
            robotBatteryCharge -= 25;

            // 1.Navigation of the Killer Robot / robotMove()
            System.out.println("What is in front of the Mice Destroyer?");

            String obstacle = scanner.nextLine();
            String movement = robotMove(obstacle);

            System.out.printf("Mice Destroyer moves -> %s\n", movement);

            // 2.Is the mouse in front of the Killer Robot
            System.out.println("How many pixels are in front of the Mice Destroyer?");

            for (int isMouseInFront = 0; isMouseInFront < 1;) {
                int pixels = Integer.parseInt(scanner.nextLine());

                if (pixels % 2 == 0) {
                    isMouseInFront++;
                    System.out.println("Mouse is in sight of the Mice Destroyer!");
                } else {
                    System.out.println("Input pixels again: ");
                }
            }

            // 2.To what Killer Robot did damage ? / isMouseHit()
            System.out.printf("%15s %d", "Hit №", hitCounter);

            boolean isMouseHit = isMouseHit();

            if (isMouseHit) {
                System.out.println("\nMouse has been destroyed!");
                System.out.println("Search for another target.\n");
            } else {
                System.out.println("Furniture has been obliterated!");
                System.out.println("Search for another target.");
            }

            System.out.printf("Battery Charge: %d%%\n", robotBatteryCharge);

            // 4. Communication with the owner / Communication()
            if (hitCounter % 2 != 0) {
                Communication();
            }
        }

        // 3.Is the Killer Robot charging himself ? / isPowerOn
        System.out.println("*Please recharge the Mice Destroyer*");

        boolean isTherePower = isPowerOn();

        if (isTherePower) {
            System.out.println("We have Power! Let there be LIGHT!");
        } else {
            System.out.println("Sadly, there's no Power on.");
        }
    }

    public static String robotMove(String obstacle) {
        String movement;

        if (obstacle.equalsIgnoreCase("Wall")) {
            movement = "Go Sideways";
        } else if (obstacle.equalsIgnoreCase("Chair")) {
            movement = "Jump";
        } else if (obstacle.equalsIgnoreCase("Nothing")) {
            movement = "Forward";
        } else {
            movement = "The object isn't an obstacle anymore";
        }
        return movement;
    }

    public static boolean isMouseHit() {
        boolean isMouseHit = true;

        Random hitRNG = new Random();
        int hitNum = hitRNG.nextInt(10) + 1;

        if (hitNum == 5) {
            isMouseHit = false;
        }
        return isMouseHit;
    }

    public static void Communication() {

        System.out.println("*Mice Destroyer is searching for it's Master*");

        for (int robotCountingNums = 10; robotCountingNums >= 1; robotCountingNums--) {
            if (robotCountingNums % 2 == 0) {
                System.out.printf("I am a Robottttt %s\n", robotCountingNums);
            }
        }
    }

    public static boolean isPowerOn() {
        boolean isPowerOn = false;

        for (int checker = 0; checker < 1;) {

            Random chargeRNG = new Random();
            int firstChargeRNG = chargeRNG.nextInt(1000) + 1;
            int secondChargeRNG = chargeRNG.nextInt(1000) + 1;

            if (firstChargeRNG > secondChargeRNG) {
                isPowerOn = true;
                checker++;
            } else if (secondChargeRNG > firstChargeRNG) {
                isPowerOn = false;
                checker++;
            }
        }
        return isPowerOn;
    }
}