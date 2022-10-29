/*
 Вариант 7

 Необходимо описать интерфейс, содержащий одну функцию
 int analyse(String str);

 Данный интерфейс производит анализ строки по интересующему критерию.
 Необходимо реализовать два класса для этого интерфейса.
 Первый класс должен возвращать количество строчных символов в строке,
 а второй − возвращать количество заглавных символов в строке.
 Необходимо, чтобы приложение запросило у пользователя строку и
 выдало результаты вычисления для обоих классов.
 В строке должны быть только символы латинского алфавита, символов кириллицы быть не должно.
 */

import java.util.Scanner;

public class Main {
    /**
     * Выводит меню программы.
     */
    private static void printMenu() {
        System.out.println("Выберите пункт и нажмите 'Enter'");
        System.out.println("1. Подсчитать кол-во строчных и заглавных букв");
        System.out.println("2. Выйти");
        System.out.println("Ваш выбор:");
    }

    /**
     * Запрашивает у пользователя ввод строки.
     *
     * @return строка введенная пользователем
     */
    private static String getStringInput() {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        return userInput.matches("[a-zA-Z\s]+") ? userInput : "";
    }

    /**
     * Подсчитывает кол-во сточных букв в строке.
     *
     * @param str исходная строка
     * @return кол-во строчных букв
     */
    private static int getCountOfLowercaseChars(String str) {
        LowerCase lowercase = new LowerCase();
        return lowercase.analyse(str);
    }


    /**
     * Подсчитывает кол-во заглавных букв в строке.
     *
     * @param str исходная строка
     * @return кол-во заглавных букв
     */
    private static int getCountOfUppercaseChars(String str) {
        UpperCase uppercase = new UpperCase();
        return uppercase.analyse(str);
    }

    /**
     * Основной метод программы который выводит меню и реализует его пункты.
     *
     * @param args массив строк
     */
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
                    if (!userString.trim().isEmpty()) {
                        System.out.printf("Кол-во строчных букв в строке %d\n", getCountOfLowercaseChars(userString));
                        System.out.printf("Кол-во заглавных букв в строке %d\n", getCountOfUppercaseChars(userString));
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
