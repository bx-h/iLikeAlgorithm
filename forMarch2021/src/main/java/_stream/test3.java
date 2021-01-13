package _stream;

import java.util.Arrays;

/*
* the reduce method expects two arguments: an identity element, and a lambda expression.
*
* The lambda expression you pass to the reduce method must be capable of handling two inputs: a partial result
* of the reduction operation, and the current element of the stream.
*
*
* */
public class test3 {
    public static void main(String[] args) {
        String[] myArray = { "this", "is", "a", "sentence" };
        String reduce = Arrays.stream(myArray).reduce("", (a, b) -> a + b);
        System.out.println(reduce);
    }
}
