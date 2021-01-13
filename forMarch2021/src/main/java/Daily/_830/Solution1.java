package Daily._830;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
* 错误思路！！
* 当i 和 i+2 中间出现其他元素时，判断出错
*
* */
public class Solution1 {
    int length = 2;
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 2; ++i) {
            if (s.charAt(i) == (s.charAt(i+2))) {
                int j;
                for (j = i + 3; j < s.length(); ++j) {
                    if (s.charAt(i) != s.charAt(j)) {
                        break;
                    }
                }

                res.add(Arrays.asList(i, j-1));
                i = j - 1;
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
