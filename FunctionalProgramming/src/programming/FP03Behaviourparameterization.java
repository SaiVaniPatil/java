package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP03Behaviourparameterization {


    private static Integer reduce;

    /**
     * @param args
     */
    public static void main (String[] args)
    {

        List<Integer> numbers =  List.of(12,9,13,4,6,4,12,15);

        Predicate<? super Integer> evenPredicate = x -> x%2==0;

        //filterAndPrint(numbers, evenPredicate);

        Predicate<? super Integer> oddPredicate = x->x%2!=0;


        filterAndPrint(numbers, oddPredicate);

        System.out.println("numbers duvuded by 3");
        filterAndPrint(numbers, x -> x%3==0);

        Function<? super Integer, ? extends Integer> squareFunction = x -> x*x;


        List squaredNumbers = extracted(numbers, squareFunction);    
      

        
    }

    private static List<? extends Integer> extracted(List<Integer> numbers,
            Function<? super Integer, ? extends Integer> squareFunction) {
        return numbers.stream().map(squareFunction).collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
      
   
    
}
