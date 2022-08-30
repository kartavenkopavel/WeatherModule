package lessons;

public class Teacher {
    public static void litTeacher(){
        String firstName = "Maria";
        String middleName = "Ivanovna";
        String lastname = "Petrova";
        int age = 35;
        String subject = "Russian Literature";

        System.out.println("================================");
        System.out.println(
                "First name:\t " + firstName +
                        "\nMiddle name: " + middleName +
                        "\nLast name:\t " + lastname +
                        "\nAge:\t\t " + age + " y.o." +
                        "\nSubject:\t " + subject );
        System.out.println("================================");
    }

    public static void mathTeacher(){
        String firstName = "Ivan";
        String middleName = "Petrovich";
        String lastname = "Serebyakov";
        int age = 55;
        String subject = "Mathematics";

        System.out.println("================================");
        System.out.println(
                "First name:\t " + firstName +
                        "\nMiddle name: " + middleName +
                        "\nLast name:\t " + lastname +
                        "\nAge:\t\t " + age + " y.o." +
                        "\nSubject:\t " + subject );
        System.out.println("================================");
    }

    public static void main(String[] args){

    litTeacher();
    mathTeacher();



    }
}
