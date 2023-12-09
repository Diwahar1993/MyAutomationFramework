package Learnings;

public class substring {

    public static void main(String[] args) {
        String str = "CAT";
        int temp =0;
        int length = str.length();
        String s1[] = new String[length*(length+1)/2];
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                s1[temp]=str.substring(i,j+1);
                temp++;
            }
        }
        for(String a : s1){
            System.out.println(a);
        }
    }
}
