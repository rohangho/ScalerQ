package com.company.gfg;

public class Sum_of_digit {

    public static void main(String[] args)
    {
        System.out.println(sumOfDigits(2));
    }
    static int sum =0;

    static   int sumOfDigits(int n)
    {
       if(n>=0 && n<=9)
       {
           sum = sum +n;
          return sum;
       }

       sum =sum + n %10;
       sumOfDigits(n/10);
       return sum;
    }

}
