package ward;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

public class WeatherConditions {
    private int id;
    private String name;
    @SerializedName("main")
    private HashMap<String, Float> measurements = new HashMap<String,Float>();

    public WeatherConditions() {
        this.id = 0;
        this.name = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Float> getMain() {
        return measurements;
    }

    public void setMain(HashMap<String, Float> main) {
        this.measurements = measurements;
    }

    public void printInfo(){
        System.out.print(this.id);
        System.out.print(this.name);
        System.out.print(this.measurements.get("temp"));
    }
}
