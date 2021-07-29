package leetcode225;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
  Queue<Integer> queue =new LinkedList<>();
  Queue<Integer> queueTemp =new LinkedList<>();

  /** Initialize your data structure here. */
  public MyStack() {

  }

  /** Push element x onto stack. */
  //第一次直接入队列，后边的入到temp队列，然后把正式队列依次取出放到temp队列，
  //temp队列即为倒序队列，temp复制到正式队列中，temp置空等待下一次操作
  public void push(int x) {
    if (queue.isEmpty()) {
      queue.offer(x);
    } else {
      queueTemp.offer(x);
      while (!queue.isEmpty()) {
        queueTemp.offer(queue.poll());
      }
      queue = queueTemp;
      queueTemp=new LinkedList<>();
    }
  }

  /** Get the top element. */
  //由于队列为倒序，直接按照队列的操作就是栈的操作
  public int top() {
    return queue.peek();
  }

  /** Removes the element on top of the stack and returns that element. */
  //由于队列为倒序，直接按照队列的操作就是栈的操作
  public int pop() {
    return queue.poll();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return queue.isEmpty();
  }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */