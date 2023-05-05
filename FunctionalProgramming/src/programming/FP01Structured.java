package programming;

import java.util.List;

public class FP01Structured{

    public static void main (String[] args)
    {
        printAllNumbersInListStructured(List.of(12,9,13,4,6,2,4,12,15));
        printEvenNumbersInListStructured(List.of(12,9,13,4,6,2,4,12,15));
    }
    private static void printEvenNumbersInListStructured(List<Integer> numberList) {


        System.out.println("Print even numbers:");
        for(Integer i : numberList)
        {
            if(i%2==0)
            System.out.println(i);
        }
    }
    

    private static void printAllNumbersInListStructured(List<Integer> numberList) {

            for(Integer i : numberList)
            {
                System.out.println(i);
            }

            

    }
}
