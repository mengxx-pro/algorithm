package leetcode232;

import java.util.Stack;

public class MyQueue {

  Stack stack =new Stack();

  Stack tempStack =new Stack();

  /** Initialize your data structure here. */
  public MyQueue() {

  }

  /** Push element x to the back of queue. */
  //题目中push操作与栈的push一致
  public void push(int x) {
    stack.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  //pop操作正好与栈的pop相反，所以把栈的元素都push进另一个栈，另一个栈的pop就是题目的pop了
  public int pop() {
    while (!stack.isEmpty()){
      tempStack.push(stack.pop());
    }
    int popValue = (int) tempStack.pop();
    while (!tempStack.isEmpty()){
      stack.push(tempStack.pop());
    }
    return popValue;
  }

  /** Get the front element. */
  //同样在另一个栈里peek
  public int peek() {
    while (!stack.isEmpty()){
      tempStack.push(stack.pop());
    }
    int popValue = (int) tempStack.peek();
    while (!tempStack.isEmpty()){
      stack.push(tempStack.pop());
    }
    return popValue;
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
        return stack.isEmpty();
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */