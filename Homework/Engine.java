public class Engine {

    private int pwr;

    public Engine(int pwr) {
        this.pwr = pwr;
    }

    int get_Power() {
        return pwr;
    }

    public String toString() {
        return String.format("Power:%d", this.get_Power());
    }

}