/*
 Вариант 2
 Входные данные: строка и величина сдвига(ключевое слово).
 Результат работы алгоритма: зашифрованная входная строка с помощью шифра Вижинера.
 */

import java.util.Scanner;

public class Main {

    /**
     * Метод выводит меню программы.
     */
    private static void printMenu() {
        System.out.print("""
                \nВыберите пункт и нажмите 'Enter'
                1 -- Введите строку
                2 -- Введите ключевое слово
                3 -- Вывести зашифрованную строку
                4 -- Выйти
                Ваш выбор:\s""");
    }

    /**
     * Метод проверяет является ли символ буквой английского алфавита.
     *
     * @param ch символ
     * @return возвращает true, если является буквой анг. алфавита, false в другом случае
     */
    private static boolean isEnglishLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z');
    }

    /**
     * Метод запрашивает у пользователя ввод строки для шифрования.
     *
     * @return возвращает строку для шифрования
     */
    private static String getInputMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку для шифрования:\s");
        return sc.nextLine();
    }

    /**
     * Метод запрашивает у пользователя ключевое слово.
     *
     * @return возвращает ключевое слово
     */
    private static String getInputKeyWord() {
        Scanner sc = new Scanner(System.in);
        String keyword;

        System.out.print("Введите ключевое слово:\s");
        keyword = sc.nextLine();

        for (char ch : keyword.toCharArray()) {
            if (!isEnglishLetter(ch)) {
                keyword = "";
                break;
            }
        }
        return keyword;
    }

    /**
     * Метод реализует шифрование исходной строки с помощью шифра Виженера.
     *
     * @param message исходная строка
     * @param keyword ключевое слово, которое задает велечину сдвига
     * @return возвращает зашифрованную исходную строку
     */
    private static String cipherMessage(String message, String keyword) {
        StringBuilder cipherMessage = new StringBuilder();
        int newAlphabetPosition;

        for (int i = 0, j = 0; i < message.length(); i++) {
            if (j == keyword.length()) {
                j = 0;
            }
            if (isEnglishLetter(message.charAt(i))) {
                newAlphabetPosition = ((Character.toLowerCase(message.charAt(i)) + Character.toLowerCase(keyword.charAt(j)) - 2 * 'a') % 26) + 'a';
                if (Character.isUpperCase(message.charAt(i))) {
                    cipherMessage.append(Character.toUpperCase((char) newAlphabetPosition));
                } else {
                    cipherMessage.append((char) newAlphabetPosition);
                }
                j++;
            } else {
                cipherMessage.append(message.charAt(i));
            }
        }
        return cipherMessage.toString();
    }

    /**
     * Основной метод программы который выводит меню и реализует его пункты.
     *
     * @param args массив строк
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command;
        String message = "";
        String keyword = "";

        do {
            printMenu();
            command = sc.nextLine();

            switch (command) {
                case "1" -> {
                    message = getInputMessage();
                    if (!message.isEmpty()) {
                        System.out.println("Строка успешно введена!");
                    } else {
                        System.out.println("Строка не может быть пустой!");
                    }
                }
                case "2" -> {
                    keyword = getInputKeyWord();
                    if (!keyword.isEmpty()) {
                        System.out.println("Ключевое слово успешно введено!");
                    } else {
                        System.out.println("Ключевое слово не может быть пустым и должно содержать только буквы английского алфавита!");
                    }
                }
                case "3" -> {
                    if (!message.isEmpty() && !keyword.isEmpty()) {
                        System.out.println("Исходная строка: " + message + "\nКлючевое слово: " + keyword + "\nЗашифрованное сообщение: " + cipherMessage(message, keyword));
                    } else {
                        System.out.println("Строка или ключевое слово не введено!");
                    }
                }
                case "4" -> System.out.println("Завершение работы программы...");

                default -> System.out.println("Данного пункта нет в меню!");
            }
        } while (!command.equals("4"));
    }
}
