import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        System.out.println("Worker count= ");
        int countOfPeople = scanner.nextInt();

        for (int i = 0; i < countOfPeople; i++) {

            System.out.println("Heat Engine Power =  ");
            int heatEnginePower = scanner.nextInt();
            System.out.println("Wrapper Engine power = ");
            int wrapperEnginePower = scanner.nextInt();
            System.out.println("Production Engine power =  ");
            int productionEnginePower = scanner.nextInt();

            ProductionEngine productionEngine = new ProductionEngine(productionEnginePower);
            WrapperEngine wrapperEngine = new WrapperEngine(wrapperEnginePower);

            scanner.nextLine();
            System.out.print("Worker's name: ");
            String name = scanner.nextLine();
            Person person = new Person(name);

            HeatManager heatManager = new HeatManager();
            heatManager.get_Power().add(heatEnginePower);
            heatManager.get_Power().add(productionEnginePower);
            heatManager.get_Power().add(wrapperEnginePower);
            person.set_HeatManager(heatManager);

            people.add(person);
        }
    }
}