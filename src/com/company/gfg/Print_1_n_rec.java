package com.company.gfg;

public class Print_1_n_rec {

    public static void main(String[] args)
    {
        printNos(5);
    }


    static public void printNos(int N) {
        if (N != 0) {
            printNos(N - 1);
            System.out.print(N+" ");

        }
    }

}
