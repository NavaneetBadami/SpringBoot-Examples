package com.group.java8.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Java11Examples {

    public static void main(String[] args) {

        String str = "  Geeks\nFor \n Geeks ";
        System.out.println("------ \n"+str.lines().collect(Collectors.toList()));
        System.out.println("------ \n"+str.repeat(3));
        System.out.println("------ \n"+str.stripLeading());
        System.out.println("------ \n"+str.stripTrailing());


        //Note that this feature is available only for local variables with the initializer. It cannot be used for member variables, method parameters, return types, etc
        var message = "Hello, Java 10";
        //var n; // error: cannot use 'var' on variable without initializer
        //var emptyList = null; // error: variable initializer is 'null'
        //public var = "hello"; // error: 'var' is not allowed here
        //var p = (String s) -> s.length() > 10; // error: lambda expression needs an explicit target-type
        //var arr = { 1, 2, 3 }; // error: array initializer needs an explicit

        testInter tt =(String s) -> System.out.println(s.toUpperCase()); // target-type
        tt.display("testing DATA");

        List dt = Arrays.asList("Navaneet",1,"Data",false);
        var dd = dt.stream().map(e -> e.toString()).collect(Collectors.toList());
        System.out.println(dd);

        var empList = new ArrayList<>();

    }
}

@FunctionalInterface
interface  testInter {

     void display(String s);

}
