package ward;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Weather {

    public static WeatherConditions weatherconditions;

    private String loadWeather(String url) {
        String charset = "UTF-8";
// Read in the weather Data
        try (InputStream connection = new URL(url).openStream()) {
            try (Scanner scanner = new Scanner(connection)) {
                String responseBody = new String(charset);
                responseBody = scanner.useDelimiter("\\A").next();
                System.out.println(responseBody);
                return(responseBody);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Weather(WeatherConditions wc){
        this.weatherconditions = wc;
    }

    public static void main(String[] args) throws Exception {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        String city ="Rexburg";
        WeatherConditions wc = new WeatherConditions();
    //input the desired city
        System.out.print("Enter the City you would like the weather in: ");
        city = br.readLine();
        System.out.println(city);

        while (!city.equals("stop")) {
            // build the url

            String url = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&apiKey=51e5addffa06f759b3e7f7c414050948";

            Weather weather = new Weather(wc);
            String dataString = weather.loadWeather(url);
            weather.parseData(dataString);
            System.out.print("\nEnter the City you would like the weather in: ");
            city = br.readLine();
  //          System.out.println(city);
        }

    }

    private void parseData(String dataString) {
//   Deserialize the weather string
                  Gson g = new Gson();
                  this.weatherconditions = g.fromJson(dataString, WeatherConditions.class);
                  this.weatherconditions.printInfo();
                  System.out.println(" ");

    }


}
