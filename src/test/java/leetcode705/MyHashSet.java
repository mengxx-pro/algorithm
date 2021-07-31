package leetcode705;

/**
 * @program: algorithm
 * @description:
 *
 * @author: mengxiangxing
 * @create: 2021-07-18 15:01
 **/
class MyHashSet {

  //质数用来取余尽量少的可能性，参考了官方给的参考值，暂时不明白为啥是769
  int base = 769;

  //节点数组，用于存放key值的node数组
  Node[] nodes =new Node[10009];

  /** Initialize your data structure here. */
  public MyHashSet() {

  }

  class Node {
    int key;
    Node next;
    public Node(int key){
      this.key=key;
    }
  }

  //新增的时候先根据key的取余来算出所在node的坐标值，在这个坐标上是一个节点node，node里可能存在多个值
  //因为对key进行取余是可能存在重复的
  public void add(int key) {
    int index = getIndex(key);

    Node tempNode = nodes[index];
    Node preNode = null;
    if(tempNode==null){
      nodes[index]=new Node(key);
      return;
    }

    while(tempNode!=null){
      if(tempNode.key==key){
        return ;
      }
      preNode =tempNode;
      tempNode = tempNode.next;
    }
    preNode.next = new Node(key);
    return ;
  }

  public void remove(int key) {
    int index = getIndex(key);

    Node tempNode = nodes[index];

    if(tempNode==null){
      return ;
    }

    Node preNode=null;
    while(tempNode!=null){
      if(key==tempNode.key){
        if(preNode==null){
          nodes[index]=tempNode.next;
        }else{
          preNode.next=tempNode.next;
        }
        return;
      }
      preNode =tempNode;
      tempNode = tempNode.next;
    }

  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int index = getIndex(key);

    Node tempNode = nodes[index];

    if(tempNode==null){
      return false;
    }

    while(tempNode!=null){
      if(key==tempNode.key){
        return true;
      }
      tempNode = tempNode.next;
    }
    return false;
  }

  private int getIndex(int val){
    return val % base;
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */