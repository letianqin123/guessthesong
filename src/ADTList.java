/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the ADTList class.
 ******/

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Iterator;

/**
 * This class represents an ADT for a generic list.
 * It allows adding, retrieving, and removing elements from the list.
 *
 * @param <T> The type of elements stored in the list.
 */
public class ADTList<T> implements Iterable<T> {
    private INode<T> data;

    /**
     * Constructs an ADTList with an empty node.
     */
    public ADTList() {
        data = new EmptyNode<T>();
    }

    /**
     * Private constructor for the map method.
     *
     * @param data The head node of the new list.
     */
    private ADTList(INode<T> data) {
        this.data = data;
    }

    /**
     * Adds an element to the list.
     *
     * @param item The element to be added to the list.
     */
    public void add(T item) {
        data = new Node<T>(item, data);
    }

    /**
     * Retrieves the element at the given position.
     *
     * @param position The position of the element.
     * @return The element at the given position.
     */
    public T get(int position) {
        if (position < 0 || position >= count()) {
            throw new IllegalArgumentException("Invalid position");
        }
        return data.getNode(position);
    }

    /**
     * Removes the element at the given position.
     *
     * @param position The position of the element.
     */
    public void remove(int position) {
        if (position < 0 || position >= count()) {
            throw new IllegalArgumentException("Invalid position");
        }
        data = data.removeNode(position);
    }

    /**
     * Counts the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    public int count() {
        return data.count();
    }


    /**
     * A generic count method that uses fold
     *
     * @param initial    The initial count value.
     * @param accumulator The function to accumulate the count.
     * @return The final count value.
     */
    public <R> R foldCount(R initial, BiFunction<R, T, R> accumulator) {
        return data.foldCount(initial, accumulator);
    }


    /**
     * Converts the nodes from type T to R and return a new list
     *
     * @param converter the function needed to convert T into R.
     * @return The head of the new list.
     */
    public <R> ADTList<R> map(Function<T, R> converter) {
        return new ADTList<>(data.map(converter));
    }

    /**
     * Returns a new list of nodes that satisfy a predicate.
     *
     * @param predicate A predicate that filters the nodes.
     * @return The nodes that satisfy a given predicate.
     */
    public ADTList<T> filter(Predicate<T> predicate) {
        return new ADTList<>(data.filter(predicate));
    }

    /**
     * Iterator for traversing the elements in the list.
     */
    private class ADTListIterator<T> implements Iterator<T> {
        private INode<T> current;

        /**
         * Constructs an iterator with the given data.
         *
         * @param data The data to iterate over.
         */
        private ADTListIterator(INode<T> data) {
            current = data;
        }

        /**
         * Checks if there is a next element.
         *
         * @return true if there is a next element, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return current.canAdvance();
        }

        /**
         * Retrieves the next element.
         *
         * @return The next element.
         */
        @Override
        public T next() {
            T value = current.getNode(0);
            current = current.advance();
            return value;
        }
    }

    /**
     * Returns an iterator for traversing the elements in the list.
     *
     * @return An iterator for the list.
     */
    @Override
    public Iterator<T> iterator() {
        return new ADTListIterator(data);
    }
}
