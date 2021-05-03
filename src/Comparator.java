import java.util.Arrays;

public class Comparator {
    public boolean compare(int a, int b) {
        return a == b;
    }

    public boolean compare(String a, String b) {
        return a.equals(b);
    }

    public boolean compare(int[] a, int[] b) {
        return (a.length == b.length) && Arrays.equals(a, b);
    }
}
