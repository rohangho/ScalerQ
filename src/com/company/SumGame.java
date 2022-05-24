package com.company;

public class SumGame {

    public static void main(String[] args)
    {
        sumGame("?329???");
    }


    public static boolean sumGame(String num) {
        if(!num.contains("?"))
            return winnerDetail(num);
        else
           return calculateDiff(num);
    }

   static int firstSum =0;
    static int secondSum =0;
   static int firstQuestionMark = 0;
    static int secondQuestionMark = 0;
    private static boolean calculateDiff(String num) {

        int mid  = (num.length())/2;


        for(int i =0;i<num.length();i++)
        {
            if(i<mid)
            {
                if(!num.contains("?"))
                    firstSum = firstSum + Character.getNumericValue(num.charAt(i));
                else
                    firstQuestionMark++;
            }
            else
            {
                if(!num.contains("?"))
                    secondSum = secondSum + Character.getNumericValue(num.charAt(i));
                else
                    secondQuestionMark++;
            }
        }

        while (firstQuestionMark+secondQuestionMark!=0)
        {
            alicePlay();
            bobPlay();
        }

        return winnerDetail(num.replace("?","0"));



    }

    private static void bobPlay() {
        if(firstSum>secondSum)
        {
            if(secondQuestionMark!=0)
            {
                if(firstSum-secondSum>=9) {
                    secondSum = secondSum + 9;
                    secondQuestionMark --;
                }
                else
                {
                    secondSum = secondSum + firstSum-secondSum;
                    secondQuestionMark --;
                }

            }
            else
            {
                firstQuestionMark--;
            }
        } else if (secondSum>firstSum) {
            if(firstQuestionMark!=0)
            {
                if(secondSum-firstSum>=9) {
                    firstSum = firstSum + 9;
                    firstQuestionMark--;
                }
                else
                {
                    firstSum = firstSum + secondSum -firstSum;
                    firstQuestionMark--;
                }
            }else
            {
                secondQuestionMark --;
            }

        }
        else
        {
            if(firstQuestionMark!=0) {
                firstQuestionMark--;
            }
            else if(secondQuestionMark != 0)
            {
                secondQuestionMark--;
            }
        }
    }

    private static void alicePlay() {
        if(firstSum>secondSum)
        {
            if(firstQuestionMark!=0) {
                firstSum = firstSum + 9;
                firstQuestionMark--;
            }
            else
            {
               if(firstSum-secondSum >= 9)
                   secondQuestionMark--;
               else
               {
                   secondSum=secondSum+9;
                   secondQuestionMark--;
               }
            }
        }
        else if (firstSum<secondSum)
        {
            if(secondQuestionMark!=0) {
                secondSum = secondSum + 9;
                secondQuestionMark--;
            }
            else
            {
                if(secondSum-firstSum >= 9)
                  firstQuestionMark--;
                else {
                    firstSum = firstSum + 9;
                    firstQuestionMark--;
                }

            }
        }
        else
        {
            if(firstQuestionMark!=0) {
                firstSum = firstSum + 9;
                firstQuestionMark--;
            }
            else if(secondQuestionMark != 0)
            {
                secondSum = secondSum + 9;
                secondQuestionMark--;
            }
        }
    }


    public static boolean winnerDetail(String num)
    {
        int mid  = (num.length())/2;
        int first =0;
        int second =0;
        for(int i =0;i<num.length();i++)
        {
            if(i<mid)
                first=first+Character.getNumericValue(num.charAt(i));
            else
                second = second+Character.getNumericValue(num.charAt(i));
        }

        if(first==second)
            return false;
        else
            return true;

    }

}
