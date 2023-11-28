package Learnings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class findDuplicates {

    public static void main(String[] args) {
        String s = "diwaharpandian";
        String str[]=s.split("");
        Set<String> set = new HashSet<>();
        Map<String,Integer> map = new HashMap<>();
        for(String a : str){
            set.add(a);
        }
        for(String b : set){
            int sum =0;
            for(String c : str){
                if(b.equals(c)){
                    sum=sum+1;
                }
            }
            map.put(b,sum);
        }
        System.out.println(map);
        map.forEach((k,v) ->{
            if(v>1){
                System.out.println("letter "+k +"is repeated "+v+" times");
            }
        });
    }
}
