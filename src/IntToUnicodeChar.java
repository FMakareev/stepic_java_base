import org.junit.Assert;
import org.junit.Test;

public class IntToUnicodeChar {

    public static char charExpression(int a) {
        char charValue = '\\';

        return (char)(a + (int)charValue);
    }
    @Test
    public void testCharExpression() {
        Assert.assertEquals('|', IntToUnicodeChar.charExpression(32));
        Assert.assertEquals('y', IntToUnicodeChar.charExpression(29));
    }
}
