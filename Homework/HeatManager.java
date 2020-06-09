import java.util.ArrayList;
import java.util.List;

public class HeatManager {

    private List<Engine> wrapperEngines;
    private List<Engine> heatEngines;
    private int id;
    private int count = 1;

    public HeatManager(List<Engine> heatEngines, List<Engine> wrapperEngines) {
        this.id = count++;
        this.heatEngines = heatEngines;
        this.wrapperEngines = wrapperEngines;
    }
}