/**    / \____  _    ______   _____ / \____   ____  _____
 *    /  \__  \/ \  / \__  \ /  __//  \__  \ /    \/ __  \   Javaslang
 *  _/  // _\  \  \/  / _\  \\_  \/  // _\  \  /\  \__/  /   Copyright 2014-2015 Daniel Dietrich
 * /___/ \_____/\____/\_____/____/\___\_____/_/  \_/____/    Licensed under the Apache License, Version 2.0
 */
package javaslang.control;

import javaslang.Tuple;
import javaslang.Tuple0;
import javaslang.algebra.HigherKinded1;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * None is a singleton representation of the undefined {@link javaslang.control.Option}. The instance is obtained by
 * calling {@link #instance()}.
 *
 * @param <T> The type of the optional value.
 */
public final class None<T> implements Option<T> {

    private static final long serialVersionUID = 1L;

    /**
     * The singleton instance of None.
     */
    private static final None<?> INSTANCE = new None<>();

    /**
     * Hidden constructor.
     */
    private None() {
    }

    /**
     * <p>
     * Returns the singleton instance of None as {@code None<T>} in the context of a type {@code <T>}, e.g.
     * </p>
     * <pre>
     * <code>final Option&lt;Integer&gt; o = None.instance(); // o is of type None&lt;Integer&gt;</code>
     * </pre>
     *
     * @param <T> The type of the optional value.
     * @return None
     */
    public static <T> None<T> instance() {
        @SuppressWarnings("unchecked")
        final None<T> none = (None<T>) INSTANCE;
        return none;
    }

    @Override
    public T get() {
        throw new NoSuchElementException("No value present");
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Tuple0 unapply() {
        return Tuple.empty();
    }

    @Override
    public boolean equals(Object o) {
        return o == this;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }

    @Override
    public String toString() {
        return "None";
    }

    // -- Serializable implementation

    /**
     * Instance control for object serialization.
     *
     * @return The singleton instance of None.
     * @see java.io.Serializable
     */
    private Object readResolve() {
        return INSTANCE;
    }
}