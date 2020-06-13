package Day3_41820;

class method_execution_class {

    public static void main(String[] args) {

        //call the method to be executed
        Custom_Methods.voidAdd( 100, 200);

        //call the return add method
        int c = Custom_Methods.returnAdd( 200, 300);
        //add the value with the result below
        System.out.println("new results is" + (c-25));

    }//end of main

}//end of java class
