package Daily._830;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0, j = 0;
        for (i = 0; i < s.length(); ++i) {
            for (j = i + 1; j < s.length(); ++j) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                }
            }
            if (i + 2 < j) {
                res.add(Arrays.asList(i, j-1));
                i = j-1;
            }
        }
        return res;

    }

    @Test
    public void test1() {
        String s = "abbxxxxzzy";
        List<List<Integer>> lists = largeGroupPositions(s);
        lists.forEach(System.out::println);
    }
}
