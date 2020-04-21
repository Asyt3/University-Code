import java.util.Scanner;

public class ex2 {

    public static void main(String[] args) {
        
    
    Scanner in = new Scanner(System.in);

    System.out.println("Enter month: ");
    String month = in.nextLine();

    if(month.equalsIgnoreCase("January")){
        System.out.println("31 days");
    } else if (month.equalsIgnoreCase("February")){
        System.out.println("29 days");
    }
        else if(month.equalsIgnoreCase("March")){
        System.out.println("31 days");
    } else if (month.equalsIgnoreCase("April")){
        System.out.println("30 days");
    }
        else if(month.equalsIgnoreCase("May")){
        System.out.println("31 days");
    } else if (month.equalsIgnoreCase("June")){
        System.out.println("30 days");
    }
        else if(month.equalsIgnoreCase("August")){
        System.out.println("31 days");
    } else if (month.equalsIgnoreCase("September")){
        System.out.println("30 days");
    }
        else if(month.equalsIgnoreCase("October")){
        System.out.println("31 days");
    } else if (month.equalsIgnoreCase("November")){
        System.out.println("30 days");
    }
        else if (month.equalsIgnoreCase("December"))
        {
            System.out.println("31 days");
        }

        else {
            System.out.println("Wrong input");
        }
    }
}