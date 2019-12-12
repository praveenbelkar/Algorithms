package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/student-attendance-record-i/
 *
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class P551_StudentAttendance {

    public boolean checkRecord(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }

        int absentCount = 0;
        int continousLateCount = 0;
        boolean flagForPreviousLate = false;

        for(int i=0; i < s.length(); i++) {
            String currentChar = String.valueOf(s.charAt(i));
            if(currentChar.equals("A")) {
                absentCount++;
                if(absentCount > 1) {
                    return false;
                }
                flagForPreviousLate = false;
                continousLateCount = 0;
            }
            if(currentChar.equals("L")) {
                continousLateCount++;
                if(continousLateCount > 2) {
                    return false;
                }
            }
            if(currentChar.equals("P")) {
                flagForPreviousLate = false;
                continousLateCount = 0;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        P551_StudentAttendance mainObject = new P551_StudentAttendance();
        System.out.println(mainObject.checkRecord("PPALLP"));
        System.out.println(mainObject.checkRecord("PPALLL"));

    }
}
