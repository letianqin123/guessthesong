/******
 Name: Letian Qin
 Assignment: 5004 final project
 Date: 12/10/2023
 Notes: This file constructs the Node class.
 ******/

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * The Node class represents a node in the linked list.
 *
 * @param <T> The type of data in the node.
 */
public class Node<T> implements INode<T> {
    private T t;
    private INode<T> nextNode;

    /**
     * Constructs a Node with a given data and the next node.
     *
     * @param t         The data in the node.
     * @param nextNode  The next node in the linked list.
     */
    public Node(T t, INode<T> nextNode) {
        this.t = t;
        this.nextNode = nextNode;
    }

    /**
     * Retrieves the node at the given position.
     *
     * @param position The position of the node.
     * @return The node at the given position.
     */
    @Override
    public T getNode(int position) {
        if (position < 0 || position >= count()) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (position == 0) {
            return t;
        }
        return nextNode.getNode(position - 1);
    }

    /**
     * Counts the number of nodes in the linked list.
     *
     * @return The number of nodes in the list.
     */
    @Override
    public int count() {
        return 1 + nextNode.count();
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
        R result = accumulator.apply(initial, t);
        return nextNode.foldCount(result, accumulator);
    }

    /**
     * Removes the node at the given position.
     *
     * @param position The position of the node.
     * @return The new linked list.
     */
    @Override
    public INode<T> removeNode(int position) {
        if (position < 0 || position >= count()) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (position == 0) {
            return nextNode;
        } else {
            nextNode = nextNode.removeNode(position - 1);
            return this;
        }
    }

    /**
     * Converts the nodes from type T to R and return a new list
     *
     * @param converter the function needed to convert T into R.
     * @return The head of the new list.
     */
    @Override
    public <R> INode<R> map(Function<T, R> converter) {
        return new Node<>(converter.apply(t), nextNode.map(converter));
    }

    /**
     * Returns nodes that satisfy a predicate.
     *
     * @param predicate A predicate that filters the nodes.
     * @return The nodes that satisfy a given predicate.
     */
    public INode<T> filter(Predicate<T> predicate) {
        if (predicate.test(t)) {
            return new Node<>(t, nextNode.filter(predicate));
        } else {
            return nextNode.filter(predicate);
        }
    }

    /**
     * Advances to the next node in the linked list.
     *
     * @return The next node in the linked list.
     */
    @Override
    public INode<T> advance() {
        return this.nextNode;
    }

    /**
     * Checks if advancing to the next node is possible.
     *
     * @return true if there is a next node, false otherwise.
     */
    @Override
    public boolean canAdvance() {
        return true;
    }
}