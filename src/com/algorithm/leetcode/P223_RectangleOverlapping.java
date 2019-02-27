package com.algorithm.leetcode;

/**
 * https://leetcode.com/problems/rectangle-area/
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner
 * as shown in the figure.
 *
 * Example:

 Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 Output: 45
 */
public class P223_RectangleOverlapping {

    public static class Rectanlge {
        int leftBottomX;
        int leftBottomY;
        int rightTopX;
        int rightTopY;

        public Rectanlge(int leftBottomX, int leftBottomY, int rightTopX, int rightTopY) {
            this.leftBottomX = leftBottomX;
            this.leftBottomY = leftBottomY;
            this.rightTopX = rightTopX;
            this.rightTopY = rightTopY;
        }
    }
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        Rectanlge firstRectangle = getFirstRectangle(A, B, C, D, E, F, G, H);
        Rectanlge secondRectangle = getSecondRectangle(A, B, C, D, E, F, G, H);
        int area1 = getArea(firstRectangle);
        int area2 = getArea(secondRectangle);

        if(notOverlapping(firstRectangle, secondRectangle)) {
            return area1 + area2;
        }
        if(secondRectangleIsWithinFirstRectangle(firstRectangle, secondRectangle)) {
            return area1;
        }
        int area3 = getOverlappingArea(firstRectangle, secondRectangle);
        return  area1 + area2 - area3;
    }

    private boolean secondRectangleIsWithinFirstRectangle(Rectanlge firstRectangle, Rectanlge secondRectangle) {
        return secondRectangle.leftBottomX > firstRectangle.leftBottomX &&
               secondRectangle.rightTopY < firstRectangle.rightTopY &&
                secondRectangle.rightTopX < firstRectangle.rightTopX;
    }

    private int getOverlappingArea(Rectanlge firstRectangle, Rectanlge secondRectangle) {
        if(secondRectangle.leftBottomY > firstRectangle.leftBottomY &&
                secondRectangle.leftBottomX > firstRectangle.leftBottomX) {
          int side1 = firstRectangle.rightTopX - secondRectangle.leftBottomX;
          int side2 = firstRectangle.rightTopY - secondRectangle.leftBottomY;
          return side1 * side2;
        }

        /*if(secondRectangle.leftBottomX > firstRectangle.leftBottomX &&
                secondRectangle.rightTopY > firstRectangle.rightTopY) {*/
        else {
            int side1 = firstRectangle.rightTopX - secondRectangle.leftBottomX;
            int side2 = secondRectangle.rightTopY - firstRectangle.leftBottomY;
            return side1 * side2;
        }
        //return 0;
    }

    private boolean notOverlapping(Rectanlge firstRectangle, Rectanlge secondRectangle) {
        if(secondRectangle.leftBottomX > firstRectangle.rightTopX) {
            return true;
        }
        if(secondRectangle.leftBottomY > firstRectangle.rightTopY) {
            return true;
        }
        if(firstRectangle.leftBottomY > secondRectangle.rightTopY) {
            return true;
        }
        return false;
    }

    private Rectanlge getSecondRectangle(int a, int b, int c, int d, int e, int f, int g, int h) {
        Rectanlge rectangle1 = new Rectanlge(a,b,c,d);
        Rectanlge rectangle2 = new Rectanlge(e,f,g,h);

        return a < e ? rectangle2 : rectangle1;
    }

    private Rectanlge getFirstRectangle(int a, int b, int c, int d, int e, int f, int g, int h) {
        Rectanlge rectangle1 = new Rectanlge(a,b,c,d);
        Rectanlge rectangle2 = new Rectanlge(e,f,g,h);

        return a < e ? rectangle1 : rectangle2;
    }

    private int getArea(Rectanlge rectangle) {
        int side1 = rectangle.rightTopX - rectangle.leftBottomX;
        int side2 = rectangle.rightTopY - rectangle.leftBottomY;
        return side1 * side2;
    }

    public static void main(String[] args) {
        P223_RectangleOverlapping mainObject = new P223_RectangleOverlapping();
        int A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2;
        System.out.println(mainObject.computeArea(A,B,C,D,E,F,G,H));
    }
}
