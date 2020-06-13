package Action_Items;


class Action_Item_1 {

    public static void main(String[] args) {

        //Declaring the variable
        String[] zipCode;
        int[] houseNumber;


        //input in index variable.
        zipCode = new String[4];
        zipCode  [0] =  "00501";
        zipCode  [1] =  "00544";
        zipCode  [2] =  "06390";
        zipCode  [3] =  "10001";

        //Defining the integer variables
        houseNumber = new int[4];
        houseNumber [0] = 2;
        houseNumber [1] = 3;
        houseNumber [2] = 4;
        houseNumber [3] = 5;
        for (int i = 0; i <= 3; i++) {
            System.out.println("My zipCode is" + zipCode[1] + " and my street number is " + houseNumber[1]);
            //int i 0;
            //while (i <= 3) {
            //  System.out.println("My zipCode is" + zipCode [1] + and my street number is + houseNumber [1]);
            //i= i + i;
        }//end of for loop

    }//end of the method

}//end of the class