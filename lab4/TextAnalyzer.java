/**
 * Производит анализ строки по интересующему критерию
 */
public interface StringAnalyzer {
    /**
     * Анализ строки по интересующему критерию
     *
     * @param str исходная строка
     * @return результат анализа
     */
    int analyse(String str);
}
