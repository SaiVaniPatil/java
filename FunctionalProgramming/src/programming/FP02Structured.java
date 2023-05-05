package programming;

import java.util.List;

public class FP02Structured{

    public static void main (String[] args)
    {

        List<Integer> numbers =  List.of(12,9,13,4,6,4,12,15);
        
        int sum = addNumbersinList(numbers);

        System.out.println(sum);

    }

    private static int addNumbersinList(List<Integer> numbers) {
      int sum =0;

      for(Integer num : numbers)
      {
        sum = sum+num;
      }

      return sum;
    }

}
