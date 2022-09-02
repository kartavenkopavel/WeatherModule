package weatherModule;

import java.util.Scanner;

public class WeatherMain {
    // метод для обработки переменной day. Принимает аргумент String.
    public static void chooseTheNumberOfDay(String day) throws Exception{
        switch (day) {
            case "current":
                CurrentWeather.currentWeather();
                break;
            case "two":
                CurrentWeather.currentWeather();
                TomorrowWeather.tomorrowWeather();
                break;
            case "tomorrow":
                TomorrowWeather.tomorrowWeather();
                break;
        }
    }

    public static void main(String[] args)throws Exception {
        // ввод переменной для выбора на какой день отображать погоду. Выбор из 3-х параметров: current, tomorrow, two.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which the weather do you want to see: current, tomorrow or two days?");
        String day = scanner.next();
        // вызов метода обработки переменной day
        chooseTheNumberOfDay(day);
    }
}
