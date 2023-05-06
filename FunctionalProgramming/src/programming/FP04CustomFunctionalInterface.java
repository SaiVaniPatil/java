package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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


    }


    
}
