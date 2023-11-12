package org.example.lessons;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysLesson {
    private static int[] arrayMember; //array is an object so it's initialized as 'null'
    private static int arrayMember2[]; //just different syntax
    public static void runLessons(){
        initializing();
        copying();
        binarySearch();
        fillArray();
        sort();
        invert();
    }

    private static void initializing(){
        int[] array1 = new int[3]; //must use 'new'. All positions assume default value '0'
        array1[0] = 42;

        Integer[] arrayInteger = new Integer[3]; //All positions assume null;

        int[] array2 = {1, 2, 3};
        var length = array1.length; //property, not method
        int[] array3 = new int[]{1, 2, 3}; //can be used as literal inside method calls
    }

    private static void copying() {
        int[] array1 = {40, 41, 42};

        //clone creates a new array;
        int[] arrayClone = array1.clone();

        //System.arraycopy: copies 'n' items from one array into another existing array
        int[] minusOne1 = {-1, -1, -1, -1, -1};
        int length = 2;
        System.arraycopy(array1, 0, minusOne1, 1, length); //[-1 40 41 -1 -1 -1]
        //if I had the destination ending index instead of length, i'd have to call it like
        int[] minusOne2 = {-1, -1, -1, -1, -1};
        int startPos = 1;
        int endPos = 3;
        System.arraycopy(array1, 0, minusOne2, 1, endPos-startPos); //[-1 40 41 -1 -1 -1]

        //Arrays.copyOfRange: 'from' is inclusive, 'to' is exclusive. Parameters are not based in 'n' elements
        int[] brandNewCopied1 = Arrays.copyOfRange(array1, startPos, endPos); // [41 42]
        //If I had length instead of indexes
        int[] brandNewCopied2 = Arrays.copyOfRange(array1, startPos, startPos+length); // [41 42]
    }

    private static void binarySearch(){
        int[] array1 = {10, 11, 12, 13, 14};
        int i = Arrays.binarySearch(array1, 12); //2
    }

    private static void fillArray(){
        int[] array1 = new int[50];
        Arrays.fill(array1, -1);
    }

    private static void sort(){
        int[] array1 = {10, 9, 8, 7, 6, 5, 0, 1, 2, 3, 4};
        Arrays.sort(array1);

        int[] array2 = {10, 9, 8, 7, 6, 5, 0, 1, 2, 3, 4};
        Arrays.parallelSort(array2);
    }

    private static void invert(){
        Integer[] original = {1, 2, 3, 4, 5};
        Integer[] array2 = original.clone();
        invertUsingFor(array2);

        Integer[] array3 = original.clone();
        List<Integer> list3 = Arrays.asList(array3);
        Collections.reverse(list3);
        list3.toArray(array3);
    }

    private static void invertUsingFor(Object[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Object temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}
