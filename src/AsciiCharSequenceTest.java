import org.junit.Assert;
import org.junit.Test;

public class AsciiCharSequenceTest {

    @Test
    public void allTests() {
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        Assert.assertEquals("Hello!", answer.toString());
        Assert.assertEquals(6, answer.length());
        Assert.assertEquals('e', answer.charAt(1));

        System.out.println(answer.subSequence(1, 5).toString());
        Assert.assertEquals("ello", answer.subSequence(1, 5).toString());
        Assert.assertArrayEquals(new byte[]{
                101, 108, 108, 111
        },answer.subSequence(1, 5).asciiChars);
    }

}
