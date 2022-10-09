/*
 Вариант 17
 Сооружение, дом, гараж, квартира.
 Необходимо выстроить иерархию наследования.
 В каждом классе (базовом и производных) должно быть  не менее одного числового и одного строкового поля.
 При вводе числовых параметров обязательна проверка на число и на диапазон.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Выводит меню программы.
     */
    private static void printMenu() {
        System.out.print("""
                \nВыберите пункт и нажмите 'Enter'.
                1 -- Добавить новый объект с параметрами.
                2 -- Добавить новый объект без параметров.
                3 -- Удалить объект по индексу.
                4 -- Вывод всех объектов.
                5 -- Сравнение двух объектов на равенство (по индексам).
                6 -- Выход.
                Ваш выбор:\s""");
    }

    /**
     * Выводит меню добавления сооружений.
     */
    private static void printConstructionMenu() {
        System.out.print("""
                \nВыберите пункт и нажмите 'Enter'.
                1 -- Добавить обычное сооружение.
                2 -- Добавить дом.
                3 -- Добавить гараж.
                4 -- Добавить квартиру.
                5 -- Отмена.
                Ваш выбор:\s
                """);
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
     * Запрашивает пользовательский ввод целого числа в заданном диапазоне.
     *
     * @param lowerLimit нижний предел
     * @param upperLimit верхний предел
     * @return целое число в заданном диапазоне
     */
    private static int getIntInputInRange(int lowerLimit, int upperLimit) {
        Scanner sc = new Scanner(System.in);
        int userInput;
        boolean errorDisplay = false;

        do {
            if (errorDisplay) {
                System.out.printf("Вы ввели число не в заданном диапазоне! Введите число от %d до %d :", lowerLimit, upperLimit);
            }
            while (!sc.hasNextInt()) {
                System.out.println("Вы ввели не число! Повторите попытку:");
                sc.next();
            }
            userInput = sc.nextInt();
            errorDisplay = true;
        } while (!(userInput >= lowerLimit) || !(userInput <= upperLimit));

        return userInput;
    }

    /**
     * Выводит все объекты массива.
     *
     * @param constructionArrayList массив объектов.
     */
    private static void printAllConstruction(ArrayList<Construction> constructionArrayList) {
        int num = 0;
        for (Construction construction : constructionArrayList) {
            System.out.printf("#%d %s", num, construction);
            num++;
        }
    }

    /**
     * Удаляет элемент массива выбранный пользователем.
     *
     * @param constructionArrayList массив объектов.
     */
    private static void deleteConstruction(ArrayList<Construction> constructionArrayList) {
        printAllConstruction(constructionArrayList);
        System.out.println("Введите номер сооружения, которое хотите удалить:");
        int numToDelete = getIntInputInRange(0, constructionArrayList.size() - 1);
        constructionArrayList.remove(numToDelete);
    }

    /**
     * Создает новый объект сооружения с параметрами
     *
     * @return объект сооружения с параметрами
     */
    private static Construction createConstruction() {
        System.out.println("Введите название сооружения:");
        String name = getStringInput();

        System.out.println("Введите площадь сооружения:");
        int square = getIntInputInRange(1, 10000);

        return new Construction(name, square);
    }

    /**
     * Создает новый объект квартры с параметрами
     *
     * @return объект квартиры с параметрами
     */
    private static Construction createFlat() {
        System.out.println("Введите название сооружения:");
        String name = getStringInput();

        System.out.println("Введите площадь квартиры:");
        int square = getIntInputInRange(1, 10000);

        System.out.println("Введите кол-во комнат в квартире:");
        int numOfRooms = getIntInputInRange(1, 100);

        System.out.println("Введите тип ремонта в квартире:");
        String typeRepair = getStringInput();

        return new Flat(name, square, numOfRooms, typeRepair);
    }

    /**
     * Создает новый объект дома с параметрами
     *
     * @return объект дома с параметрами
     */
    private static Construction createHouse() {
        System.out.println("Введите название сооружения:");
        String name = getStringInput();

        System.out.println("Введите площадь дома:");
        int square = getIntInputInRange(1, 10000);

        System.out.println("Введите кол-во этажей в доме:");
        int numOfFloors = getIntInputInRange(1, 10000);

        System.out.println("Введите кол-во квартир в доме:");
        int numOfFlat = getIntInputInRange(1, 10000);

        System.out.println("Введите тип отопления:");
        String typeOfHeat = getStringInput();

        return new House(name, square, numOfFloors, numOfFlat, typeOfHeat);
    }

    /**
     * Создает новый объект гаража с параметрами
     *
     * @return объект гаража с параметрами
     */
    private static Construction createGarage() {
        System.out.println("Введите название сооружения:");
        String name = getStringInput();

        System.out.println("Введите площадь гаража:");
        int square = getIntInputInRange(1, 10000);

        System.out.println("Введите вместимость гаража:");
        int capacity = getIntInputInRange(1, 100);

        System.out.println("Введите тип гаража:");
        String type = getStringInput();

        return new Garage(name, square, capacity, type);
    }

    /**
     * Создание объектов без параметров.
     *
     * @param constructionArrayList массив объектов.
     */
    private static void createNewConstruction(ArrayList<Construction> constructionArrayList) {
        String command;
        printConstructionMenu();
        command = getStringInput();
        switch (command) {
            case "1" -> constructionArrayList.add(new Construction());
            case "2" -> constructionArrayList.add(new House());
            case "3" -> constructionArrayList.add(new Garage());
            case "4" -> constructionArrayList.add(new Flat());
            case "5" -> {
            }
            default -> System.out.println("Данного пункта нет в меню!");
        }
    }

    /**
     * Создание объектов c параметрами.
     *
     * @param constructionArrayList массив объектов.
     */
    private static void createNewConstructionWithParam(ArrayList<Construction> constructionArrayList) {
        String command;
        printConstructionMenu();
        command = getStringInput();
        switch (command) {
            case "1" -> constructionArrayList.add(createConstruction());
            case "2" -> constructionArrayList.add(createHouse());
            case "3" -> constructionArrayList.add(createGarage());
            case "4" -> constructionArrayList.add(createFlat());
            case "5" -> {
            }
            default -> System.out.println("Данного пункта нет в меню!");
        }
    }

    /**
     * Сравнивает два объекта на равенство.
     *
     * @param constructionArrayList массив объектов.
     */
    private static void compareBuilding(ArrayList<Construction> constructionArrayList) {
        printAllConstruction(constructionArrayList);

        System.out.println("Введите номер первого объекта для сравнения:");
        int numFirstObject = getIntInputInRange(0, constructionArrayList.size() - 1);

        System.out.println("Введите номер второго объекта для сравнения:");
        int numSecondObject = getIntInputInRange(0, constructionArrayList.size() - 1);

        if (!(numFirstObject == numSecondObject)) {
            if (constructionArrayList.get(numFirstObject).hashCode() == constructionArrayList.get(numSecondObject).hashCode()) {
                System.out.println("Объекты равны!");
            } else {
                if (constructionArrayList.get(numFirstObject).equals(constructionArrayList.get(numSecondObject))) {
                    System.out.println("Объекты равны!");
                } else {
                    System.out.println("Объекты не равны!");
                }
            }
        } else {
            System.out.println("Ошибка! Вы пытаетесь сравнить объект с самим собой!");
        }
    }

    /**
     * Основной метод программы который выводит меню и реализует его пункты.
     *
     * @param args массив строк
     */
    public static void main(String[] args) {
        ArrayList<Construction> constructionArrayList = new ArrayList<>();
        String command;

        do {
            printMenu();
            command = getStringInput();
            switch (command) {
                case "1" -> {
                    createNewConstructionWithParam(constructionArrayList);
                }
                case "2" -> {
                    createNewConstruction(constructionArrayList);
                }
                case "3" -> {
                    if (!constructionArrayList.isEmpty()) {
                        deleteConstruction(constructionArrayList);
                    } else {
                        System.out.println("Массив объектов пуст!");
                    }
                }
                case "4" -> {
                    if (!constructionArrayList.isEmpty()) {
                        printAllConstruction(constructionArrayList);
                    } else {
                        System.out.println("Массив объектов пуст!");
                    }
                }
                case "5" -> {
                    if (!(constructionArrayList.size() < 2)) {
                        compareBuilding(constructionArrayList);
                    } else {
                        System.out.println("Для сравнения объектов, нужно иметь два объекта!");
                    }
                }
                case "6" -> System.out.println("Завершение работы программы...");
                default -> System.out.println("Данного пункта нет в меню!");
            }
        } while (!command.equals("6"));
    }
}