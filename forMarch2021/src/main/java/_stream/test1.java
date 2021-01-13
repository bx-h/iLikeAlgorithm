package _stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class test1 {
    public static void main(String[] args) {
        List<Integer> mylist = new ArrayList<>();
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);

        Stream<Integer> myStream = mylist.stream();
        Stream<Integer> myNewStream = myStream.map(integer -> {
            return integer + 1;
        });
        Integer[] objects = myNewStream.toArray(Integer[]::new);
        for (Integer object : objects) {
            System.out.print(object);
            System.out.print(' ');
        }

    }
}
