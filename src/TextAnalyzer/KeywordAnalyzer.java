package TextAnalyzer;

public abstract class KeywordAnalyzer implements TextAnalyzer {

    protected String[] keywords;
    protected abstract String[] getKeywords();
    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for(String key: keywords){
            if(new StringBuilder(text).indexOf(key) != -1){
                return getLabel() ;
            }
        }

        return Label.OK;
    }
}
