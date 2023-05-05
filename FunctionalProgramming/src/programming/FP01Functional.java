package programming;

import java.util.List;

public class FP01Functional {


    public static void main (String[] args)
    {
        printAllNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));
   
        printEvenNumbersInListStructured(List.of(12,9,13,4,6,2,4,12,15));
    }

    private static boolean isEven(int number)
    {
        return number%2==0;

    }

    private static void printEvenNumbersInListStructured(List<Integer> numberList) {

        System.out.println("Print even numbers:");

        numberList.stream().filter(FP01Functional::isEven).forEach(System.out::println);

    }

    private static void print(int number)
    {
        System.out.println(number);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numberList) {

        //What to do? =>  method reference on static method, defining behaviour

       // numberList.stream().forEach(FP01Functional::print); is same as below


        numberList.stream().forEach(System.out::println);


            // for(Integer i : numberList)
            // {
            //     System.out.println(i);
            // }

            

    }
    
}
