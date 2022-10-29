/**
 * Возвращает количество заглавных символов в строке.
 */
public class UpperCase implements StringAnalyzer {
    /**
     * Подсчитывает количество заглавных символов в строке.
     *
     * @param str исходная строка
     * @return количество заглавных символов в строке
     */
    @Override
    public int analyse(String str) {
        StringAnalyzer textAnalyzer = (s) -> {
            int upperCount = 0;
            for (char ch : s.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    upperCount++;
                }
            }
            return upperCount;
        };
        return textAnalyzer.analyse(str);
    }
}
