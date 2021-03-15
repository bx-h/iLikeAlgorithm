package Other;

public class rain {
    public int trap(int[] height) {
        if (height.length == 0) { return 0; }
        int n = height.length;
        int res = 0;
        int[] lmax = new int[n], rmax = new int[n];
        lmax[0] = height[0];
        rmax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(height[i], lmax[i-1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(height[i], rmax[i+1]);
        }
        // 开始计算
        // water[i] = min {maxLeft, maxRight} - height[i]
        for (int i = 1; i < n-1; i++) {
            res += Math.min(lmax[i], rmax[i]) - height[i];
        }

        return res;
    }
}
