package programming;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterfaces {


    private static Integer reduce;

    /**
     * @param args
     */
    public static void main (String[] args)
    {

        List<Integer> numbers =  List.of(12,9,13,4,6,4,12,15);

        Predicate<Integer> isEvenPredicate = x -> x%2==0;

        Function<Integer, Integer> squareFunction = x -> x * x;

        Consumer<Integer> sysoutConsumer = System.out::println;

        BinaryOperator<Integer> accumulator = Integer::sum;

        //Supplier - no input, return output => new object

        Supplier<Integer> randomIntegerSupplier = ()  -> 2;

        System.out.println(randomIntegerSupplier.get());


        Supplier<Integer> randomIntegerSupplierv2 = ()  -> {
            
            Random rand = new Random();
            return rand.nextInt(1000);
            };

            System.out.println(randomIntegerSupplierv2.get());

            UnaryOperator<Integer> unaryOperator = x -> 3*x;

            System.out.println(unaryOperator.apply(10));

        System.out.println(randomIntegerSupplier.get());

        BiPredicate<Integer, String> biPredicate = (number,str) ->  number<=10 && str.length()<5; 

        System.out.println(biPredicate.test(10, "test"));

        System.out.println(biPredicate.test(11, "test"));


        BiFunction<Integer,String,String> biFunction = (num,str) -> num + str;
		
System.out.println(biFunction.apply(10, "test"));

BiConsumer<String,String> biConsumer = (s1,s2) ->{  System.out.println(s1);
    System.out.println(s2);
};

biConsumer.accept("hello", "World");


		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				return x%2==0;
			}
			
		};

		//Function<Integer, Integer> squareFunction = x -> x * x;
		
		Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer x) {
				return x*x;
			}
			
		};
		
		
		//Consumer<Integer> sysoutConsumer = System.out::println;
		
		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
			public void accept(Integer x) {
				System.out.println(x);
			}
		};

        // numbers.stream()
        //         .filter(x -> x%2==0)
        //         .map(x->x*x)
        //         .forEach(System.out::println);


                // numbers.stream()
                // .filter(isEvenPredicate)
                // .map(squareFunction)
                // .forEach(sysoutConsumer);


                

               // BinaryOperator<Integer> accumulator = Integer::sum;

                BinaryOperator<Integer> accumulator2= new BinaryOperator<Integer>() {

                    @Override
                    public Integer apply(Integer t, Integer u) {
                       return t+u;
                    }
                    
                };
                //reduce = numbers.stream().reduce(0, accumulator);
        
    
    }

   
    
}
