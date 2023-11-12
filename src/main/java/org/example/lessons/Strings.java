package org.example.lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Strings {
    public static void runLessons(){
        stringPool();
        arrayToString();
        listToString();
    }

    private static void stringPool(){
        //Strings created from equals are added automatically to the string pool
        String string1equal = "text"; //added to string pool
        String string2equal = "text"; //just a reference to a string that already exists
        boolean literalsSameMemory = string1equal == string2equal; //true since they are reference to same memory address

        String newString = new String("text"); //forcefully creating a new string in a new memory address
        boolean newStringAndLiteralSameMemory = newString == string1equal; //false

        String interned = newString.intern(); //adds an isolated string to the pool
        boolean internedAndLiteralSameMemory = string1equal == interned; //true
    }

    private static void arrayToString(){
        char[] array1 = {'a','b','a','c','a','t','e'};
        String string1 = Arrays.asList(array1).stream()
                .map(c -> String.valueOf(c))
                .reduce("", (acc, string2) -> acc + string2);

        char[] array2 = new char[string1.length()];
        string1.getChars(0, string1.length(), array2, 0);

        char[] array3 = string1.toCharArray();
    }

    private static void listToString(){
        List<Character> list1 = List.of('a', 'b', 'a', 'c', 'a', 't', 'e');
        String string1 = list1.toString();
        List<Character> collect = string1.chars()
                .mapToObj(c -> (char) c)
                .toList();
    }
}
