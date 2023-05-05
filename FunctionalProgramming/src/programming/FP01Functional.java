package programming;

import java.util.List;

public class FP01Functional {


    public static void main (String[] args)
    {
        //printAllNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));
   
        //printEvenNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));
        
        //printEvenNumbersInListFunctionalUsinglambda(List.of(12,9,13,4,6,2,4,12,15));
    
        printOddNumbersInListFunctionalUsinglambda(List.of(12,9,13,4,6,2,4,12,15));

        List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");

        printCoursesFunctional(courses);

        printSpringCourses(courses);
    
        printCourseswith4Letters(courses);
    
    
    }

    private static void printCourseswith4Letters(List<String> courses) {

        System.out.println("Print courses with atleast 4 letters only => printCourseswith4Letters:");


        courses.stream().filter(course -> course.length()>=4).forEach(System.out::println);
    }

    private static void printSpringCourses(List<String> courses) {

        System.out.println("Print course with Spring word in them => printSpringCourses:");


        courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
    }

    private static void printCoursesFunctional(List<String> courses) {

        System.out.println("Print course => printCoursesFunctional:");


        courses.stream().forEach(System.out::println);
    }

    private static void printOddNumbersInListFunctionalUsinglambda(List<Integer> numberList) {

        System.out.println("Print odd numbers printOddNumbersInListFunctionalUsinglambda:");

        numberList.stream().filter(num -> num%2!=0).forEach(System.out::println);
    }

    private static void printEvenNumbersInListFunctionalUsinglambda(List<Integer> numberList) {
    
        System.out.println("Print even numbers printEvenNumbersInListFunctionalUsinglambda:");

        numberList.stream().filter(num -> num%2==0).forEach(System.out::println);

    
    }

    private static boolean isEven(int number)
    {
        return number%2==0;

    }

    private static void printEvenNumbersInListFunctional(List<Integer> numberList) {

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
