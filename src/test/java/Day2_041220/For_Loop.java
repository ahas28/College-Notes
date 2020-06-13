package Day2_041220;

public class For_Loop {


    public static void main (String[] args) {

        String[] states = new String[4];
        states[0] = "New York";
        states[1] = "California";
        states[2] = "Ohio";
        states[3] = "Arizona";
        states[4] = "Nevada";


        //printing all the states from 0 to last value in sequence
        //i++ each time is adding +1 to i
        //i represents you initial /starting point of you index
        for (int i = 0; i < states.length; i++) {
            System.out.println("My State is" + states[i]);
        }


    }//end of main method



}//end of class
