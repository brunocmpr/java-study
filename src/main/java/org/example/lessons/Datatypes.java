package org.example.lessons;

import java.util.Objects;

public class Datatypes {
    private static int intMember1; //Members assume default value (0 in this case). Local scoped values do not.
    private static int intMember2 = 42; //I may assign an initial value
    private static Integer intObjMember1; //Since it's an object it will be null by default.
    private static Integer intObjMember2 = 42;


    public static void runLessons(){
        int int1 = 0; //since it's not a member it must be initilized, otherwise system won't build.
        printIntPrimitive(Datatypes.intMember1);
        printIntObject(Datatypes.intObjMember1);
        compareWrapperIntegers();
        numericConversion();
    }

    private static void printIntPrimitive(int value){
        System.out.println(value);
    }
    private static void printIntObject(Integer value){
        System.out.println(value);
    }
    private static void compareWrapperIntegers(){
        Integer int1 = 42;
        Integer int2 = 42;
        System.out.println("***** Comparing Integer with == *****");
        System.out.println(int1 == int2); //Works but IDE complains about == comparison between objects.
        System.out.println("***** Comparing Integer with equals() *****");
        System.out.println(Objects.equals(int1, int2));
    }

    private static void numericConversion(){
        long long1 = (long)Integer.MAX_VALUE; //2147483647
        long1 = long1 + 3; //2147483647 + 3 = //2147483650
        System.out.println("long1 = " + long1);
        int int1 = (int)long1;
        System.out.println("int1 = " + int1); //Does not work well since its interpreted as negative... -2147483646
    }

    private static void fromToString(){
        int int1 = 42;
        String string1 = Integer.toString(int1);
        int1 = Integer.parseInt(string1);

        Integer int3 = 42;
        String string3 = String.valueOf(int3); //It's the best to me since it's the one that works for chars

        Integer int2 = 42;
        String string2 = int2.toString();
    }
}
