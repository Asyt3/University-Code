public class Person {

    private HeatManager heatManager;
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String get_Name() {
        return name;
    }

    public void set_HeatManager(HeatManager heatManager) {
        this.heatManager = heatManager;
    }

    public HeatManager get_HeatManager() {
        return heatManager;
    }

    public Person(String name, Machine machine) {
        this.name = name;
    }

}