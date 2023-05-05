package programming;

import java.util.List;

public class FP02Functional{

    public static void main (String[] args)
    {

        List<Integer> numbers =  List.of(12,9,13,4,6,4,12,15);
        
        // int sum = addNumbersinList(numbers);

        // System.out.println(sum);

        // int sum2 = addNumbersinListLamda(numbers);

        // System.out.println(sum2);

        // int sum3 = addNumbersinListLamda(numbers);

        // System.out.println(sum3);

        //exercises
        //  System.out.println("sumOfSquares =>"+ sumOfSquares(numbers));
        //  System.out.println("sumOfCubes =>"+ sumOfCubes(numbers));
        //  System.out.println("sumOfOdds =>"+ sumOfOdds(numbers));
        //  System.out.println("distinctNumbers =>");

        //   distinctNumbers(numbers);

          System.out.println("sortednNumbers =>");

          sortednNumbers(numbers);

    }

    private static void sortednNumbers(List<Integer> numbers) {

      numbers.stream().sorted().forEach(System.out::println);
    }

    private static void distinctNumbers(List<Integer> numbers) {
       numbers.stream().distinct().forEach(System.out::println);;
    }

    private static int sumOfOdds(List<Integer> numbers) {
      return numbers.stream().filter(num -> num%2!=0).reduce(0,(num1,num2)->num1+num2);
    }

    private static int sumOfCubes(List<Integer> numbers) {
      return numbers.stream().map(num -> num*num*num).reduce(0,(num1,num2)->num1+num2); 
    }

    private static int sumOfSquares(List<Integer> numbers) {

      return numbers.stream().map(num -> num*num).reduce(0,(num1,num2)->num1+num2);
    }

    public static int sum(int aggregatesum, int nextnumber)
    {

      System.out.println(aggregatesum + " " + nextnumber);
      return aggregatesum+nextnumber;
    }

    private static int addNumbersinList(List<Integer> numbers) {
      
      //combine all to single result
      
      return numbers.stream().reduce(0,FP02Functional::sum);
    }

    private static int addNumbersinListLamda(List<Integer> numbers) {
      
      //combine all to single result
      
      return numbers.stream().reduce(0,(num1,num2)->num1+num2);

    
    }

    private static int addNumbersinListmethodReference(List<Integer> numbers) {
      
      //combine all to single result
      
     
      return numbers.stream().reduce(0,Integer::sum);
    }


}
