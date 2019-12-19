package com.guava.list;

import com.google.common.collect.Lists;
import java.util.ArrayList;

public class TravalList {

    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.stream().forEach(item -> {
            System.out.println("item=" + item);
        });
    }
}
