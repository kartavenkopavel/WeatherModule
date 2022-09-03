package weather;
import java.util.Objects;
import java.util.Scanner;

import static weather.Current.currentWeather;
import  static weather.Tomorrow.tomorrowWeather;

public class Weather {

//    метод для определения города. Ввод подставляется в url метода currentWeather
    public static String cityName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your city: ");
        return scanner.next();
    }

    public static void forecastCondition(String day)throws Exception {
        if (Objects.equals(day, "current")){
            String[] cur = currentWeather();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nWeather on today:\n"+ cur[0]+"\n"+cur[1]
                    +"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        } else if (Objects.equals(day, "two")) {
            String[] cur = currentWeather();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nWeather on today:\n"+ cur[0]+"\n"+cur[1]
                    +"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("Enter a city for tomorrow's weather forecast");
            String[] tom = tomorrowWeather();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nWeather on tomorrow:"+ tom[0]+"\n"+tom[1]
                    +"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        } else{
            String[] tom = tomorrowWeather();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nWeather on tomorrow:\n"+ tom[0]+"\n"+tom[1]
                    +"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }
    }



    public static  void main(String[] args) throws Exception  {
        /*ввод данных для определения текущей погода или на завтрашний день.
        Можно ввести три значения: current, two, tomorrow.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which the weather forecast do you want to see: current, tomorrow or two days?");
        String day = scanner.next();

        forecastCondition(day);



    }
}
