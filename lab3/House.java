import java.util.Objects;

/**
 * Класс описывает сущность "Дом"
 */
public class House extends Construction {
    /**
     * Количество этажей
     */
    private int numOfFloors;

    /**
     * Количество квартир
     */
    private int numOfFlat;

    /**
     * Тип отопления
     */
    private String typeOfHeat;

    /**
     * Конструктор с параметрами
     *
     * @param name        название
     * @param square      площадь
     * @param numOfFloors количество этажей
     * @param numOfFlat   количество квартир
     * @param typeOfHeat  тип отопления
     */
    public House(String name, int square, int numOfFloors, int numOfFlat, String typeOfHeat) {
        super(name, square);
        this.numOfFloors = numOfFloors;
        this.numOfFlat = numOfFlat;
        this.typeOfHeat = typeOfHeat;
    }

    /**
     * Конструктор по-умолчанию
     */
    public House() {
        this.numOfFloors = 0;
        this.numOfFlat = 0;
        this.typeOfHeat = "none";
    }

    /**
     * Сравнивает объекты
     *
     * @param o объект для сравнения
     * @return результат сравнения
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        House house = (House) o;
        return numOfFloors == house.numOfFloors && numOfFlat == house.numOfFlat && Objects.equals(typeOfHeat, house.typeOfHeat);
    }

    /**
     * Возвращает числовое значение объекта фиксированной длинны
     *
     * @return числовое значение объекта фиксированной длинны
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numOfFloors, numOfFlat, typeOfHeat);
    }

    /**
     * Возвращает строковое представление класса
     *
     * @return строковое представление класса
     */
    @Override
    public String toString() {
        return "House{" + "name='" + getName() + '\'' + ", square=" + getSquare() + ", numOfFloors=" + numOfFloors + ", numOfFlat=" + numOfFlat + ", typeOfHeat='" + typeOfHeat + '\'' + "}\n";
    }
}
