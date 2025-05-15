package com.java.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableSampla implements Comparable<ComparableSampla>{

    private String name;
    private int age;

    ComparableSampla(String name, int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(ComparableSampla comparableSampla) {
       return  this.age - comparableSampla.age;
    }

    public static void main(String[] args) {
        ComparableSampla sampla = new ComparableSampla("aaa", 20);
        ComparableSampla sampla1 = new ComparableSampla("bb", 15);
        ComparableSampla sampla2 = new ComparableSampla("cc", 18);
        List<ComparableSampla> list = new ArrayList<>();
        list.add(sampla);
        list.add(sampla1);
        list.add(sampla2);

        Collections.sort(list);
        for(ComparableSampla i : list){
            System.out.println(i);
        }
    }

     @Override
    public String toString() {
        return name + " (" + age + ")";
    }
    
}
