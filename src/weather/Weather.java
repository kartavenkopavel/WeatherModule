package weather;
import java.util.Objects;
import java.util.Scanner;

import static weather.Current.currentWeather;

public class Weather {

//    метод для определения города. Ввод подставляется в url метода currentWeather
    public static String cityName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your city: ");
        return scanner.next();
    }



    public static  void main(String[] args) throws Exception  {
        /*ввод данных для определения текущей погода или на завтрашний день.
        Можно ввести три значения: current, current and tomorrow, tomorrow.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which weather forecast you want to see: current or tomorrow?");
        String day = scanner.next();

        if (Objects.equals(day, "current")){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n" +
                    "Current weather in the city:\n"+ currentWeather()+
                    "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        } else if (Objects.equals(day, "current and tomorrow")) {

            currentWeather();
        } else{
            System.out.println("Sorry, forecast for tomorrow is temporarily unavailable");
        }



    }
}
