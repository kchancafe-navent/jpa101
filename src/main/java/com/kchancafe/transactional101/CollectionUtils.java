package com.kchancafe.transactional101;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {

    public static <E> List<E> toList(Iterable<E> iterable) {
        if (iterable == null) {
            return new ArrayList<>();
        }
        List<E> list = new ArrayList<>();
        for (E o : iterable) {
            list.add(o);
        }
        return list;
    }

    public static <E> Iterable<E> toIterable(List<E> list) {
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }

}
