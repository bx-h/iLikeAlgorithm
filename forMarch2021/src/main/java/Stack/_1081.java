package Stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class _1081 {
    public String smallestSubsequence(String s) {
        Set<String> res = new HashSet<>(Arrays.asList(s.split("")));
        StringBuilder output = new StringBuilder();
        for (String i : res){
            output.append(i);
        }
        return output.toString();

    }
}
