import java.util.ArrayList;

public class HeatManager {

    private ArrayList<Integer> pwrs;

    public HeatManager() {
        this.pwrs = new ArrayList<>();
    }

    public ArrayList<Integer> get_Power() {
        return this.pwrs;
    }
}