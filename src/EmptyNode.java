/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the EmptyNode class.
 ******/

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * The EmptyNode class represents an empty node in an ADT list.
 *
 * @param <T> The type of data stored in the node.
 */
public class EmptyNode<T> implements INode<T> {

    /**
     * Counts the number of elements in an empty node.
     *
     * @return The number of elements in an empty node.
     */
    @Override
    public int count() {
        return 0;
    }

    /**
     * A generic count method that uses fold
     *
     * @param initial    The initial count value.
     * @param accumulator The function to accumulate the count.
     * @return The final count value.
     */
    @Override
    public <R> R foldCount(R initial, BiFunction<R, T, R> accumulator) {
        return initial;
    }

    /**
     * Retrieves an element from the empty node at given position.
     *
     * @param position The position of the element to retrieve.
     * @return The element at given position.
     */
    @Override
    public T getNode(int position) {
        return null;
    }

    /**
     * Removes an element from the empty node at given position.
     *
     * @param position The position of the element to remove.
     * @return An empty node.
     */
    @Override
    public INode<T> removeNode(int position) {
        return this;
    }

    /**
     * Converts the node from type T to R and return a new node
     *
     * @param converter the function needed to convert T into R.
     * @return The head of the new list.
     */
    @Override
    public <R> INode<R> map(Function<T, R> converter) {
        return new EmptyNode<>();
    }

    /**
     * Returns nodes that satisfy a predicate.
     *
     * @param predicate A predicate that filters the nodes.
     * @return The nodes that satisfy a given predicate.
     */
    public INode<T> filter(Predicate<T> predicate) {
        return new EmptyNode<>();
    }

    /**
     * Advances to the next node.
     *
     * @return An empty node.
     */
    @Override
    public INode<T> advance() {
        return this;
    }

    /**
     * Checks if advancing to the next node is possible.
     *
     * @return Always returns false.
     */
    @Override
    public boolean canAdvance() {
        return false;
    }
}