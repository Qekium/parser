package ru.qekium.parser.functional;

import java.util.Comparator;

public class FunctionalClass {
    public void creator(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1 - integer;
            }
        };

        comparator.compare(10, 9);
        Computable computable;
        computable = (i1, i2) -> i1 + i2 + 10 * 100;
        computable.compute(10, 10);

    }
}
