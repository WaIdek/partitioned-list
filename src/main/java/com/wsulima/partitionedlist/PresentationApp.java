package com.wsulima.partitionedlist;

import java.util.Arrays;
import java.util.List;

public class PresentationApp {

    private static final List<String> list = Arrays.asList("1", "2", "3", "4", "5");

    public static void main(String[] args) {
        presentation(list, 1);
        presentation(list, 2);
        presentation(list, 3);
        presentation(list, 100);
    }

    private static void presentation(List list, int partitionSize) {
        print("Partitioning for list " + list.toString() + " and partition size " + partitionSize + ":");
        print(PartitionedList.partition(list, partitionSize).toString());
        print("---");
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
