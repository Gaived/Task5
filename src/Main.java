import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

public class Main {

    private static void allP(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i));
        }
    }

    private static void addP(List<String> list, Scanner scanner) {
        String input = scanner.nextLine();
        list.add(input);
    }

    private static void removeP(List<String> list, Scanner scanner) {
        allP(list);
        try {
            int input = scanner.nextInt();
            System.out.println("Покупка " + list.get(input-1) + " удалена, список покупок");
            list.remove(input-1);
            if (list.size() == 0) {
                System.out.println("Список покупок пуст");
            }
            scanner.nextLine();
        } catch (InputMismatchException exception) {
            String input = scanner.nextLine();
            System.out.println("Продукт '" + input + "' удален, список покупок");
            list.remove(input);
            if (list.size() == 0) {
                System.out.println("Список покупок пуст");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Показать список покупок");
            System.out.println("2. Добавить товар в спсок");
            System.out.println("3. Удбрать товар из списка");

            String input = scanner.nextLine();


            switch (input) {

                case "1":
                    System.out.println("Список покупок: ");
                    allP(list);
                    break;
                case "2":
                    System.out.println("Введите название товара для покупки: ");
                    addP(list, scanner);
                    break;
                case "3":
                    System.out.println("Введите номер или название товара, который убрать из списка: ");
                    removeP(list, scanner);
                    break;
                default:
                    System.out.println();
                    System.out.println("Такой операции нет");
                    System.out.println();
            }
        }
    }
}
