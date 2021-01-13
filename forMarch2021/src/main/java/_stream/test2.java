package _stream;

import java.util.Arrays;

public class test2 {
    public static void main(String[] args) {
        String[] myArray = new String[]{"bob", "alice", "paul", "ellie"};
        String[] strings = Arrays.stream(myArray)
                                .filter(s -> s.length() > 4)
                                .toArray(String[]::new);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
