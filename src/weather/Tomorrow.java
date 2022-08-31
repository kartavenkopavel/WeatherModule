package weather;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import static weather.Weather.cityName;

public class Tomorrow {

    public static String[] tomorrowWeather() throws Exception {
        /* переменная units вынесена для того, что в дальнейшем можно сделать метод для
        отображения единиц измерения.
        */
        String units = "metric";
        String apiKey = "45d8535b361a7326ac202430c9bb89b3";
        String url = "https://api.openweathermap.org/data/2.5/forecast?q="
                +cityName()+"&units="+units+"&lang=en&appid="+apiKey+"&cnt=1";

        URL urls = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urls.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String fallout = response.toString().substring(response.indexOf(",\"main\":\"") , response.indexOf("\"icon\"")).replace(",", "\n");
        String temperature = response.toString().substring(response.indexOf("\"temp\""), response.indexOf("\"temp_min\"")).replace(",", "°C\n");

        return new String[]{fallout, temperature};


    }

}
