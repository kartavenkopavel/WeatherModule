package weatherModule;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
//класс для отправки запроса о погоде на завтра
public class TomorrowWeather {
    private String sendGet() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any city: ");
        String cityName = scanner.next();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                //Параметр cnt может быть равным от 1 до 16. cnt=8 - отображает погоду через 24ч c интервалами по 3ч от текущей.
                .uri(URI.create("https://api.openweathermap.org/data/2.5/forecast?q="+cityName+
                        "&units=metric&lang=en&appid=45d8535b361a7326ac202430c9bb89b3&cnt=8"))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public static void tomorrowWeather() throws Exception {

        TomorrowWeather object = new TomorrowWeather();//объявление экземпляра класса

        String json = object.sendGet();//запись ответа в переменную типа String

        JSONObject obj = new JSONObject(json);
        JSONArray list = obj.getJSONArray("list");//в body list содержит массив из json
        JSONObject newJson = list.optJSONObject(7);//последний элемент массива записываем в новую переменную

        //парсинг переменной типа JSONObject
        String dateTime = newJson.getString("dt_txt");
        int temp = newJson.getJSONObject("main").getInt("temp");
        int feel = newJson.getJSONObject("main").getInt("feels_like");
        int humidity = newJson.getJSONObject("main").getInt("humidity");
        double windSpeed = newJson.getJSONObject("wind").getDouble("speed");

        JSONArray weather = newJson.getJSONArray("weather");
        for (int i = 0; i < weather.length(); i++) {
            String main = weather.getJSONObject(i).getString("main");
            String description = weather.getJSONObject(i).getString("description");
            //вывод в консоль таблицы с переменными из JSONObject obj
            System.out.println("--------------------------------------------------\n"
                    +dateTime+" \uD83D\uDDD3\nWEATHER ➢  "+main+", "+description+
                    "\n\nTEMPERATURE \uD83C\uDF21 "+temp+"°C\t\tHUMIDITY \uD83D\uDCA7 "+humidity+"%"+
                    "\nFEELS LIKE  \uD83C\uDF21 "+feel+"°C\t\tWIND     \uD83C\uDF2C "+windSpeed+"m/s" +
                    "\n--------------------------------------------------");
        }
    }

}
