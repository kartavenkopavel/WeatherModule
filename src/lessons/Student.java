package lessons;

public class Student {

    static void firstStudent(){

        String firstName = "Vova";
        String lastname = "Sidorov";
        int age = 10;
        int classNumber = 5;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(
                "First name:\t\t" + firstName +
                        "\nLast name:\t\t" + lastname +
                        "\nAge:\t\t\t" + age + " y.o." +
                        "\nClass number:\t" + classNumber );
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    static void secondStudent(){

        String firstName = "Masha";
        String lastname = "Semnova";
        int age = 14;
        int classNumber = 9;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(
                "First name:\t\t" + firstName +
                        "\nLast name:\t\t" + lastname +
                        "\nAge:\t\t\t" + age + " y.o." +
                        "\nClass number:\t" + classNumber );
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    public static void main(String[] args){
     firstStudent();
     secondStudent();


    }

}
