package Learnings;

public class trythis {

    public static void main(String[] args) {
        //aaabbcccddeeffeee
        String str = "aaabbcccddeeffeee";
        //output ->a3b2c3d2e2f2e3


        String s[] = str.split("");
        String temp=s[0];
        int sum=0;
        for(String a : s){

            if(a.equals(temp)){
                sum=sum+1;

            }else{
                System.out.print(temp+sum);
                sum=1;
                temp=a;
            }
        }
        System.out.print(temp + sum);
    }
}
