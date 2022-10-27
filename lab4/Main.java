import java.util.Scanner;

public class Main {
    private static void printMenu() {
        System.out.print("""
                Выберите пункт и нажмите 'Enter'
                1 -- Подсчитать кол-во строчных и заглавных букв
                2 -- Выйти
                Ваш выбор:\s
                """);
    }

    private static String getStringInput() {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        return userInput.matches("[a-zA-Z']+") ? userInput : "";
    }

    private static int getCountOfLowercaseChars(String str) {
        Lowercase lowercase = new Lowercase();
        return lowercase.analyse(str);
    }

    private static int getCountOfUppercaseChars(String str) {
        Uppercase uppercase = new Uppercase();
        return uppercase.analyse(str);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userString;
        String command;

        do {
            printMenu();
            command = sc.nextLine();
            switch (command) {
                case "1" -> {
                    System.out.println("Введите строку:");
                    userString = getStringInput();
                    if (!userString.equals("")) {
                        System.out.printf("Количество строчных символов в строке - %d\nКоличество заглавных символов в строке - %d\n",
                                getCountOfLowercaseChars(userString), getCountOfUppercaseChars(userString));
                    } else {
                        System.out.println("В строке должны быть только символы латинского алфавита");
                    }
                }
                case "2" -> {
                }
                default -> System.out.println("Данного пункта нет в меню");
            }
        } while (!command.equals("2"));
    }
}