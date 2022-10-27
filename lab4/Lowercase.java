public class Lowercase implements TextAnalyzer {
    @Override
    public int analyse(String str) {
        TextAnalyzer textAnalyzer = (s) -> {
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
