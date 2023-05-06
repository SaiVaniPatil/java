package programming;

import java.util.List;
import java.util.function.Supplier;

public class Fp03MethodReferences {


    private static void print(String str)
    {
        System.out.println(str);
    }

    public static void main(String[] args) {

          List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");

          courses.stream()
          .map(str -> str.toUpperCase())
          .forEach(System.out::println);

          System.out.println("static method reference");

          courses.stream()
          .map(str -> str.toUpperCase())
          .forEach(Fp03MethodReferences::print);

          System.out.println("instance method reference");

          courses.stream()
          .map(String::toUpperCase)
          .forEach(Fp03MethodReferences::print);

            Supplier<String> supplier = () -> new String();

            System.out.println("constructor reference");
            Supplier<String> supplier2 = String::new;
        
    }
    
}
