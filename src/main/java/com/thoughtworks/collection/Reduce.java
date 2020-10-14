package com.thoughtworks.collection;

import org.apache.commons.lang3.NotImplementedException;

import java.math.BigDecimal;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public double getAverage() {

        Integer result = arrayList.stream().reduce(0, (sum,current) -> {
            sum += current;
            return sum;
        });
        return new BigDecimal(result).divide(new BigDecimal(arrayList.size())).doubleValue();

    }

    public int getMaxValue() {

        return arrayList.stream().reduce(0, Integer::max);
    }

    public int getLastOdd() {
        return arrayList.stream().filter(integer -> integer % 2 == 1).reduce((first, second) -> second).get();
    }
}
