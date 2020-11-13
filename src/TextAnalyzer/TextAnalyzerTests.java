package TextAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class TextAnalyzerTests {
    String[] spamKeywords = {"spam", "bad"};
    int commentMaxLength = 20;

    @Test
    public void testTooLongTextAnalyzer() {
        TooLongTextAnalyzer analyzer = new TooLongTextAnalyzer(commentMaxLength);
        Assert.assertEquals(Label.OK, analyzer.processText(""));
        Assert.assertEquals(Label.OK, analyzer.processText("1234567890123456789"));
        Assert.assertEquals(Label.OK, analyzer.processText("12345678901234567890"));
        Assert.assertEquals(Label.TOO_LONG, analyzer.processText("123456789012345678901"));
        Assert.assertEquals(Label.TOO_LONG, analyzer.processText("1234567890123456789012345678901234567890"));
    }

    @Test
    public void testNegativeTextAnalyzer() {
        NegativeTextAnalyzer analyzer = new NegativeTextAnalyzer();
        Assert.assertEquals(Label.OK, analyzer.processText(""));
        Assert.assertEquals(Label.OK, analyzer.processText("bada fo spa"));
        Assert.assertEquals(Label.NEGATIVE_TEXT, analyzer.processText("foo bar :("));
        Assert.assertEquals(Label.NEGATIVE_TEXT, analyzer.processText("=( fo :|"));
        Assert.assertEquals(Label.NEGATIVE_TEXT, analyzer.processText("bada=( fo spa"));

        Assert.assertEquals(Label.NEGATIVE_TEXT, analyzer.getLabel());
        Assert.assertArrayEquals(new String[]{":(","=(",":|"}, analyzer.getKeywords());

    }

    @Test
    public void testSpamAnalyzer() {
        SpamAnalyzer analyzer = new SpamAnalyzer(spamKeywords);

        Assert.assertEquals(Label.OK, analyzer.processText(""));
        Assert.assertEquals(Label.SPAM, analyzer.processText("bada fo spa"));
        Assert.assertEquals(Label.SPAM, analyzer.processText("foo bar bad"));
        Assert.assertEquals(Label.SPAM, analyzer.processText("spam bar bad"));
        Assert.assertEquals(Label.SPAM, analyzer.processText("sm spam bad"));

        Assert.assertEquals(Label.SPAM, analyzer.getLabel());
        Assert.assertArrayEquals(spamKeywords, analyzer.getKeywords());
    }

    @Test
    public void testCheckLabels() {
        Main testObject = new Main();

        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};

        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }

    }

}
