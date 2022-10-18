package com.company.gfg;

public class NumberofWaysCoin_UnLimitedCoin {

    public static void main(String[] args)
    {
        System.out.println(numberOfWays(new int[]{2,5,3,6},4,10));
    }



    public static int numberOfWays(int coins[],int numberOfCoins,int value)
    {
        if(value == 0)
            return 1;
        if(numberOfCoins == 0)
            return  0;

        int res = numberOfWays(coins,numberOfCoins-1,value);
        if(coins[numberOfCoins-1]<=value)
            res = res + numberOfWays(coins,numberOfCoins,value-coins[numberOfCoins-1]);

        return res;


    }
}
