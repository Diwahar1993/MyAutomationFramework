package Learnings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternProgram {
    public static void main(String[] args) {
        String s = "Bus no 25 comes at 9";
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(s);
        while(m.find()){
            System.out.println(m.group());
        }
    }
}
