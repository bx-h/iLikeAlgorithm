package MEITUAN.Main2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] arr = input.toCharArray();
        int slow = 0, fast = 0;
        ArrayList<String> ans = new ArrayList<>();

        while (fast != arr.length) {
            if (!isNum(arr[fast])) {
                if (slow != fast) {
                    ans.add(cutZero(input.substring(slow, fast)));
                }

                fast++;
                slow = fast;
            }

            else {
                fast++;
            }
        }

        if (slow != fast) {
            ans.add(cutZero(input.substring(slow)));
        }

        ans.sort((x, y)->{
            if (x.length() > y.length()) { return 1; }
            if (x.length() < y.length()) { return -1; }

            if (x.length() <= 9) {
                return Integer.compare(Integer.parseInt(x), Integer.parseInt(y));
            }

            int index = 0;
            for (int i = 0; i < x.length(); ++i) {
                if (x.charAt(i) < y.charAt(i)) { return -1; }
                if (x.charAt(i) > y.charAt(i)) { return 1; }

            }
            return 0;
        });

        for (String e : ans) {
            System.out.println(e);
        }
    }


    public static boolean isNum(char c) {
        return c <= '9' && c >= '0';
    }

    public static String cutZero(String e) {
        int i = 0;
        while (i < e.length()) {
            if (e.charAt(i) == '0') {
                i++;
            } else {
                break;
            }
        }

        if (i == e.length()) {
            return "0";
        }
        return e.substring(i);
    }


}