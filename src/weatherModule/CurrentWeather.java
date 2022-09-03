package weatherModule;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
//класс для отправки запроса о текущей погоде
public class CurrentWeather {
    // метод ввода переменной для выбора города
    public String getCityName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any city: ");
        return  scanner.next();
    }
    //метод для формирования, отправки GET запроса к API и получение ответа
    private String sendGet(String cityName) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.openweathermap.org/data/2.5/weather?q="+cityName+
                        "&units=metric&lang=en&appid=45d8535b361a7326ac202430c9bb89b3"))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
    public static void currentWeather() throws Exception {

        CurrentWeather object = new CurrentWeather(); //объявление экземпляра класса

        String json = object.sendGet(object.getCityName()); //запись ответа в переменную типа String
        JSONObject obj = new JSONObject(json); //объявление переменной типа JSONObject с аргументом типа String

        //парсинг переменной типа JSONObject
        String cityName = obj.getString("name");
        String countryCode = obj.getJSONObject("sys").getString("country");

        int temp = obj.getJSONObject("main").getInt("temp");
        int feel = obj.getJSONObject("main").getInt("feels_like");
        int humidity = obj.getJSONObject("main").getInt("humidity");
        double windSpeed = obj.getJSONObject("wind").getDouble("speed");

        JSONArray weather = obj.getJSONArray("weather");
        for (int i = 0; i < weather.length();i++) {
            String main = weather.getJSONObject(i).getString("main");
            String description = weather.getJSONObject(i).getString("description");
            //вывод в консоль таблицы с переменными из JSONObject obj
            System.out.println("--------------------------------------------------\n"
                    +cityName+", "+countryCode+" \uD83C\uDF0F\nWEATHER ➢  "+main+", "+description+
                    "\n\nTEMPERATURE \uD83C\uDF21 "+temp+"°C\t\tHUMIDITY \uD83D\uDCA7 "+humidity+"%"+
                    "\nFEELS LIKE  \uD83C\uDF21 "+feel+"°C\t\tWIND     \uD83C\uDF2C "+windSpeed+"m/s" +
                    "\n--------------------------------------------------");
        }

    }

}
