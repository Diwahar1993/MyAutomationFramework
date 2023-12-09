package Learnings;

import java.util.*;

public class outputHighlevel {

    public static void main(String[] args) {
        //aaabbcccddeeffeee
        String str = "aaabbcccddeeffeee";
        //output ->a3b2c3d2e2f2e3

        String s[] = str.split("");
        ArrayList<String> arr = new ArrayList<>();
        for(String a :s ){
            arr.add(a);
        }

        Set<String> set = new HashSet<>();
        for(String b : s){
            set.add(b);
        }

        // to put the value and its no of occurances
        Map<String,Integer> map = new HashMap<String,Integer>();

        for(String unique : set){
            int sum = 0;
            for(String character : arr){
                if(unique.equals(character)){
                    sum = sum+1;
                }
            }
            map.put(unique,sum);
        }

        map.forEach((k,v) -> System.out.print(k+v));
    }
}
