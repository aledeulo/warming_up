
import java.util.*;
import java.util.stream.Collectors;


public class study {

    public static void main(String[] args) {
        System.out.println(isBalanced("{}("));

    }

    /*Level easy start*/
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

    public static void staircase(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                for (int j = 0; j < n; j++) {
                    builder.append("#");
                }
            } else {
                //add spaces
                int spaces = (n - 1) - i;
                for (int j = 0; j < spaces; j++) {
                    builder.append(" ");
                }
                for (int j = spaces; j < n; j++) {
                    builder.append("#");
                }
                builder.append("\n");
            }
        }
        System.out.println(builder);
    }

    public static void miniMaxSum(List<Integer> arr) {
        List<Integer> ordered = arr.stream().sorted().collect(Collectors.toList());
        List<Integer> maxList = ordered.subList(1, ordered.size());
        List<Integer> minList = ordered.subList(0, ordered.size() - 1);
        String res = minList.stream().mapToLong(Integer::longValue).sum() + " " + maxList.stream().mapToLong(Integer::longValue).sum();
        System.out.println(res);
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        List<Integer> ordered = candles.stream().sorted().collect(Collectors.toList());
        int max = ordered.get(ordered.size() - 1);
        return (int) ordered.stream().filter(i -> i == max).count();
    }

    public static String timeConversion(String s) {
        s = s.toLowerCase();
        boolean military = s.contains("pm") || (s.contains("12") && s.contains("am"));
        String[] array = s.contains("am") ? s.split("am") : s.split("pm");
        if (!military)
            return array[0];

        array = array[0].split(":");
        int hour = Integer.parseInt(array[0]);
        StringBuilder time = new StringBuilder();
        if (hour == 12 && s.contains("am")) {
            time.append("00");
        } else if (hour == 12 && s.contains("pm")) {
            time.append(12);
        } else time.append(hour + 12);
        time.append(":");
        for (int i = 1; i < array.length; i++) {
            if (i == array.length - 1) {
                time.append(array[i]);
            } else {
                time.append(array[i]).append(":");
            }
        }
        return time.toString();
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        final int initial = scores.get(0);
        final List<Integer> upScore = Arrays.asList(initial);
        final TreeSet<Integer> minorScore = new TreeSet<>();
        minorScore.add(initial);
        int breaks = (int) scores.stream().filter(s -> {
            if (s > upScore.get(0)) {
                upScore.set(0, s);
                return true;
            }
            if (s < minorScore.first()) {
                minorScore.add(s);
            }
            return false;
        }).count();
        minorScore.remove(minorScore.last());
        return Arrays.asList(breaks, minorScore.size());
    }

    static int birthday(List<Integer> s, int d, int m) {

        if (s.size() == 0)
            return 0;

        if (s.size() == 1 && s.get(0) == d)
            return 1;

        int count = 0;
        for (int i = 0; i < s.size(); i++) {
            int limit = i + m;
            if (limit <= s.size()) {
                int sum = 0;
                for (int j = i; j < limit; j++) {
                    sum += s.get(j);
                }
                if (sum == d)
                    count++;
            } else break;
        }
        return count;
    }

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        int[] counter = new int[arr.size()];
        int result = 1;
        int max = 0;
        for (Integer integer : arr) {
            counter[integer]++;
        }

        for (int i = 1; i <= arr.size() - 1; i++) {
            if (counter[i] > max) {
                result = i;
                max = counter[i];
            }
        }
        return result;
    }

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return "false";
                }
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return "false";
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return "false";
                }
            }
        }
        return String.valueOf(stack.isEmpty());
    }
    /*Level easy ends*/


    /*public static int separateTheChocolate(List<String> chocolate) {
        long del = chocolate.stream().filter(s -> s.equalsIgnoreCase("D")).count();
        long both = chocolate.stream().filter(s -> s.equalsIgnoreCase("U")).count();
        long tom = chocolate.stream().filter(s -> s.equalsIgnoreCase("T")).count();

    }*/
}
