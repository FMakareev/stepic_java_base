package TextAnalyzer;

public class TooLongTextAnalyzer  implements TextAnalyzer {

    private int maxLength = 0;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        if(text.length() <= maxLength){
            return Label.OK;
        }
        return Label.TOO_LONG;
    }
}