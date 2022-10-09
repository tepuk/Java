/**
 * Класс описывает сущность 'Напиток'
 */
public class Drink {

    /**
     * Название напитка
     */
    private String name;

    /**
     * Описание напитка
     */
    private String description;

    /**
     * Объем напитка
     */
    private int volume;

    /**
     * Цена напитка
     */
    private int price;

    /**
     * Конструктор с параметрами
     *
     * @param name        название напитка
     * @param description описание напитка
     * @param volume      объем напитка
     * @param price       цена напитка
     */
    public Drink(String name, String description, int volume, int price) {
        this.name = name;
        this.description = description;
        this.volume = volume;
        this.price = price;
    }

    /**
     * Конструктор по-умолчанию
     */
    public Drink() {
        this.name = "none";
        this.description = "none";
        this.volume = 0;
        this.price = 0;
    }

    /**
     * Возвращает название напитка
     *
     * @return название напитка
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название напитка
     *
     * @param name название напитка
     */
    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    /**
     * Возвращает описание напитка
     *
     * @return описание напитка
     */
    public String getDescription() {
        return description;
    }

    /**
     * Устанавливает описание напитка
     *
     * @param description описание напитка
     */
    public void setDescription(String description) {
        if (!description.isEmpty()) {
            this.description = description;
        }
    }

    /**
     * Возвращает объем напитка
     *
     * @return объем напитка
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Устанавливает объем напитка
     *
     * @param volume объем напитка
     */
    public void setVolume(int volume) {
        if (volume > 0) {
            this.volume = volume;
        }
    }

    /**
     * Возвращает цену напитка
     *
     * @return цена напитка
     */
    public int getPrice() {
        return price;
    }

    /**
     * Устанавливает цену напитка
     *
     * @param price цена напитка
     */
    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        }
    }

    /**
     * Возвращает размер напитка
     *
     * @return размер напитка
     */
    public String getDrinkSize() {

        final int SMALL_SIZE = 500;
        final int MEDIUM_SIZE = 1000;
        final int LARGE_SIZE = 2000;

        final String EXTRA_SMALL = "Small";
        final String SMALL = "Small";
        final String MEDIUM = "Medium";
        final String LARGE = "Large";


        if (this.volume > 0) {

            if (this.volume < SMALL_SIZE) {
                return EXTRA_SMALL;
            }
            if (this.volume < MEDIUM_SIZE) {
                return SMALL;
            }
            if (this.volume < LARGE_SIZE) {
                return MEDIUM;
            }
            return LARGE;
        }
        return "параметры не заданы!";
    }

    /**
     * Возвращает строковое представление объекта класса
     *
     * @return строковое представление объекта класса
     */
    @Override
    public String toString() {
        return "\nНазвание: " + name + "\n" +
                "Описание: " + description + "\n" +
                "Объем: " + volume + "мл.\n" +
                "Цена: " + price + "руб.\n" +
                "Размер напитка: " + getDrinkSize() + "\n";
    }
}
