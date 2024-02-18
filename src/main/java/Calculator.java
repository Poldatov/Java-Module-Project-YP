import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    private ArrayList<Products> productList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private double sum;
    private int peopleCount;
    private String template;

    public void calcStart() {
        while (!scanner.hasNextInt()) {
            System.out.println("Введите, пожалуйста число");
            scanner.next();
        }
        peopleCount = scanner.nextInt();
        while (true) {
            if (peopleCount == 1) {
                System.out.println("Все оплатить придется самому");
                break;
            }
            if (peopleCount > 1) {
                prodCount();
                break;
            }
            else {
                System.out.println("Вы ввели неправильное значение. Попробуйте снова!");
                while (!scanner.hasNextInt()) {
                    System.out.println("Введите, пожалуйста число");
                    scanner.next();
                }
                peopleCount = scanner.nextInt();
            }
        }
    }

    public void prodCount() {
        while (true) {

            System.out.println("Уточните название продукта: ");
            String name = scanner.next();

            System.out.println("Уточните стоимость продукта: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Введите, пожалуйста, число формате 1,45");
                scanner.next();
            }
            double price = scanner.nextDouble();
            while (price < 0) {
                System.out.println("Введите положительное число!");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Введите, пожалуйста, число формате 1,45");
                    scanner.next();
                }
                price = scanner.nextDouble();
            }
            Products productNew = new Products(name, price);
            productList.add(productNew);
            sum += productNew.price;

            template = "Продукт %s стоимостью %.2f %s добавлен в список." +
                    "\nОбщая сумма составляет: %.2f %s";
            System.out.println(String.format(template, productNew.name, productNew.price,
                    formatter(productNew.price), sum, formatter(sum)));

            System.out.println("\nЧтобы ввести новый товар введите любой символ.\n" +
                    "Чтобы закончить, введите 'Завершить'");

            if (scanner.next().equalsIgnoreCase("Завершить")) {
                finalSum();
                break;
            }
        }
    }

    public void finalSum(){

        System.out.println("\nДобавленные товары: ");
        for (Products product : productList) {
            template = "%s %.2f %s";
            System.out.println(String.format(template, product.name,
                    product.price, formatter(product.price)));
        }
        template = "Итоговая сумма: %.2f %s";
        System.out.println(String.format(template, sum, formatter(sum)));

        int name = peopleCount;
        double finalSum = sum / peopleCount;
        template = "Каждый должен оплатить %.2f %s";
        System.out.println(String.format(template, finalSum, formatter(finalSum)));
    }

    public String formatter (double number) {
        if ((number % 100) > 10 && (number % 100) < 20)
            return "рублей";

        else if ((number % 10) >= 5 && (number % 10) < 10)
            return "рублей";

        else if ((number % 10) >= 1 && (number % 10) < 2)
            return "рубль";

        else if ((number % 10) > 1 && (number % 10) < 5)
            return "рубля";

        else if ((number % 10) >= 0 && (number % 10) < 1)
            return "рублей";

        return null;
    }
}