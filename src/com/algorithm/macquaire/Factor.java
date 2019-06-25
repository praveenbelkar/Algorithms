package com.algorithm.macquaire;

import java.util.ArrayList;
import java.util.List;

public class Factor {
    public static long pthFactor(long n, long p) {
        // Write your code here
        List<Long> factors = getFactors(n);

        Integer index =  new Long(p).intValue();
        if(index > factors.size()) {
            return 0;
        }
        return factors.get(index-1);
    }

    private static List<Long> getFactors(long num) {
        List<Long> factors = new ArrayList<>();
        if(num == 1) {
            factors.add(1L);
            return factors;
        }
        long limit = 0;
        if(num % 2 == 1) {
            limit = num/3;
        } else {
            limit = num/2;
        }
        for(long i=1; i <= num/2; i++) {
            if(num%i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        System.out.println(pthFactor(1,1));
    }
}
