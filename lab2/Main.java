/*
 Вариант 17
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    /**
     * Выводит меню программы.
     */
    private static void printMenu() {

        System.out.print("""
                \nВыберите пункт и нажмите 'Enter'
                1 -- Добавить пустой объект напитка
                2 -- Добавить объект напитка с параметрами.
                3 -- Редактировать напиток.
                4 -- Сортировать напитки.
                5 -- Вывести все напитки.
                6 -- Выйти.
                Ваш выбор:\s""");
    }

    /**
     * Выводит меню редактирования.
     */
    private static void printEditMenu() {

        System.out.print("""
                \nВыберите пункт и нажмите 'Enter'
                1 -- Изменить название напитка.
                2 -- Изменить описание напитка.
                3 -- Изменить объем напитка.
                4 -- Изменить цену напитка.
                5 -- Отмена.
                Ваш выбор:\s""");
    }

    /**
     * Выводит меню сортировки.
     */
    private static void printSortMenu() {

        System.out.print("""
                \nВыберите пункт и нажмите 'Enter'
                1 -- Сортировать по названию напитка.
                2 -- Сортировать по описанию напитка.
                3 -- Сортировать по объему напитка.
                4 -- Сортировать по цене напитика
                5 -- Отмена.
                Ваш выбор:\s""");
    }

    /**
     * Запрашивает у пользователя ввод строки.
     *
     * @return введенная строка
     */
    private static String getStringInput() {

        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        while (userInput.isEmpty()) {
            System.out.println("Ввод не может быть пустым! Повторите попытку:");
            userInput = sc.nextLine();
        }
        return userInput;
    }

    /**
     * Запрашивает у пользователя целое число.
     *
     * @return целое число
     */
    private static int getIntInput() {

        Scanner sc = new Scanner(System.in);
        int userInput;
        boolean errorDisplay = false;

        do {
            if (errorDisplay) {
                System.out.println("Число должно быть положительным! Повторите попытку:");
            }
            while (!sc.hasNextInt()) {
                System.out.println("Ошибка ввода! Повторите попытку:");
                sc.next();
            }
            userInput = sc.nextInt();
            errorDisplay = true;
        } while (userInput < 0);
        return userInput;
    }

    /**
     * Создает объект с пользовательскими данными.
     *
     * @return объект с пользовательскими данными
     */
    private static Drink getNewDrink() {

        System.out.println("Введите название напитка:");
        String name = getStringInput();

        System.out.println("Введите описание напитка:");
        String description = getStringInput();

        System.out.println("Введите объем напитка в милилитрах:");
        int volume = getIntInput();

        while (volume == 0) {
            System.out.println("Объем напитка не может быть равен 0. Повторите попытку:");
            volume = getIntInput();
        }

        System.out.println("Введите цену напитка:");
        int price = getIntInput();

        return new Drink(name, description, volume, price);
    }

    /**
     * Редактирует поля объекта.
     *
     * @param drinkArrayList список объектов
     */
    private static void editingDrink(ArrayList<Drink> drinkArrayList) {

        int numberToEdit;
        String command;

        printAllDrinks(drinkArrayList);
        System.out.println("Выберите объект, который Вы хотите изменить:");
        numberToEdit = getIntInput();

        if (numberToEdit > drinkArrayList.size() - 1) {
            System.out.println("Ошибка ввода! Введен некоректный номер объекта.");
            return;
        }
        System.out.println(drinkArrayList.size());

        do {
            printEditMenu();
            command = getStringInput();
            switch (command) {
                case "1" -> {
                    System.out.println("Введите название напитка:");
                    String newName = getStringInput();

                    drinkArrayList.get(numberToEdit).setName(newName);
                    System.out.println("Новое название напитка установлено!");
                }
                case "2" -> {
                    System.out.println("Введите описание напитка:");
                    String newDescription = getStringInput();

                    drinkArrayList.get(numberToEdit).setDescription(newDescription);
                    System.out.println("Новое описание напитка установлено!");
                }
                case "3" -> {
                    System.out.println("Введите объем напитка в милилитрах:");
                    int newVolume = getIntInput();

                    while (newVolume == 0) {
                        System.out.println("Объем напитка не может быть равен 0. Повторите попытку:");
                        newVolume = getIntInput();
                    }

                    drinkArrayList.get(numberToEdit).setVolume(newVolume);
                    System.out.println("Новый объем напитка установлен!");
                }
                case "4" -> {
                    System.out.println("Введите цену напитка:");
                    int newPrice = getIntInput();

                    drinkArrayList.get(numberToEdit).setPrice(newPrice);
                    System.out.println("Новая цена напитка установлена!!");
                }
                case "5" -> {
                }
                default -> System.out.println("Данного пункта нет в меню!");
            }
        } while (!command.equals("5"));
    }

    /**
     * Выводит все объекты массива.
     *
     * @param drinkArrayList массив объектов.
     */
    private static void printAllDrinks(ArrayList<Drink> drinkArrayList) {

        int num = 0;
        for (Drink drink : drinkArrayList) {
            System.out.printf("#%d %s", num, drink);
            num++;
        }
    }


    /**
     * Сортирует объекты по указанному полю.
     *
     * @param drinkArrayList массив объектов
     */
    private static void sortingDrinks(ArrayList<Drink> drinkArrayList) {

        printSortMenu();
        String command = getStringInput();

        switch (command) {
            case "1" -> {
                Comparator<Drink> nameComparator = Comparator.comparing(Drink::getName);
                drinkArrayList.sort(nameComparator);
            }
            case "2" -> {
                Comparator<Drink> descriptionComparator = Comparator.comparing(Drink::getDescription);
                drinkArrayList.sort(descriptionComparator);
            }
            case "3" -> {
                Comparator<Drink> volumeComparator = Comparator.comparing(Drink::getVolume);
                drinkArrayList.sort(volumeComparator);
            }
            case "4" -> {
                Comparator<Drink> priceComparator = Comparator.comparing(Drink::getPrice);
                drinkArrayList.sort(priceComparator);
            }
            case "5" -> {
            }
            default -> System.out.println("Данного пункта нет в меню!");
        }
        printAllDrinks(drinkArrayList);
    }

    /**
     * Основной метод программы который выводит меню и реализует его пункты.
     *
     * @param args массив строк
     */
    public static void main(String[] args) {

        ArrayList<Drink> drinksArrayList = new ArrayList<>();
        String command;

        do {
            printMenu();
            command = getStringInput();
            switch (command) {
                case "1" -> {
                    drinksArrayList.add(new Drink());
                    System.out.println("Пустой объект 'Напиток' успешно добавлен!");
                }
                case "2" -> {
                    drinksArrayList.add(getNewDrink());
                    System.out.println("Объект 'Напиток' с пользовательскими данными успешно добавлен!");
                }
                case "3" -> {
                    if (!drinksArrayList.isEmpty()) {
                        editingDrink(drinksArrayList);
                    } else {
                        System.out.println("Массив объектов пуст!");
                    }
                }
                case "4" -> {
                    if (!drinksArrayList.isEmpty()) {
                        sortingDrinks(drinksArrayList);
                    } else {
                        System.out.println("Массив объектов пуст!");
                    }
                }
                case "5" -> {
                    if (!drinksArrayList.isEmpty()) {
                        printAllDrinks(drinksArrayList);
                    } else {
                        System.out.println("Массив объектов пуст!");
                    }
                }
                case "6" -> System.out.println("Завершение работы программы...");
                default -> System.out.println("Данного пункта нет в меню!");
            }
        } while (!command.equals("6"));
    }
}
