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
                //Параметр cnt может быть равным от 1 до 16. cnt=5 - отображает погоду на 12ч c интервалами по 3ч от текущей.
                .uri(URI.create("https://api.openweathermap.org/data/2.5/forecast?q="+cityName+"&units=metric&lang=en&appid=45d8535b361a7326ac202430c9bb89b3&cnt=5"))
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
        /*Для упрощения работы с json удаляем лишние данные из тела ответа и перезаписываем в новую переменую
            пока не получим данные о последнем временном интервале*/
        String subJson = json.substring(json.indexOf("},{"),json.indexOf("\"sunset\""));
        String subJson2 = subJson.substring(subJson.indexOf("\"},{"),subJson.indexOf("\"sunrise\""));
        String subJson3 = subJson2.substring(subJson2.indexOf("0\"},{"),subJson2.indexOf("zone\""));
        String subJson4 = subJson3.substring(subJson3.indexOf("00\"},{"),subJson3.indexOf("\"time"));
        String newJson = subJson4.substring(subJson4.indexOf("{"),subJson4.indexOf("],\"city\""));

        JSONObject obj = new JSONObject(newJson);//присвоение нового json в переменную типа JSONObject
        //парсинг переменной типа JSONObject
        String dateTime = obj.getString("dt_txt");
        int temp = obj.getJSONObject("main").getInt("temp");
        int feel = obj.getJSONObject("main").getInt("feels_like");
        int humidity = obj.getJSONObject("main").getInt("humidity");
        double windSpeed = obj.getJSONObject("wind").getDouble("speed");

        JSONArray weather = obj.getJSONArray("weather");
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
