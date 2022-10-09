import java.util.Objects;

/**
 * Класс описывает сушность "Квартира"
 */
public class Flat extends Construction {
    /**
     * Количество комнат
     */
    private int numOfRooms;
    /**
     * Тип ремонта
     */
    private String typeRepair;

    /**
     * Конструктор с параметрами
     *
     * @param name       название
     * @param square     площадь
     * @param numOfRooms количество комнат
     * @param typeRepair тип ремонта
     */
    public Flat(String name, int square, int numOfRooms, String typeRepair) {
        super(name, square);
        this.numOfRooms = numOfRooms;
        this.typeRepair = typeRepair;
    }

    /**
     * Конструктор по-умолчанию
     */
    public Flat() {
        this.numOfRooms = 0;
        this.typeRepair = "none";
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
        Flat flat = (Flat) o;
        return numOfRooms == flat.numOfRooms && Objects.equals(typeRepair, flat.typeRepair);
    }

    /**
     * Возвращает числовое значение объекта фиксированной длинны
     *
     * @return числовое значение объекта фиксированной длинны
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numOfRooms, typeRepair);
    }

    /**
     * Возвращает строковое представление класса
     *
     * @return строковое представление класса
     */
    @Override
    public String toString() {
        return "Flat{" + "name='" + getName() + '\'' + ", square=" + getSquare() + ", numOfRooms=" + numOfRooms + ", typeRepair='" + typeRepair + '\'' + "}\n";
    }
}
