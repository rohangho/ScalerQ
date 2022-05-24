package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {



    public static void main(String[] args) throws InterruptedException, IOException {

        String command = "adb devices";

        Process proc = Runtime.getRuntime().exec(command);
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line = "";
        while((line = reader.readLine()) != null) {
            System.out.print(line + "\n");
        }

        proc.waitFor();
    }

    static ArrayList<Integer> output = new ArrayList<>();
    static ArrayList<Integer> sameArray = new ArrayList<>();

    public static int solve(ArrayList<Integer> A) {
        sameArray = A;
        output.add(A.get(0));
        if(A.size()>1)
            findMax(1,A.size()-1);
        Collections.sort(output,Collections.reverseOrder());
        return output.get(0);
    }

    private static void findMax(int index ,int totalSize) {
        if(index == totalSize)
        {
            return;
        }
        output.add(Math.max((output.get(index-1)*sameArray.get(index)),sameArray.get(index)));
        findMax(index+1,totalSize);
    }


    static int[] awseomeSort(int N, int[] arr){
        ArrayList<Integer> freq = new ArrayList<>();
        for(int i =0;i<N;i++)
            freq.add(0);
        for(int i =0;i<arr.length;i++)
        {
           freq.set(arr[i]% N,freq.get(arr[i]% N)+1);

        }

return null;
    }
}
