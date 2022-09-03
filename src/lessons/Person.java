package lessons;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {

    static int currentYear(){
        Calendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        return year;
    }

    public static void main(String[] args){

        int yob = 1990;
        int yob2 = 1993;

        System.out.println("Если человек родился в "+yob+
                " году, то его возраст - разница между " + currentYear() + " и "+yob);


        System.out.println("Если человек родился в "+yob2+
                " году, то его возраст 2 года назад - разница между "+(currentYear() - 2)+" и "+yob2);


    }
}
