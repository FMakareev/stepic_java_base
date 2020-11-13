import org.junit.Assert;
import org.junit.Test;

public class PowerOfTwo {

    public static boolean isPowerOfTwo(int value) {
        value = Math.abs(value);
        if(value == 0) {
            return false;
        }
        if(value == 1 || value == 2 || Integer.bitCount(value) == 1) {
            return true;
        }
        return false;
    }

    @Test
    public void testCharExpression() {

        System.out.println('A' + "12");
        System.out.println("A" + 12);
        System.out.println('A' + '1' + "2");
        System.out.println("A" + ('\t' + '\u0003'));

        Assert.assertEquals(false, PowerOfTwo.isPowerOfTwo(0));
        Assert.assertEquals(true, PowerOfTwo.isPowerOfTwo(1));
        Assert.assertEquals(true, PowerOfTwo.isPowerOfTwo(-2));
        Assert.assertEquals(true, PowerOfTwo.isPowerOfTwo(32));
        Assert.assertEquals(true, PowerOfTwo.isPowerOfTwo(64));
        Assert.assertEquals(true, PowerOfTwo.isPowerOfTwo(128));
        Assert.assertEquals(false, PowerOfTwo.isPowerOfTwo(156));
        Assert.assertEquals(false, PowerOfTwo.isPowerOfTwo(345));
    }
}
