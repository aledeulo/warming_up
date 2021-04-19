
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class study {

    public static void main(String[] args) {
        plusMinus(new int[]{-4, 3, -9, 0, 4, 1});
    }

    private static int jumpingClouds(int[] c) {
        List<Integer> steps = new ArrayList<>();
        int i = 0;
        while (i < c.length - 1) {
            if ((i + 2 < c.length) && c[i + 2] == 0) {
                steps.add(c[i + 2]);
                i += 2;
            } else {
                steps.add(c[i + 1]);
                i += 1;
            }
        }
        return steps.size();
    }


    static long repeatedString(String s, long n) {
        if (!s.contains("a"))
            return 0;

        if (s.chars().count() == 1 && s.equals("a"))
            return n;
        if (s.chars().count() == 2)
            return n % 2;

        long countSubst = s.chars().filter(c -> c == 'a').count();
        long divisor = n / s.length();
        long remainder = n % s.length();
        long totalCount = divisor * countSubst;
        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a') {
                totalCount++;
            }
        }
        return totalCount;
    }

    static int simpleArraySum(int[] ar) {
        if (ar.length == 1)
            return ar[0];
        return Arrays.stream(ar).sum();
    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
            add(0);
        }};
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(1).equals(b.get(i)))
                if (a.get(i) > b.get(i)) {
                    res.set(0, res.get(0) + 1);
                } else {
                    res.set(1, res.get(1) + 1);
                }
        }
        return res;
    }

    static long aVeryBigSum(long[] ar) {
        return Arrays.stream(ar).map(a -> new Long(a)).sum();
    }

    public static int diagonalDifference(List<List<Integer>> arr) {

        if (arr.size() == 0)
            return 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.size() != arr.get(i).size())
                arr.remove(arr.get(i));
        }

        int level1 = 0, level2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            level1 += arr.get(i).get(i);
        }

        int size = arr.size() - 1;
        for (List<Integer> integers : arr) {
            level2 += integers.get(size);
            size--;
        }

        if (level1 < level2) {
            return level2 - level1;
        } else return level1 - level2;
    }

    static void plusMinus(int[] arr) {
        int n = arr.length;
        double pos = (double) Arrays.stream(arr).filter(x -> x > 0).count() / n;
        double neg = (double) Arrays.stream(arr).filter(x -> x < 0).count() / n;
        double zero = (double) Arrays.stream(arr).filter(x -> x == 0).count() / n;
        System.out.printf("%.6f", pos).print("\n");
        System.out.printf("%.6f", neg).print("\n");
        System.out.printf("%.6f", zero).print("\n");
    }
}
