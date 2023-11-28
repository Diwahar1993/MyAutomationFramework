package Utils.Practice;

import java.util.ArrayList;

public class basic {

    //palindrome

    public static void main(String[] args) {
        String s ="malayalam";
        String str[]= s.split("");
        ArrayList<String> arr = new ArrayList<>();
        for(String a : str){
            arr.add(a);
        }
        System.out.println(arr);
        ArrayList<String> reverse = new ArrayList<>();
        for(int i=arr.size()-1;i>=0;i--){
            reverse.add(arr.get(i));

        }
        System.out.println(reverse);

        if(arr.equals(reverse)){
            System.out.println("it is a palindrome");
        }else{
            System.out.println("it is not a palindrome");
        }
    }
}
