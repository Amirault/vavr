/**    / \____  _    ______   _____ / \____   ____  _____
 *    /  \__  \/ \  / \__  \ /  __//  \__  \ /    \/ __  \   Javaslang
 *  _/  // _\  \  \/  / _\  \\_  \/  // _\  \  /\  \__/  /   Copyright 2014 Daniel Dietrich
 * /___/ \_____/\____/\_____/____/\___\_____/_/  \_/____/    Licensed under the Apache License, Version 2.0
 */
package javaslang.collection;

import java.util.Comparator;
import java.util.Iterator;

public interface Seq<T> extends Traversable<T> {

    Seq<T> append(T element);

    Seq<T> appendAll(Iterable<? extends T> elements);

    T get(int index);

    int indexOf(T element);

    Seq<T> insert(int index, T element);

    Seq<T> insertAll(int index, Iterable<? extends T> elements);

    default Iterator<T> iterator(int index) {
        return subsequence(index).iterator();
    }

    int lastIndexOf(T element);

    Seq<T> prepend(T element);

    Seq<T> prependAll(Iterable<? extends T> elements);

    Seq<T> set(int index, T element);

    Seq<T> sort();

    Seq<T> sort(Comparator<? super T> c);

    Seq<T> subsequence(int beginIndex);

    Seq<T> subsequence(int beginIndex, int endIndex);
}
