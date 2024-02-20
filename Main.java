import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int people = 0;
        while (true) {
            System.out.println("Введите число гостей");
            try {
                people = scanner.nextInt();
                if (people < 1){
                    System.out.println("Гостей должно быть больше 1");
                }
                else if (people == 1) {
                    System.out.println("Гость не может быть один");} else if (people > 1) {
                    break;}
            } catch (InputMismatchException exception) {
                System.out.println("`Введите целое число");
                scanner.next();
            }
            }
        System.out.println("Число гостей: " + people);
        }
        }

