package com.xu2023.december;

public class Gcd {

    public static int lcm(int a, int b) {
     return (a * b) / gcd(a, b);
    }
    public static int gcd(int a,  int b) {
      if(b == 0) {
          return a;
      }
      return gcd(b, a%b);
    }

    public static void main(String[] args) {
       int a = 24;
       int b = 16;

       int l= gcd(a, b);
       int r = lcm(a,b );
        System.out.println(l);
        System.out.println(r);
    }
}
