public class Machine {

    private double power;
    private String colour;
    private double height;
    private Person person;
    private Engine engine;

    public Engine get_Engine() {
        return engine;
    }

    public Double get_Height() {
        return height;
    }

    public String get_Colour() {
        return colour;
    }

    public Machine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return String.format("Power: %d,Height: %d,Color: %s,Person: %s", this.power, this.height, this.colour,
                this.person.get_Name());
    }

}