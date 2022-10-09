import java.util.Objects;

/**
 * Класс описывает сушность "Гараж"
 */
public class Garage extends Construction {
    /**
     * Вместимость гаража
     */
    private int capacityOfGarage;
    /**
     * Вид гаража
     */
    private String typeOfGarage;

    /**
     * Конструктор с параметрами
     *
     * @param name             название
     * @param square           площадь
     * @param capacityOfGarage вместимость гаража
     * @param typeOfGarage     тип гаража
     */
    public Garage(String name, int square, int capacityOfGarage, String typeOfGarage) {
        super(name, square);
        this.capacityOfGarage = capacityOfGarage;
        this.typeOfGarage = typeOfGarage;
    }

    /**
     * Конструктор по-умолчанию
     */
    public Garage() {
        this.capacityOfGarage = 0;
        this.typeOfGarage = "none";
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
        Garage garage = (Garage) o;
        return capacityOfGarage == garage.capacityOfGarage && Objects.equals(typeOfGarage, garage.typeOfGarage);
    }

    /**
     * Возвращает числовое значение объекта фиксированной длинны
     *
     * @return числовое значение объекта фиксированной длинны
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacityOfGarage, typeOfGarage);
    }

    /**
     * Возвращает строковое представление класса
     *
     * @return строковое представление класса
     */
    @Override
    public String toString() {
        return "Garage{" + "name='" + getName() + '\'' + ", square=" + getSquare() + ", capacityOfGarage=" + capacityOfGarage + ", typeOfGarage='" + typeOfGarage + '\'' + "}\n";
    }
}
