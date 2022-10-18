package com.company.gfg;

public class MinimumNoCoin {

    public static void main(String[] args)
    {
        System.out.println(minimumNumberOfCoins(new int[]{ 2,2},2,10));
    }


    public static int minimumNumberOfCoins(int coins[],int numberOfCoins,int value)
    {if (value == 0) return 0;

         int result =Integer.MAX_VALUE;

        for (int i=0; i<numberOfCoins; i++)
        {
            if (coins[i] <= value)
            {
                int buffer =  minimumNumberOfCoins(coins, numberOfCoins, value-coins[i]);

                if (buffer != Integer.MAX_VALUE && buffer + 1 < result)
                    result = buffer + 1;
            }
        }
        return result;
    }
}
