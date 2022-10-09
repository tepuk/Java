import java.util.Objects;

/**
 * Базовый класс описывающий сущность 'Сооружение'
 */
public class Construction {
    /**
     * Название сооружения
     */
    private String name;

    /**
     * Площадь сооружения
     */
    private int square;

    /**
     * Конструктор по-умолчанию
     */
    public Construction() {
        this.name = "none";
        this.square = 0;
    }

    /**
     * Конструктр с параметрами
     *
     * @param name   название сооружения
     * @param square площадь сооружения
     */
    public Construction(String name, int square) {
        this.name = name;
        this.square = square;
    }

    /**
     * Возвращает название сооружения
     *
     * @return название сооружения
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает площадь сооружения
     *
     * @return площадь сооружения
     */
    public int getSquare() {
        return square;
    }

    /**
     * Сравнивает объекты
     *
     * @param o объект для сравнения
     * @return результат сравнения объектов
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Construction that = (Construction) o;
        return square == that.square && Objects.equals(name, that.name);
    }

    /**
     * Возвращает числовое значение объекта фиксированной длинны
     *
     * @return числовое значение объекта фиксированной длинны
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, square);
    }

    /**
     * Возвращает строковое представление класса
     *
     * @return строковое представление класса
     */
    @Override
    public String toString() {
        return "Construction{" + "name='" + name + '\'' + ", square=" + square + "}\n";
    }
}