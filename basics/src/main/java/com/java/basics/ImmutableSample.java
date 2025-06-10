package com.java.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class as final 
 * fields private final
 * constructor -> Deep copy 
 * NO setters
 * only getters
 * object -> eturn Collections.unmodifiableList(list);
 list
 */
public final class ImmutableSample {  
    private final int age;
    private  final String name;
    private final List<String> list ;

    ImmutableSample(int age, String name , List<String> list){

        this.age = age;
        this.name = name;
        this.list = new ArrayList<>(list); // deep cpoy 
    }

    public List<String> getList(){
        return Collections.unmodifiableList(list);
    }

    public static void main(String[] args) {
        ImmutableSample immutableSample = new ImmutableSample(1,"aa",Arrays.asList("a"));
        immutableSample.getList().forEach(System.out::println);
    }
    
}
