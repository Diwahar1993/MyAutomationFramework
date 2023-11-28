package Learnings;

import java.util.Arrays;

public class AnagramCheck {
    public static void main(String[] args) {
        String s1 = "BRAG";
        String s2 = "grab";

        s1= s1.toLowerCase();
        s2= s2.toLowerCase();
        if(s1.length()!=s2.length()){
            System.out.println("this is not an anagram");
        }
        else{
            char c1[] = s1.toCharArray();
            char c2[] = s2.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            if(Arrays.equals(c1,c2)){
                System.out.println("this is an anagram");

            }else{
                System.out.println("not an anagram");
            }
        }
    }
}
