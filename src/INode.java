/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the INode interface.
 ******/

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * The INode interface represents a node in a linked list.
 *
 * @param <T> The type of data stored in the node.
 */
public interface INode<T> {

    /**
     * Counts the number of nodes in the list.
     */
    int count();

    /**
     * A generic count method that uses fold
     *
     * @param initial    The initial count value.
     * @param accumulator The function to accumulate the count.
     */
    <R> R foldCount(R initial, BiFunction<R, T, R> accumulator);

    /**
     * Retrieves the node at a given position.
     *
     * @param position The position of the node.
     */
    T getNode(int position);

    /**
     * Removes the node at a given position.
     *
     * @param position The position of the node.
     */
    INode<T> removeNode(int position);

    /**
     * Converts the nodes from type T to R and return a new list
     *
     * @param converter the function needed to convert T into R.
     */
    <R> INode<R> map(Function<T, R> converter);

    /**
     * Returns nodes that satisfy a predicate.
     *
     * @param predicate A predicate that filters the nodes.
     */
    INode<T> filter(Predicate<T> predicate);

    /**
     * Given this node, advance the iteration by one step
     * @return the advance node in the list, or itself if there is none
     */
    INode<T> advance();

    /**
     * Return if there is something else in this list.
     * @return true if there is something in this list, false otherwise
     */
    boolean canAdvance();
}
