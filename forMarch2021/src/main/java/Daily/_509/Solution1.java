package Daily._509;
/*
* 斐波那契数列
*
* */
public class Solution1 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 1);
    }
}
