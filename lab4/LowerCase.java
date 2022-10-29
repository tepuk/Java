/**
 * Возвращает количество строчных символов в строке.
 */
public class LowerCase implements StringAnalyzer {
    /**
     * Подсчитывает количество строчных символов в строке.
     *
     * @param str исходная строка
     * @return количество строчных символов в строке
     */
    @Override
    public int analyse(String str) {
        StringAnalyzer textAnalyzer = (s) -> {
            int lowerCount = 0;
            for (char ch : s.toCharArray()) {
                if (Character.isLowerCase(ch)) {
                    lowerCount++;
                }
            }
            return lowerCount;
        };
        return textAnalyzer.analyse(str);
    }
}
