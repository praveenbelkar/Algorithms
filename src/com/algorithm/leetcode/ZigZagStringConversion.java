package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"

 Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"
 Example 2:

 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 */
public class ZigZagStringConversion {

    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i=0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int sbIndex = 0;
        boolean descending = true;
        for(int i=0; i < s.length(); i++) {
            sbs[sbIndex].append(s.charAt(i));
            if(sbIndex == numRows-1) {
                descending = false;
            }else if(sbIndex == 0) {
                descending = true;
            }
            if(descending){
                sbIndex++;
            }else{
                sbIndex--;
            }
        }

        StringBuilder sbResult = new StringBuilder();
        for(int i=0; i < numRows; i++) {
            sbResult.append(sbs[i].toString());
        }
        return sbResult.toString();
    }

    public static void main(String[] args) {
        ZigZagStringConversion mainObject = new ZigZagStringConversion();

        /*String input = "PAYPALISHIRING";
        String expected = "PAHNAPLSIIGYIR";
        int numOfRows = 3;*/
        /*String input = "PAYPALISHIRING";
        String expected = "PINALSIGYAHRPI";
        int numOfRows = 4;*/
        String input = "AB";
        String expected = "AB";
        int numOfRows = 1;

        String result = mainObject.convert(input, numOfRows);
        System.out.println(result);
        System.out.println(expected.equals(result));
    }
}
