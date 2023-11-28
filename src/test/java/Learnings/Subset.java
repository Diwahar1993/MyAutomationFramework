package Learnings;

public class Subset {
    public static void main(String[] args) {
        String s = "CAT";
        int length = s.length();
        int temp = 0;

        // Corrected array declaration
        String[] s1 = new String[length * (length + 1) / 2];

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                s1[temp] = s.substring(i, j + 1);
                temp++;
            }
        }

        for (String a : s1) {
            System.out.println(a);
        }
    }
}
