package programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Course{

    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;
    

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getReviewScore() {
        return reviewScore;
    }
    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }
    public int getNoOfStudents() {
        return noOfStudents;
    }
    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Course [name=" + name + ", category=" + category + ", reviewScore=" + reviewScore + ", noOfStudents="
                + noOfStudents + "]";
    }

    
    

}

public class FP04CustomFunctionalInterface {

    public static void main(String[] args) {
        
        List<Course> courses = List.of(new Course("Spring","Framework",98,2000),
        new Course("Spring Boot","Framework",95,18000),
        new Course("API","MicroServices",96,21000),
        new Course("MicroServices","MicroServices",91,20400),
        new Course("FullStack","FullStack",88,20600),
        new Course("AWS","Cloud",99,2000),
        new Course("Azure","Cloud",86,1000),
        new Course("Docker","Cloud",80,11000),
        new Course("Kubernetes","Cloud",81,12000));

       Predicate<? super Course> reviewgreaterthan90 = course -> course.getReviewScore()>90;

       Predicate<? super Course> reviewGreaterthan80 = course -> course.getReviewScore()>=80;


        System.out.println(courses.stream().allMatch(reviewgreaterthan90));

        System.out.println("none match : "+courses.stream().noneMatch(reviewgreaterthan90));

        
        System.out.println("any match : "+courses.stream().anyMatch(reviewgreaterthan90));

       // System.out.println(courses.stream().allMatch(reviewGreaterthan80));

        Comparator<Course> comparingByNoOfStudents = Comparator.comparing(Course::getNoOfStudents);

       List<Course> newCourseList = courses.stream().sorted(comparingByNoOfStudents).collect(Collectors.toList());

       System.out.println("comparingByNoOfStudents: "+newCourseList);

       Comparator<Course> comparingByNoOfStudentsDesc = Comparator.comparing(Course::getNoOfStudents).reversed();

       newCourseList = courses.stream().sorted(comparingByNoOfStudentsDesc).collect(Collectors.toList());

       System.out.println("comparingByNoOfStudentsDesc: "+newCourseList);

        Comparator<Course> comparingByNoOfStudentsandReviews = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore);

       newCourseList = courses.stream().sorted(comparingByNoOfStudents).collect(Collectors.toList());

       System.out.println("comparingByNoOfStudentsandReviews: "+newCourseList);


        System.out.println( "limit example : "+courses.stream().sorted(comparingByNoOfStudentsandReviews).limit(5).collect(Collectors.toList()));

        System.out.println( "skip example : "+courses.stream().sorted(comparingByNoOfStudentsandReviews).skip(3).collect(Collectors.toList()));

        System.out.println("take while: "+courses.stream().takeWhile(course->course.getReviewScore()>95).collect(Collectors.toList()));

        System.out.println("drop while : "+courses.stream().dropWhile(course->course.getReviewScore()>95).collect(Collectors.toList()));
        
        //returns last element in list
        System.out.println("max course : "+courses.stream().max(comparingByNoOfStudents));

        //returns first element in list
        System.out.println("max course : "+courses.stream().min(comparingByNoOfStudents));

        //optional use case output Optional.empty
        
        Predicate<? super Course> reviewLessThan80 = course -> course.getReviewScore()<80;
        System.out.println("max course optional : "+courses.stream().filter(reviewLessThan80).min(comparingByNoOfStudents));

        //we can add else when there is null to specify default case

       
        System.out.println("max course optional default case : "+courses.stream().filter(reviewLessThan80).min(comparingByNoOfStudents).orElse(new Course("Kubernetes","Cloud",81,12000)));


        //findFirst

        System.out.println("findfirst review>80 : "+courses.stream().filter(reviewGreaterthan80).findFirst());


        
        //findAny

        System.out.println("findAny review>80 : "+courses.stream().filter(reviewGreaterthan80).findAny());




        System.out.println("sum of students in courses review score>90: "+courses.stream().filter(reviewgreaterthan90).mapToInt(Course::getNoOfStudents).sum());

        System.out.println("average of students in courses review score>90: "+courses.stream().filter(reviewgreaterthan90).mapToInt(Course::getNoOfStudents).average());


        System.out.println("No of courses review score>90: "+courses.stream().filter(reviewgreaterthan90).mapToInt(Course::getNoOfStudents).count());


        System.out.println("No of courses review score>90: "+courses.stream().filter(reviewgreaterthan90).mapToInt(Course::getNoOfStudents).max());

        System.out.println("No of courses review score>90: "+courses.stream().filter(reviewgreaterthan90).mapToInt(Course::getNoOfStudents).min());


        //grouping

        System.out.println("grouping courses by category : "+courses.stream().collect(Collectors.groupingBy(Course::getCategory)));

        //group courses by category and count no of courses in them

        System.out.println("grouping courses count by category : "+courses.stream().collect(Collectors.groupingBy(Course::getCategory,Collectors.counting())));

        //group courses by category and  get highest reviewd course
        System.out.println("grouping courses and get get highest reviews course in each by category : "+courses.stream().collect(Collectors.groupingBy(Course::getCategory,Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

         //group courses by category and  get highest reviewd course
         System.out.println("grouping courses count by category : "+courses.stream().collect(Collectors.groupingBy(Course::getCategory,Collectors.mapping(Course::getName,Collectors.toList())))
         );


                //primitive streams

      int[] numArr = {12,9,13,4,6,4,12,15};

      System.out.println("primitive streams ex : " + Arrays.stream(numArr).sum());

      System.out.println("primitive streams ex : " + Arrays.stream(numArr));

      System.out.println("primitive streams ex : " + Stream.of(12,9,13,4,6,4,12,15));


      






    }


    
}
