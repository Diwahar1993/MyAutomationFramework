package Utils.Practice;

import java.util.ArrayList;
import java.util.List;

public class patternCheck {
    
    //[1,2,3,5]
    //[11,10,8,5]
    
    
    // 1) 1+2+3+5
    // 2) eliminate 1
    // 3) add all (2+3+5)
    // 4) eliminate 2

    public static void main(String[] args) {
        int numList[] = {1,2,3,5};
        List<Integer> list = new ArrayList<>();
        for(int a : numList){
            list.add(a);
        }
        
        List<Integer> finallist= new ArrayList<Integer>();
        while(list.size()>0){
            finallist.add(sumNumbersInList(list));
            list.remove(0);
        }

        System.out.println(finallist);
    }

    private static Integer sumNumbersInList(List<Integer> list) {
        int sum =0;
        for(int a : list){
            sum = sum+a;
        }
        return sum;
    }

}
