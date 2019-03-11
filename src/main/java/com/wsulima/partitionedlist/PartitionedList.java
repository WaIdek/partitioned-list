package com.wsulima.partitionedlist;

import java.util.AbstractList;
import java.util.List;

/**
 * List's decorator dividing list into subpartitions of a given size.
 */
public class PartitionedList<T> extends AbstractList<List<T>> {

    private final List<T> baseList;
    private final int partitionSize;

    /**
     * Constructor
     *
     * @param list          list to partition
     * @param partitionSize partition size
     */
    public PartitionedList(List<T> list, int partitionSize) {
        this.baseList = list;
        this.partitionSize = partitionSize;
    }

    /**
     * Static method giving as a result a list of given list's subpartitions
     *
     * @param list list to partition
     * @param size partition size
     * @return list of subpartitions lists
     */
    public static <T> List<List<T>> partition(List<T> list, int size) {
        return new PartitionedList(list, size);
    }


    /**
     * @inheritdoc
     */
    @Override
    public List<T> get(int index) {
        final int numberOfPartitions = this.size();

        if (index < 0) throw new IndexOutOfBoundsException("Index can't be a negative number");
        if (index >= numberOfPartitions)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size:" + numberOfPartitions);

        final int start = index * partitionSize;
        final int end = Math.min(start + partitionSize, baseList.size());
        return baseList.subList(start, end);
    }

    /**
     * @inheritdoc
     */
    @Override
    public int size() {
        return (baseList.size() + partitionSize - 1) / partitionSize;
    }

    /**
     * @inheritdoc
     */
    @Override
    public boolean isEmpty() {
        return this.baseList.isEmpty();
    }
}
