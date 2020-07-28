package com.mjq.common;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        addA(list);
        addB(list);
        System.out.println(list.size());
    }


    public static void addA(List<String> list) {
        list.add("A");
    }

    public static void addB(List<String> list) {
        list.add("B");
    }
}
