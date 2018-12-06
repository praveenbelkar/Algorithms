package com.algorithm.praveen.recursion;

public class TowerOfHanoi {

    public void tower(int n, int src, int dst, int aux) {
        if(n==1) {
            System.out.println("Move top disk from " + src + " to " + dst );
            return;
        }
        tower(n-1, src, aux, dst);
        tower(1, src, dst, aux);
        tower(n-1, aux, dst, src);
    }

    public static void main(String[] args) {
        TowerOfHanoi mainObject = new TowerOfHanoi();
        mainObject.tower(3, 1,2,3);
    }
}
