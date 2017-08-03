/**
 * 
 */
package com.f4b10h3nr1qu3.stack;

import static java.util.Objects.requireNonNull;

import java.util.ArrayDeque;
import java.util.Deque;

import com.f4b10h3nr1qu3.stack.exception.EmptyStackException;

/**
 * A Stack that supports getMinimum() in O(1) time and O(1) extra space.
 * @author Fabio Henrique<fhv4it@gmail.com>
 */

public class ConstantTimeStack {

	// Use of Delegation instead of Inheritance to promote encapsulation and low-coupling.
	private Deque<Integer> stack;

	private Integer min;

	/**
	 * Constructor
	 */
	private ConstantTimeStack() {
		super();
		stack = new ArrayDeque<>();
	}

	/**
	 * Constructor
	 * 
	 * @param values - Array of Integer
	 */
	public static ConstantTimeStack getInstance(Integer... values) {
		return new ConstantTimeStack(values);
	}

	/**
	 * Constructor
	 */
	public static ConstantTimeStack getInstance() {
		return new ConstantTimeStack();
	}

	/**
	 * Constructor
	 * 
	 * @param values - Array of Integer
	 */
	private ConstantTimeStack(Integer... values) {
		this();
		requireNonNull(values, "[values] parameter can't be a null");
		for (Integer value : values) {
			this.push(value);
		}
	}

	/**
	 * The minimal element of stack.
	 * 
	 * @return The minimal element of stack - java.lang.Integer.
	 */
	public Integer getMin() {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}
		return min;
	}

	/**
	 * Add a new value to the stack.
	 * @param x - java.lang.Integer
	 */
	public void push(Integer x) {

		if (this.isEmpty()) {
			min = x;
			stack.push(x);

		} else if (x < min) {
			stack.push(x - min);
			min = x;
		} else {
			stack.push(x);
		}
		return;
	}

	/**
	 * Pops an element from the stack represented by this. In other words, removes
	 * and returns the first element of this, or throw EmptyStackException if
	 * this stack is empty - java.lang.Integer.
	 * 
	 * @return the element at the front of this stack (which is the top of the stack represented by this stack).
	 * @throws EmptyStackException - if this stack is empty.
	 * @see EmptyStackException
	 */
	public Integer pop() {

		if (this.isEmpty()) {
			throw new EmptyStackException();
		}

		Integer t = stack.pop();

		if (t < min) {
			Integer result = min;
			min = min - t;
			return result;
		} else {
			return t;
		}
	}

	/**
	 * Retrieves, but does not remove, the head of the stack represented by this
	 * stack, or throw EmptyStackException if this stack is empty.
	 * 
	 * @return the head of the queue represented by this stack - java.lang.Integer.
	 * @throws EmptyStackException - if this stack is empty.
	 * @see EmptyStackException
	 */

	public Integer peek() {

		if (isEmpty()) {
			throw new EmptyStackException();
		}

		Integer t = stack.peek();

		if (t < min) {
			return min;
		} else {
			return t;
		}
	}

	/**
	 * Returns a boolean that indicates if the stack is empty. Use before call
	 * pop(), peak(), getMin() to avoid get an exception.
	 * 
	 * @return true - if the stack is empty and false if is not.
	 */
	public boolean isEmpty() {
		return stack.isEmpty();
	}

}
