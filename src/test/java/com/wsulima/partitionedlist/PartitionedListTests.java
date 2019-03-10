package com.wsulima.partitionedlist;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PartitionedListTests {

    @Test
    public void oneIntElement() {
        // GIVEN
        int initialListElem = 1;
        List testList = Arrays.asList(initialListElem);

        // WHEN
        List<List> partitionsList = PartitionedList.partition(testList, 1);

        // THEN
        assertThat(partitionsList).isNotNull().hasSize(1);
        assertThat(partitionsList.get(0)).isInstanceOf(List.class);

        List partition = partitionsList.get(0);
        assertThat(partition).hasSize(1);
        assertThat(partition.get(0)).isEqualTo(initialListElem);
    }

    @Test
    public void oneStringElem() {
        // GIVEN
        String initialListElem = "1";
        List testList = Arrays.asList(initialListElem);

        // WHEN
        List<List> partitionsList = PartitionedList.partition(testList, 1);

        // THEN
        assertThat(partitionsList).isNotNull().hasSize(1);
        assertThat(partitionsList.get(0)).isInstanceOf(List.class);

        List partition = partitionsList.get(0);
        assertThat(partition).hasSize(1);
        assertThat(partition.get(0)).isEqualTo(initialListElem);
    }

    @Test
    public void fiveElemsTwoSizePartition() {
        // GIVEN
        List testList = Arrays.asList("1", "2", "3", "4", "5");

        // WHEN
        List<List> partitions = PartitionedList.partition(testList, 2);

        // THEN
        assertThat(partitions).isNotNull().hasSize(3);
        assertThat(partitions.get(0)).hasSize(2).containsExactly("1", "2");
        assertThat(partitions.get(1)).hasSize(2).containsExactly("3", "4");
        assertThat(partitions.get(2)).hasSize(1).containsExactly("5");
    }

    @Test
    public void fiveElemsThreeSizePartition() {
        // GIVEN
        List testList = Arrays.asList("1", "2", "3", "4", "5");

        // WHEN
        List<List> partitions = PartitionedList.partition(testList, 3);

        // THEN
        assertThat(partitions).isNotNull().hasSize(2);
        assertThat(partitions.get(0)).hasSize(3).containsExactly("1", "2", "3");
        assertThat(partitions.get(1)).hasSize(2).containsExactly("4", "5");
    }

    @Test
    public void fiveElemsOneSizePartition() {
        // GIVEN
        List testList = Arrays.asList("1", "2", "3", "4", "5");

        // WHEN
        List<List> partitions = PartitionedList.partition(testList, 1);

        // THEN
        assertThat(partitions).isNotNull().hasSize(5);
        assertThat(partitions.get(0)).hasSize(1).containsExactly("1");
        assertThat(partitions.get(1)).hasSize(1).containsExactly("2");
        assertThat(partitions.get(2)).hasSize(1).containsExactly("3");
        assertThat(partitions.get(3)).hasSize(1).containsExactly("4");
        assertThat(partitions.get(4)).hasSize(1).containsExactly("5");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testErrorOnNegativeIndex() {
        // GIVEN
        List testList = Arrays.asList("1", "2", "3", "4", "5");

        // WHEN
        List<List> partitions = PartitionedList.partition(testList, 1);

        partitions.get(-5);

        // THEN throws exception
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testErrorOnExcedingIndex() {
        // GIVEN
        List testList = Arrays.asList("1", "2", "3", "4", "5");

        // WHEN
        List<List> partitions = PartitionedList.partition(testList, 1);

        partitions.get(1001);

        // THEN throws exception
    }

}
