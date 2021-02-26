package sword._38;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    ArrayList<StringBuilder> sbarray;

    public String[] permutation(String s) {
        Set<StringBuilder> res = helper(s, 0);
        String[] ans = new String[res.size()];
        int i = 0;
        for (StringBuilder sb : res) {
            ans[i] = sb.toString();
            i++;
        }

        return ans;
    }

    public Set<StringBuilder> helper(String s, int start) {
        Set<StringBuilder> ssb = new HashSet<>();
        if (start >= s.length()) return ssb;
        String cur = s.substring(start, start + 1);

        if (start == s.length() - 1) {
            ssb.add(new StringBuilder(cur));
            return ssb;
        }
        Set<StringBuilder> temps = helper(s, start + 1);

        for (StringBuilder sb : temps) {
            for (int i = 0; i <= sb.length(); ++i) {
                StringBuilder newsb = new StringBuilder(sb);
                newsb.insert(i, cur);
                ssb.add(newsb);
            }
        }

        return ssb;

    }

    @Test
    public void test1() {
        String[] abcs = permutation("abc");
        for (String a : abcs) {
            System.out.printf("%s ", a);
        }
    }

}