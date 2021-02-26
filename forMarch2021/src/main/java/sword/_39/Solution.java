package sword._39;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!count.containsKey(nums[i])) {
                count.put(nums[i], 1);
            } else {
                count.replace(nums[i], count.get(nums[i]) + 1);
            }
        }

        AtomicInteger res = new AtomicInteger();
        count.entrySet().forEach((e)->{
            if (e.getValue() > nums.length / 2) {
                res.set(e.getKey());
            }
        });

        return res.get();
    }
}
