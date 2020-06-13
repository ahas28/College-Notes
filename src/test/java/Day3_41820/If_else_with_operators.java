package Day3_41820;

public class If_else_with_operators {


    public static void main(String[] args) {

        //scenario is if students grade is 90 to 100 than it's A
        //if student grade is 80 to below 90 then it's B
        //if student grade is 70 to below 80 then it's C
        //if anything below C is failure (F)

        //define a variable which will response grade number
        int grade = 91;

        //&& represents an operators in java
        //&& and operator all conditions has to be true
        // or operator one of the condition has to be true
        if (grade >= 90 && grade <= 100) {
            System.out.println("Students grade is A");
        } else if (grade >= 80 && grade < 90) {
            System.out.println("Students grade is B");
        } else if (grade >= 70 && grade < 80) {
            System.out.println("Students grade is C");
        } else {
            System.out.println("Students grade is F");
        }//end of conditional statements


    }//end of main method


}//end of java class
