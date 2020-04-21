import java.util.*;

public class ex1{
      static int a;
      static int b;

    public static void main(String[] args) {
        Perimeter();
        Area();

    }

    public static void Perimeter(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a for Perimeter: ");
        a = in.nextInt();
        System.out.println("Enter b: ");
        b = in.nextInt();
        int perimeter = (a + b)*2;
        System.out.println("Perimeter is " + perimeter);
    }
    public static void Area() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a for Area: ");
        a = in.nextInt();
        System.out.println("Enter b: ");
        b = in.nextInt();
        int area = a*b;
        System.out.println("Area is " + area);
    }
}