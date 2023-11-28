package Learnings;

public class SortArray {
    public static void main(String[] args) {
        int arr[]={7,6,5,4,3,2,1};
        int temp=0;

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
for(int a : arr){
    System.out.println(a);
}
        System.out.println("second largest element is "+ arr[arr.length-2]);
    }
}
