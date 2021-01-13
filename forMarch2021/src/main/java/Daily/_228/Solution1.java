package Daily._228;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }
        int start = nums[0];
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] + 1 != nums[i + 1]) {
                int end = nums[i];
                if (start == end) {
                    res.add(start + "");
                }
                else {
                    res.add(start + "->" + end);
                }
                start = nums[i + 1];
            }

        }
        int rear = nums[nums.length - 1];
        if (start == rear) {
            res.add(rear + "");
        } else {
            res.add(start + "->" + rear);
        }

        return res;

    }
}
