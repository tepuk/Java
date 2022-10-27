public class Uppercase implements TextAnalyzer {
    @Override
    public int analyse(String str) {
        TextAnalyzer textAnalyzer = (s) -> {
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