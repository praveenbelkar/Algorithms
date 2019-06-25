package com.algorithm.atlassian;

public class LookAndSay {

    static String LookAndSay(String start, int n) {
        if(start == null || start.length() == 0 || n < 1) {
            return "";
        }

        String input = start;
        for(int i=0; i < n; i++) {
            input = lookAndSayUtil(input);
        }
        return input;
    }

    static String lookAndSayUtil(String start) {
        StringBuilder sb = new StringBuilder(start.charAt(0));
        String prev = String.valueOf(start.charAt(0));
        String cur = null;
        int cnt=1;
        for(int i=1; i < start.length(); i++) {
            cur = String.valueOf(start.charAt(i));
            if(cur.equals(prev)) {
                cnt++;
            } else {
                sb.append(String.valueOf(cnt));
                sb.append(prev);

                cnt=1;
                prev = cur;
            }
        }
        sb.append(String.valueOf(cnt));
        sb.append(prev);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(LookAndSay.LookAndSay("11", 4));
    }
}
