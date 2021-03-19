package Tencent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Random;
import java.util.TreeMap;

public class Solution2 {
//
//    @Test
//    public void test1() {
//        Random r = new Random();
//        int[] nums = new int[10];
//        for (int i = 0; i < 10; ++i) {
//            nums[i] = r.nextInt(100000) + 100000;
//        }
//
//        ArrayList<Integer> sort = sort(nums);
//        sort.forEach(System.out::println);
//    }


    public void helper(int[] nums) {
        int max = 200000;
        int min = 100000;
        BitSet bs = new BitSet(max - min);
        for (int i = 0; i < nums.length; ++i) {
            bs.set(nums[i] - min, true);
        }

        for (int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i + 1)) {
            System.out.printf("%d ", i + min);
        }
    }


    @Test
    public void test3() {
        int[] nums = new int[]{100023, 100423, 100341, 100341, 153211};
        helper(nums);
    }


}
