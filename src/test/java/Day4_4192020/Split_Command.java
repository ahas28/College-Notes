package Day4_4192020;

public class Split_Command {

    public static void main (String[] args) {



        //create a string message first and store it as single string
        String message = "Welcome to Selenium Automation Class";


        //i want to only print the keyword 'Selenium' from my message variable
        //we need to define String array variable in order  to split the message
        String[] arrayResult = message.split ( " ");
        //print the  result
        System.out.println("My final message is"+ arrayResult[2]);

        String[] array2 = arrayResult[1].split ( " ");
        //print the  result
        System.out.println("My new message is " + array2[1]);

    //you want to print out to & class
        System.out.println("My to keyword is " + array2[0] +  " my class keyword is " + arrayResult[3]);

    }//end of main method
}//end of java class
