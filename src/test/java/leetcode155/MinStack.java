package leetcode155;

import java.util.Stack;

class MinStack {

  Stack stack = new Stack();
  Stack stackTemp = new Stack();

  /** initialize your data structure here. */
  public MinStack() {

  }

  public int getMin() {
    return (int) stackTemp.peek();
  }

  public void pop() {
    stack.pop();
    stackTemp.pop();
  }

  public void push(int val) {
    stack.push(val);
    if (stackTemp.isEmpty() || val < (int) stackTemp.peek()) {
      stackTemp.push(val);
    } else {
      stackTemp.push(stackTemp.peek());
    }
  }

  public int top() {
    return (int) stack.peek();
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */