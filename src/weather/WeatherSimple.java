package weather;

public class WeatherSimple {

    public static void main(String[] args) {

        String cityName = "London";
        String countryCode = "GB";
        String currentDate = "Wen,Aug 31";
        String tomorrowDate = "Thu,Sep 01";
        String currentFallout = "Scattered clouds. Moderate breeze.";
        String tomorrowFallout = "Overcast clouds. Moderate breeze.";
        int currentMaxTemp = 23;
        int currentMinTemp = 15;
        int tomorrowMaxTemp = 23;
        int tomorrowMinTemp = 17;

        System.out.println(cityName+", "+countryCode +"\n-------------------------------------------------------\n"+
                currentDate+"\n-------------------------------------------------------\n"+
                "\u26C5\u26C5\t" + currentFallout + "\n   \t\tThe high will be "+currentMaxTemp+"°C, the low will be "+currentMinTemp+"°C"+
                "\n\n\t\t\t  Morning\tAfternoon\tEvening\t Night\nTEMPERATURE\t\t15°C\t  22°C\t\t21°C\t  17°C\n" +
                "FEELS LIKE\t\t15°C\t  22°C\t\t20°C\t  16°C\n-------------------------------------------------------");
        System.out.println(tomorrowDate+"\n-------------------------------------------------------\n"+
                "\u2601\u2601\t" + tomorrowFallout + "\n   \t\tThe high will be "+tomorrowMaxTemp+"°C, the low will be "+tomorrowMinTemp+"°C"+
                "\n\n\t\t\t  Morning\tAfternoon\tEvening\t Night\nTEMPERATURE\t\t17°C\t  23°C\t\t21°C\t  18°C\n" +
                "FEELS LIKE\t\t17°C\t  23°C\t\t21°C\t  18°C\n-------------------------------------------------------");
    }
}
