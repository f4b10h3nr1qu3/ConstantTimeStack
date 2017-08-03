/**
 *
 */
package com.f4b10h3nr1qu3.stack;

import static org.hamcrest.core.Is.is;

import com.f4b10h3nr1qu3.stack.exception.EmptyStackException;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;

/**
 * jUnit Test for ConstantTimeStack class
 * @author Fabio Henrique<fhv4it@gmail.com>
 */

public class TestConstantTimeStack {

  @TestSubject
  ConstantTimeStack stack;

  @Test(expected = EmptyStackException.class)
  public void testPopEmptyStackException() {

    stack = ConstantTimeStack.getInstance();
    stack.pop();

  }

  @Test(expected = EmptyStackException.class)
  public void testGetMinEmptyStackException() {

    stack = ConstantTimeStack.getInstance();
    stack.getMin();

  }

  @Test
  public void testPush() {

    stack = ConstantTimeStack.getInstance();
    stack = ConstantTimeStack.getInstance();
    stack.push(99);
    Assert.assertThat(99, is(stack.getMin()));
    Assert.assertThat(99, is(stack.peek()));

    stack.push(400);
    Assert.assertThat(99, is(stack.getMin()));
    Assert.assertThat(400, is(stack.peek()));

  }

  @Test
  public void testPop() {

    stack = ConstantTimeStack.getInstance();
    stack.push(99);
    stack.push(400);

    Integer value = stack.pop();
    Assert.assertThat(400, is(value));
    Assert.assertThat(99, is(stack.getMin()));
    Assert.assertThat(99, is(stack.peek()));
  }

  @Test(expected = EmptyStackException.class)
  public void testPopEmptyStackExceptionAfterPopAll() {

    stack = ConstantTimeStack.getInstance();
    stack.push(88);
    stack.push(7);

    stack.pop();
    stack.pop();

    stack.pop(); // tree times will generate an exception.

  }

  @Test(expected = NullPointerException.class)
  public void testConstructorRequireNonNull() {
    Integer[] values = null;
    stack = ConstantTimeStack.getInstance(values);
  }

  @Test()
  public void testConstructor() {
    Integer[] values = {55, 78, 81};
    stack = ConstantTimeStack.getInstance(values);
    Assert.assertThat(55, is(stack.getMin()));
    Assert.assertThat(81, is(stack.peek()));

  }

  @Test(expected = EmptyStackException.class)
  public void testGetMinEmptyStackExceptionAfterPopAll() {

    stack = ConstantTimeStack.getInstance();
    stack.push(88);
    stack.push(7);

    stack.pop();
    stack.pop();

    stack.getMin();

  }

  // run all operation together.
  @Test
  public void all() {

    stack = ConstantTimeStack.getInstance();

    stack.push(3);
    Assert.assertThat(3, is(stack.getMin()));

    stack.push(5);
    Assert.assertThat(3, is(stack.getMin()));

    stack.push(2);
    Assert.assertThat(2, is(stack.getMin()));

    stack.push(1);
    Assert.assertThat(1, is(stack.getMin()));

    stack.pop();
    Assert.assertThat(2, is(stack.getMin()));

    stack.pop();
    Assert.assertThat(3, is(stack.getMin()));

    // test the top
    Assert.assertThat(5, is(stack.peek()));

  }
}
