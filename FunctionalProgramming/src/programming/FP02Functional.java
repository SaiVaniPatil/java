package programming;

import java.util.List;

public class FP02Functional{

    public static void main (String[] args)
    {

        List<Integer> numbers =  List.of(12,9,13,4,6,4,12,15);
        
        int sum = addNumbersinList(numbers);

        System.out.println(sum);

        int sum2 = addNumbersinListLamda(numbers);

        System.out.println(sum2);

    }

    public static int sum(int a, int b)
    {
      return a+b;
    }

    private static int addNumbersinList(List<Integer> numbers) {
      
      //combine all to single result
      
      return numbers.stream().reduce(0,FP02Functional::sum);
    }

    private static int addNumbersinListLamda(List<Integer> numbers) {
      
      //combine all to single result
      
      return numbers.stream().reduce(0,(num1,num2)->num1+num2);
    }

}
