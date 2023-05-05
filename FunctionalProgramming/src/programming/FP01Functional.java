package programming;

import java.util.List;

public class FP01Functional {


    public static void main (String[] args)
    {
        printAllNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));
    }

    private static void print(int number)
    {
        System.out.println(number);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numberList) {

        //What to do? =>  method reference on static method, defining behaviour

        numberList.stream().forEach(FP01Functional::print);



            // for(Integer i : numberList)
            // {
            //     System.out.println(i);
            // }

            

    }
    
}
