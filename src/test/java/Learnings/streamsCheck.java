package Learnings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class streamsCheck {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> even=list.stream().filter(a->a%2==0).collect(Collectors.toList());
        System.out.println(even);
        List<Integer> doubledEvenNumbers = arr.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());

    }
}
