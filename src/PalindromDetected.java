import org.junit.Assert;
import org.junit.Test;

public class PalindromDetected {


    public static boolean isPalindrome(String text) {

        text = text.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(text);
          return text.equalsIgnoreCase(new StringBuffer(text).reverse().toString());
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertEquals(true, PalindromDetected.isPalindrome("Madam, I'm Adam!"));
    }


}
