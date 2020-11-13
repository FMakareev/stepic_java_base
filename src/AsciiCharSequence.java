import java.lang.CharSequence;
import java.lang.*;
import java.nio.charset.StandardCharsets;


public class AsciiCharSequence implements CharSequence {
    public byte[] asciiChars;

    public AsciiCharSequence(byte[] asciiChars) {
        this.asciiChars = asciiChars;
    }

    @Override
    public String toString() {
        return new String(this.asciiChars, StandardCharsets.UTF_8);
    }

    @Override
    public int length() {
        return this.asciiChars.length;
    }

    @Override
    public char charAt(int i) {
        return (char) this.asciiChars[i];
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        byte[] newAsciiChars = new byte[end - start];
        for (int i = start, j = 0; i < end; i++, j++) {
            newAsciiChars[j] = asciiChars[i];
        }
        return new AsciiCharSequence(newAsciiChars);
    }


}
